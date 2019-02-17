package JVM;

public class 验证当前类加载器是当前线程中的contextClassLoader {
    public static void main(String[] args) {
        TestObj testObj = new TestObj();
        ClassLoader c1 = testObj.getClass().getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(c1==contextClassLoader);
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