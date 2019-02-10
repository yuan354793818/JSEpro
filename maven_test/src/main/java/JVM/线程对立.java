package JVM;

public class 线程对立 {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                    }
                }
            }
        });
        thread.start();
        while (true) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    thread.suspend();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    thread.resume();
                }
            }).start();

            while (Thread.activeCount()>20);
        }
    }
}
