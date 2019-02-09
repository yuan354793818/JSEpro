package JVM;

public class JavaVMStackSOF {
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeck();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("STACK LENGTH: "+oom.stackLength);
        }
    }

    private int stackLength=1;

    public void stackLeck() {
        stackLength++;
        stackLeck();
    }
}
