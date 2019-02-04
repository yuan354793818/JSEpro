package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by YJY on 2018/9/23.
 */
public class ProxyDemo {
    public static void main(String[] args) {
            Student student=new Student();
            InvocationHandlerDemo ihd=new InvocationHandlerDemo(student);
            Person proxy= (Person) Proxy.newProxyInstance(Student.class.getClassLoader(),student.getClass().getInterfaces(),ihd);
            proxy.work();
            proxy.run();

    }
}

class InvocationHandlerDemo implements InvocationHandler{
    private  Student person;

    public InvocationHandlerDemo(Student person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("authenticating>>>>>>>>>>");
        method.invoke(person,args);
        System.out.println(method.getName());
        System.out.println("logging>>>>>>>>>>>>>>>>>");
        return null;
    }
}


interface  Person{
    public void work();
    public void run();
}


class  Student implements Person{
    @Override
    public void work() {
        System.out.println("studying>>>>");
    }

    public void run(){
        System.out.println("rurunrun>>>>");
    }
}
