package gc;

import java.lang.reflect.InvocationTargetException;

public class GetRootCauseTest {
    public static void main(String[] args) {


                    try {
                        Dodo.class.getMethod("run", int.class).invoke(new Dodo(),11);
                    } catch (IllegalAccessException | NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        System.out.println(cause);
                        //e.printStackTrace();
                    }


    }
}


class Dodo{
    public int run(int x) {
        int a= x/0;
        return a;
    }
}