package gc;

public class ThreadLocalDemo {

    public static ThreadLocal<String> local=new ThreadLocal<>();

    public static void main(String[] args) {


/* Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal<String> threadLocal1=new ThreadLocal<>();
                threadLocal1.set("yjy");
                System.out.println(threadLocal1.get().toString());
                ThreadLocal<String> threadLocal2=new ThreadLocal<String>();
                threadLocal2.set("aaaa");
                System.out.println(threadLocal2.get().toString());
            }
        });

        thread1.start();*/

        local.set("sds");


    }
}
