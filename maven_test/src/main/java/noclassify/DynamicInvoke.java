package noclassify;

public class DynamicInvoke {
    public static void main(String[] args) {
        String simpleName = yuan1995.class.getSimpleName();
        System.out.println(simpleName);
        System.out.println(isExist("3fgdd"));
    }

    public static boolean isExist(String s) {
        String s1 = s.intern();

        return s1 == null ? s == null : s1.equals(s);
    }
}

class yuan1995{

}