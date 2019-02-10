package JVM;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderAndWriter {
    public static void main(String[] args) {
        final ReaderAndWriter readerAndWriter = new ReaderAndWriter();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        readerAndWriter.read();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        readerAndWriter.read();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        readerAndWriter.read();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        readerAndWriter.write();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        readerAndWriter.write();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        readerAndWriter.write();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static int count = 0;

    private int AR = 0;
    private int AW = 0;
    private int WR = 0;
    private int WW = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition okToRead = lock.newCondition();
    private Condition okToWrite = lock.newCondition();

    public void read() throws InterruptedException {
        lock.lock();
        while (AW + WW > 0) {
            WR++;
            okToRead.await();
            WR--;
        }
        AR++;
        System.out.println("READING " + AR);
        lock.unlock();

        Thread.sleep(100);
        System.out.println("read is :" + count);


        lock.lock();
        AR--;
        if (AR == 0 && WW > 0) {
            okToWrite.signal();
        }
        lock.unlock();
    }

    /**
     * @throws InterruptedException
     */
    public void write() throws InterruptedException {
        lock.lock();
        while (AR + AW > 0) {
            WW++;
            okToWrite.await();
            WW--;
        }
        AW++;
        System.out.println("WRITING "+AW);
        System.out.println("WW "+WW);

        lock.unlock();

        Thread.sleep(1000);
        System.out.println("write is :" + ++count);

        lock.lock();
        AW--;
        if (WW > 0) {
            okToWrite.signal();
        } else if (WR > 0) {
            okToRead.signalAll(); //通知所有wait Read
        }

        lock.unlock();
    }

      public void go() throws InterruptedException {
        new Object().wait();

    }
}
