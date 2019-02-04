package gc;

import java.io.IOException;


public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        new Lady().run();
    }

    public static void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName("[I");
        System.out.println(c.toString());
        Class<Lady> aClass = (Class<Lady>) ClassLoader.getSystemClassLoader().loadClass("gc.Lady");
        Lady lady1 = aClass.newInstance();
        lady1.run();
    }
}

class Lady{
    public void run() {
        System.out.println("i'm lady");
        ClassLoader parent = this.getClass().getClassLoader().getParent();
        System.out.println(Long.class.getClassLoader());
    }
}
