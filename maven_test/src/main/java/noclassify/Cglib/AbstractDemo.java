package noclassify.Cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AbstractDemo {
    public static void main(String[] args) {
        MonoPlay p = (MonoPlay) Proxy.newProxyInstance(AbstractMono.class.getClassLoader(), new Class[]{AbstractMono.class.getSuperclass()}, new InvocationHandler() {
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
        MonoImpl monoPlay= (MonoImpl) advice.getInstance( MonoImpl.class.newInstance());
       monoPlay.run();
    }

    @Test
    public void test29() {
//        System.out.println(Arrays.toString(AbstractMono.class.getInterfaces()));
//        System.out.println(MonoImpl.class.getSuperclass());

        MonoPlay l=new MonoImpl();
        l.run();
    }
}




class CGlibAdvice implements MethodInterceptor{

    private  Object target;

    public Object getInstance(Object target) throws IllegalAccessException, InstantiationException {
        this.target=target;
        Class<?> aClass = this.target.getClass();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(aClass);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>>>>>>>>>>");
        //methodProxy.invoke();
        methodProxy.invoke(target,objects);
        System.out.println("<<<<<<<<<<<<");
        return null;
    }
}