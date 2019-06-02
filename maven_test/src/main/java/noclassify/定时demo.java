package noclassify;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class 定时demo {

    @Test
    public void test4() {        //实现先后顺序执行，遇到异常不捕获会终止所有任务
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1);
            }
        },300,1000 );

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    int a=1/0;
                    System.out.println(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },400,2000 );

        while (true);
    }

    @Test
    public void test34() throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor service=new ScheduledThreadPoolExecutor(10);
        service.scheduleAtFixedRate(() -> {
            System.out.println(1);
        },200,1000,TimeUnit.MILLISECONDS);
        service.scheduleAtFixedRate(() -> {
            System.out.println(2);
            int a = 9 / 0;
        }, 300, 1000, TimeUnit.MILLISECONDS);

        ScheduledFuture<String> schedule = service.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    int i = 9 / 0;
                } catch (Exception e) {
                    return e.getMessage();
                }
                System.out.println(99);
                return "success";
            }
        }, 200, TimeUnit.MILLISECONDS);

        System.out.println(schedule.get());
        while (true);
    }

    @Test
    public void test63() throws SchedulerException, InterruptedException { //要配日志
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 开始

        // job 唯一标识 test.test-1
        JobKey jobKey = new JobKey("test" , "test-1");
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity(jobKey).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("test" , "test")
                // 延迟一秒执行
                .startAt(new Date(System.currentTimeMillis() + 1000))
                // 每隔一秒执行 并一直重复
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail , trigger);

        scheduler.start();
       while (true);
    }

    public class TestJob implements Job{
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println("sdsd");
        }
    }

}
