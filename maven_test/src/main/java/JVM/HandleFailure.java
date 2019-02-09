package JVM;

public class HandleFailure {
    public static final int _1MB=1024*1024;
    public static void testAllocation() {
        byte[] a1,a2,a3,a4,a5,a6,a7;
        a1=new byte[2*_1MB];
        a2=new byte[2*_1MB];
        a3=new byte[2*_1MB];
        a4=new byte[2*_1MB];
        a5=new byte[2*_1MB];
        a6=new byte[2*_1MB];
        a7=new byte[2*_1MB];

    }

    public static void main(String[] args) {
        testAllocation();
    }
}
