package gc;

/**
 * Created by YJY on 2018/9/21.
 */
public class test5 {
     public  static int  sycnValue=0;
     //public  static  gc.keyDemo keyth=new gc.keyDemo();
   public static void do1(keyDemo keyth){
       synchronized (keyth){
          keyth.value++;
           System.out.println("do1    "+keyth.value);
       }
   }

   public static void do2(keyDemo keyth){
       synchronized (keyth){
           keyth.value++;
           System.out.println("do2    "+keyth.value);
       }

   }

    public static void main(String[] args) {
       keyDemo keyDemo=new keyDemo();
        new Thread(){
            public void run(){
                int i=0;
                while (i<100){
                    test5.do1(keyDemo);
                    i++;
                }

            }
        }.start();
        new Thread(){
            public void run(){
                int i=0;
                while (i<100){
                    test5.do2(keyDemo);
                    i++;
                }
            }
        }.start();
    }
}


class  keyDemo{
    public int value=0;
}

