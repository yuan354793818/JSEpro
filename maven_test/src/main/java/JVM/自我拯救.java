package JVM;

public class 自我拯救 {

    public static 自我拯救 me=null;

    public void isAlive() {
        System.out.println("I'm Alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        me=this;
    }

    public static void main(String[] args) throws InterruptedException {
        me = new 自我拯救();
        me=null;
        System.gc();
        Thread.sleep(500);
        if (me!=null){
            me.isAlive();
        }else {
            System.out.println("no ,i'm dead");
        }

        me=null;
        System.gc();
        Thread.sleep(500);
        if (me!=null){
            me.isAlive();
        }else {
            System.out.println("no ,i'm dead");
        }
    }
}


