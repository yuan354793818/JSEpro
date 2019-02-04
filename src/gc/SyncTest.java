package gc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {

    private ReentrantLock r = new ReentrantLock(true);
    private Condition cdn1=r.newCondition();

     public  void run() throws InterruptedException {
        r.lock();
        r.lockInterruptibly();
        this.notify();
        r.unlock();
    }
}
