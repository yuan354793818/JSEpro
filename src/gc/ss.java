package gc;

public class ss {

    public static void main(String[] args) {
        printStackName();
        new ss().run1();
    }


    public void run1() {
        printStackName();
        run2();
    }

    private void run2() {
        printStackName();
    }

    public static void   printStackName() {
        for (StackTraceElement e:Thread.currentThread().getStackTrace()){
            System.out.println(e);
        }
    }
}
