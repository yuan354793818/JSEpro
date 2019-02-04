package gc;

/**
 * Created by YJY on 2018/9/21.
 */
public class test8 {
    public static String a1="1";
    public static String a2="2";
    public static void main(String[] args) {
        new Thread(){
            public void  run(){
                while (true){
                    synchronized (a1){
                        System.out.println("get   a1 wait a2");
                        synchronized (a2){
                            System.out.println("get a2  do eat");
                        }
                    }
                }
            }
        }.start();
        new Thread(){
            public void  run(){
                while (true){
                    synchronized (a2){
                        System.out.println("get   a2 wait a1");
                        synchronized (a1){
                            System.out.println("get a1  do eat");
                        }
                    }
                }
            }
        }.start();
    }
}

