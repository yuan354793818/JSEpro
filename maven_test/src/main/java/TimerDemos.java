import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemos {

    @Test
    public void test4() {
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
}
