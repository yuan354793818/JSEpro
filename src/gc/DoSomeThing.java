package gc;

public class DoSomeThing {
    public static void main(String[] args) throws InterruptedException {
        DoSomeThing thing = new DoSomeThing();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thing.doWhile();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    thing.doRun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public void doRun() throws InterruptedException {
        synchronized (this) {
            long sta = System.currentTimeMillis();
            this.wait(1000);
            long end = System.currentTimeMillis();
            System.out.println(end-sta);
        }
    }

    public void doWhile() throws InterruptedException {
        synchronized (this) {
            int i=0;
            while (i<4){
                Thread.sleep(2000);
                System.out.println("dowhile....");
                i++;
            }
        }
    }
}
