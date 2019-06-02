package noclassify;

import java.lang.reflect.Method;

public class ExecptionThrowTest {
    public static void main(String[] args) {
        try {



            Method md = ExecptionThrowTest.class.getMethod("run1");
            md.invoke(null, null);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void run1(){
        try {
            int i = 9 / 0;
        } catch (Exception e) {
            throw new RuntimeException("最里面错误", e);
        }
    }
}
