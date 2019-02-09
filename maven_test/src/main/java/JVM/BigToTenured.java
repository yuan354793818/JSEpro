package JVM;

public class BigToTenured {
    public static final int _1MB=1024*1024;
    public static void testAllocation() {
        byte[] a1;
        a1=new byte[5*_1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
