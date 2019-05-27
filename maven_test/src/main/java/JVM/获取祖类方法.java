package JVM;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class 获取祖类方法 {
    public static class Gfa{
        void think() {
            System.out.println("i'm GrandFather");
        }
    }


    public static class Fa extends Gfa{
        void think() {
            System.out.println("i'm Father");
        }
    }

    public static class Son extends Fa{
        void think() {
            try {
                //MethodHandles.lookup().findVirtual(Gfa.class, "think", MethodType.methodType(void.class)).bindTo(new Gfa()).invoke();
                MethodHandles.lookup().findSpecial(Gfa.class, "think", MethodType.methodType(void.class),Son.class).invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Son().think();
    }
}
