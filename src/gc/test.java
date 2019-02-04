package gc;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by YJY on 2018/9/21.
 */
public class test {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println(getName());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.currentThread().setName("i'm mainThread");
        System.out.println(  Thread.currentThread().getName());
    }

}


class Demo extends Thread {
    private String name;

    Demo(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(name);
        }
    }
}


class Demo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" runnableImpllement");
        }

    }
}

