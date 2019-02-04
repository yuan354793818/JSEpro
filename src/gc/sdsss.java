package gc;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by YJY on 2018/9/22.
 */
public class sdsss {
    public static void main(String[] args) throws IOException {
        Timer timer=new Timer();
        timer.schedule(new timerDemo(),2000,3000);
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class timerDemo extends TimerTask{

    @Override
    public void run() {
        System.out.println("dodododo");
    }
}