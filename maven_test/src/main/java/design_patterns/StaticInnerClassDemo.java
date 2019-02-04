package design_patterns;

public class StaticInnerClassDemo {
    public static void main(String[] args) {

        Class<? extends SingletonDemo> aClass = SingletonDemo.class.asSubclass(SingletonDemo.class);

        System.out.println(  SingletonDemo.class.isAssignableFrom(Object.class));

    }
}


final class  SingletonDemo {

    private SingletonDemo(){
        SingletonDemo demo = singClass.demo;
    }

    private static class  singClass{
        {
            System.out.println("new init");
        }

        static {
            System.out.println("static init");
        }

        private static SingletonDemo demo=new SingletonDemo();
    }

    public static void run() {
        SingletonDemo demo = singClass.demo;

    }

}