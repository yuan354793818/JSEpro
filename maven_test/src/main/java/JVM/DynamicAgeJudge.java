package JVM;

public class DynamicAgeJudge {
    public static final int _1MB=1024*1024;
    public static void testAllocation() {
        byte[] a1,a2,a3,a4,a5;
        a1=new byte[_1MB/4];
        a4=new byte[_1MB/4];
        a2=new byte[4*_1MB];
        a3=new byte[4*_1MB];
        a3=null;
        a3=new byte[4*_1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
