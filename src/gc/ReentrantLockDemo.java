package gc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YJY on 2018/9/21.
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        inquerry inquerr = new inquerry();
        new Thread() {
            public void run() {
                while (true){
                    try {
                        inquerr.dosome1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        new Thread() {
            public void run() {
                while (true){
                    try {
                        inquerr.dosome2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread() {
            public void run() {
                while (true){
                    try {
                        inquerr.dosome3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

class inquerry {
    private int flag = 1;
    private ReentrantLock r=new ReentrantLock();
    private Condition cdn1=r.newCondition();
    private Condition cdn2=r.newCondition();
    private Condition cdn3=r.newCondition();

    public void dosome1() throws InterruptedException {
        r.lock();
            if (flag!=1) {
               cdn1.await();
            }
            System.out.print("1");
            System.out.print("2");
            System.out.print("3");
            System.out.print("4");
            System.out.println();
            flag = 2;
            cdn2.signal();
        r.unlock();

    }

    public void dosome2() throws InterruptedException {
       r.lock();
            if (flag!=2) {
                cdn2.await();
            }
            System.out.print("a");
            System.out.print("b");
            System.out.print("c");
            System.out.print("d");
            System.out.println();
            flag = 3;
            cdn3.signal();
        r.unlock();

    }
    public void dosome3() throws InterruptedException {
      r.lock();
            if (flag!=3) {
               cdn3.await();
            }
            System.out.print("@");
            System.out.print("&");
            System.out.print("%");
            System.out.print("!");
            System.out.println();
            flag = 1;
           cdn1.signal();
      r.unlock();

    }
}