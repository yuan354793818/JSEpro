package reflect;

public class GetMethodName {
    public static void main(String[] args) {
            new bbb().func1();
    }
}


class aaa{

}


class bbb extends aaa{
    public void func1() {

        String name = new Object().getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }
}