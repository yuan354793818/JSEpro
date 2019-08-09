package noclassify;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AbstractDemo {
    public static void main(String[] args) {
        MonoPlay p = (MonoPlay) Proxy.newProxyInstance(AbstractMono.class.getClassLoader(), AbstractMono.class.getSuperclass(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
       // System.out.println(Arrays.toString(MonoImpl.class.getInterfaces()));
    }
    
    @Test
    public void test18() throws IllegalAccessException, InstantiationException {
        CGlibAdvice advice=new CGlibAdvice();
        MonoPlay monoPlay= (MonoPlay) advice.getInstance( MonoImpl.class.newInstance());
    }

    @Test
    public void test29() {
        System.out.println(Arrays.toString(MonoPlay.class.getInterfaces()));
    }
}


class MonoImpl extends  AbstractDemo{

}

class AbstractMono implements MonoPlay {

    @Override
    public void run() {

    }

}


interface MonoPlay {
    void run();
}


interface MonoGo{
    void dosm();
}

class CGlibAdvice implements MethodInterceptor{

    private  Object target;

    public Object getInstance(Object target) throws IllegalAccessException, InstantiationException {
        this.target=target;
        Class<?> aClass = this.target.getClass();
        Enhancer enhancer=new Enhancer();
        if (aClass.getSuperclass()!=Object.class){
            Class<?>[] interfaces = aClass.getSuperclass().getInterfaces();
            enhancer.setSuperclass(getInstance(aClass.getSuperclass().newInstance()).getClass());
        }else {
            enhancer.setSuperclass(aClass);
        }
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}