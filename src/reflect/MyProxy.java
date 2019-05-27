package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by YJY on 2018/9/23.
 */
public class MyProxy {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Farmer farmer = new Farmer();
        MyProxyHandler mph = new MyProxyHandler();
        MyProxyDemo myProxyDemo = new MyProxyDemo(farmer, mph);
        System.out.println(myProxyDemo.doTask("maidongxi",5,7));
    }
}


class MyProxyDemo {
    private Object object;
    private ProxyHandlerDemo phdd;

    /**
     * @param s 被代理对象
     * @param p 代理执行的任务
     */
    public MyProxyDemo(Object s, ProxyHandlerDemo p) {
        this.object = s;
        this.phdd = p;
    }
    /**
     * @param methodName
     * @param arg
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object doTask(String methodName, Object... arg) throws InvocationTargetException, IllegalAccessException {

        phdd.proxyDoCheck(object, methodName, arg);
        Object result = null;
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals(methodName)) {
                int pCount = methods[i].getParameterCount();
                int length = arg.length;
                if (pCount == length) {
                    result = methods[i].invoke(object, arg);
                    break;
                }
            }
        }
        phdd.proxyDoAnalyze(object, methodName, result, arg);

        return result;
    }
}

interface ProxyHandlerDemo {
    public Object proxyDoCheck(final Object obj, String methodName, Object...arg);

    public Object proxyDoAnalyze(final Object obj, String methodName, Object result , Object...arg);

}

class MyProxyHandler implements ProxyHandlerDemo {
    @Override
    public Object proxyDoCheck(final Object obj, String methodName, Object...arg) {

        System.out.println("proxy do else CHECK");
        return null;
    }

    public Object proxyDoAnalyze(final Object obj, String methodName, Object result, Object...arg) {

        System.out.println("proxy do else ANALYZE");
        return null;
    }
}


class Farmer {
    public int zhongtian(Integer days) {
        System.out.println("do " + days + " days");
        return days * 100;
    }

    public int maidongxi(int price, int count) {
        return price * count;
    }
    public int maidongxi(int count) {
        return count;
    }
}
