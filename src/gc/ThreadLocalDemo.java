package gc;

public class ThreadLocalDemo {
    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocal threadLocal1=new ThreadLocal();
                threadLocal1.set("yjy");
                System.out.println(threadLocal1.get().toString());
                ThreadLocal threadLocal2=new ThreadLocal();
                threadLocal2.set("aaaa");
                System.out.println(threadLocal2.get().toString());
            }
        });

        thread1.start();



    }
}
