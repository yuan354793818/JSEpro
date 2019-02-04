package gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by YJY on 2018/9/22.
 */
public class jsdsad {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Cars car = new Cars("bmw");
        Cars car1 = new Cars("qqq");
        ArrayList<Cars> list = new ArrayList<>();
        list.add(car);
        list.add(car1);
        ReferenceQueue<Cars> referenceQueue = new ReferenceQueue<>();
        WeakReference<Cars> weakCar = new MyWeakRef1<Cars>(car, referenceQueue);
        WeakReference<Cars> weakCar1 = new MyWeakRef1<Cars>(car1, referenceQueue);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (weakCar.get() != null) {
                    System.out.println(i++);
                }
                //System.out.println(list.get(0).name);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (weakCar1.get() != null) {

                }
                //System.out.println(list.get(0).name);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Cars cars = null;
                    MyWeakRef1<? extends Cars> ref = null;

                    if ((ref = (MyWeakRef1<Cars>) (referenceQueue.poll())) != null) {

                        System.out.println(ref.getName());

                    }
                }
            }
        }).start();
      /*while (true){
          //Thread.sleep(1000);
          if(weakCar.get()!=null){
              Thread.sleep(1000);
              System.out.println( weakCar.get().name);
          }else {
              //System.out.println("car has been collected!!!");
          }

      }*/


    }
}

class MyWeakRef1<T extends Cars> extends WeakReference<T> {

    private String name;

    public MyWeakRef1(T referent) {
        super(referent);
    }

    public MyWeakRef1(T referent, ReferenceQueue<? super T> q) {
        super(referent, q);
        name = referent.getName();
    }

    public String getName() {
        return name;
    }
}

class Cars {
    public String name;

    public Cars(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "name='" + name + '\'' +
                '}';
    }
}
