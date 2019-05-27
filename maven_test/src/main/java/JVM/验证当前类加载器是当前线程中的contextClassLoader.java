package JVM;

public class 验证当前类加载器是当前线程中的contextClassLoader {
    public static void main(String[] args) {
        ClassLoader objClassLoader = Object.class.getClassLoader();
        ClassLoader loader = 验证当前类加载器是当前线程中的contextClassLoader.class.getClassLoader();
        TestObj testObj = new TestObj();
        ClassLoader c1 = testObj.getClass().getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(c1);
    }
}



class TestObj{
    static {
        System.out.println("obj init !!!");
    }

    private  TestInnerCls innerCls;
}

class TestInnerCls{
    static {
        System.out.println("inner init !!!");
    }
    
}