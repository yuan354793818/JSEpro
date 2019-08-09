package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by YJY on 2018/9/23.
 */
public class ProxyDemo {
    public static void main(String[] args) {
//            Student student=new Student();
//            InvocationHandlerDemo ihd=new InvocationHandlerDemo(student);
//            Person proxy= (Person) Proxy.newProxyInstance(Student.class.getClassLoader(),Student.class.getInterfaces(),ihd);
//            proxy.work();
//            proxy.run();
//

        System.out.println(Arrays.toString(Student.class.getInterfaces()));
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
