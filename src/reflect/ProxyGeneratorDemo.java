package reflect;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by YJY on 2018/9/23.
 */
public class ProxyGeneratorDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        byte[] bytes = ProxyGenerator.generateProxyClass("shitProxy", Shit.class.getInterfaces());

        try {
            FileOutputStream fos = new FileOutputStream("D:/shitProxy.class");
            fos.write(bytes);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

interface Fly{
    void fly();
}

class Shit implements Fly{

    @Override
    public void fly() {
        System.out.println("shit flying");
    }
}