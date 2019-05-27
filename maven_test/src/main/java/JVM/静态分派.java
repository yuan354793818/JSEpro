package JVM;

import org.junit.Test;

import java.io.Serializable;

public class 静态分派 {
    static class Human {

    }


    static class Men extends Human {

    }

    static class Women extends Human {

    }


    public void sayHello(Human human) {
        System.out.println("i'm human");
    }

    public void sayHello(Men men) {
        System.out.println("i'm men");
    }

    public void sayHello(Women women) {
        System.out.println("i'm women");
    }

    public int sayHello() {
        return 0;
    }

    public static void sayHello(Comparable<Character> c) {
        System.out.println("i'm comparator");
    }

    public static void sayHello(Serializable serializable) {
        System.out.println("i'm serializable");
    }

    public static void doSome(double... args) {
        System.out.println("i'm L double");
        for (double d : args) {
            System.out.println(d);
        }
    }


    static {
        a=99;
    }

    static  int a=1;

    @Test
    public void test() {
        //sayHello('2');           ambiguous!!
        //doSome('2', 11);
       // System.out.println(a);

        int [][][] ary=new int[1][0][-1];
    }

    public static void main(String[] args) {
        静态分派 i = new 静态分派();
        Human human1 = new Human();
        Human human2 = new Men();
        Women human3 = new Women();

        i.sayHello(human1);
        i.sayHello(human2);
        i.sayHello(human3);

        i.sayHello(new Women());
    }


    public static void nullDispatch(Object o) {
        System.out.println("object");
    }

    public static void nullDispatch(char [] chars) {
        System.out.println("chars");
    }

    public static void nullDispatch(char s) {
        System.out.println("ints");
    }

    @Test
    public void test1() {
        nullDispatch(null); // 输出 chars 可见null优先静态分派为char[]
    }

}

