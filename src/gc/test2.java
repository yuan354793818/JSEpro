package gc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by YJY on 2018/9/21.
 */
public class test2 {
    public static void main(String[] args) {
        Cycle box=new sun();
        box.setName("yuanjiayu");
        Cycle cycle= (Cycle) Proxy.newProxyInstance(Cycle.class.getClassLoader(), sun.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                return method.invoke(box);
            }

        });
        cycle.boom();
        System.out.println(cycle.getName());
    }
}


interface Cycle{
    void boom();

    String getName();
    public void setName(String name);
}

class sun implements Cycle {


    private String name;

    public void setName(String name) {
        this.name=name;
    }
    @Override
    public void boom() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
