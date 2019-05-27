package gc;

import java.util.HashSet;
import java.util.Set;

public class MultiThreadLocal {
    public static ThreadLocal<Set<String>> threadLocal=new ThreadLocal<>();

     static {
        threadLocal.set(new HashSet<>());
    }

    public static void set(String s){
        if (threadLocal.get() == null) {
            threadLocal.set(new HashSet<>());
        }
        threadLocal.get().add(s);
    }

    public static String get(String s) {
        if (threadLocal.get() == null) {
            threadLocal.set(new HashSet<>());
        }
        if (threadLocal.get().contains(s)) {
            return s;
        }
       return null;
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        set("yuanjiayu");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {

                        System.out.println( get("yuanjiayu"));
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
