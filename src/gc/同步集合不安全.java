package gc;

import java.util.Vector;

public class 同步集合不安全 {

    public static Vector vector=new Vector();

    public static int count=0;
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }

                    }

                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.add(i);
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {

                        for (int i = 0; i < vector.size(); i++) {

                            System.out.println(   vector.get(i));;
                        }
                    }

                }
            }).start();

            System.out.println("count : "+Thread.activeCount());
            while (Thread.activeCount()>20);
        }

    }
}


