package reflect;

public class asSubClass {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        AA a = new AA();
        Class<?> child = a.getClass().asSubclass(AA.class);
        AA c = (AA) child.newInstance();
        System.out.println(AA.class.isAssignableFrom(child));
        c.run();
    }

}


class AA{
    public void run() {
        System.out.println("runrunrun!!!");
    }
}


