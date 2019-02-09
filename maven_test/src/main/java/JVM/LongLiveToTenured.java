package JVM;

public class LongLiveToTenured {
    public static final int _1MB=1024*1024;
    public static void testAllocation() {
        byte[] a1,a2,a3;
        a1=new byte[_1MB/4];
        a2=new byte[4*_1MB];
       a3=new byte[4*_1MB];
       a3=null;
      a3=new byte[4*_1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
