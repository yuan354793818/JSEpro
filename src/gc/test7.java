package gc;

/**
 * Created by YJY on 2018/9/21.
 */
public class test7 {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable mr = new MyRunnable();
        ThreadGroup g2 = new ThreadGroup("g2");
        Thread t1 = new Thread(g2, mr, "t1");
        Thread t2 = new Thread(g2, mr, "t2");
        Thread t3 = new Thread(g2, mr, "t3");
        Thread t4 = new Thread(g2, mr, "t4");
        t1.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println(g2.activeGroupCount());

        }

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runrun");
        }
    }
}
