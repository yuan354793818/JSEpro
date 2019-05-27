package JVM;

public class JIToccurTest {
    public static final int NUM=15000;

    public static int doubleVal(int v) {
        return 2*v;
    }

    public static long calcSum() {
        long sum=0;
        for (int i = 0; i < 100; i++) {
            sum += doubleVal(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
