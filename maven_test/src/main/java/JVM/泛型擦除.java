package JVM;

import java.util.ArrayList;
import java.util.List;

public class 泛型擦除 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println( list.getClass());
    }

//    public static void method(List<String> list) {
//
//    }
//
//    public static void method(List<Integer> list) {
//
//    }

//    public static int method(List<String> list) {
//    return 990;
//    }
//
//    public static String method(List<Integer> list) {
//        return "";
//    }


    public static String getInfo(List<Character> characters) {
        return "";
    }
}
