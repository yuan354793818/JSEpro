package JVM;

public  class TryCatchFinallyReTurnTest {

    public static void main(String[] args) {
        System.out.println(new TryCatchFinallyReTurnTest().run());
    }

    public int run() {
        int x;
        try {
            x=1;
            return x;
        } catch (Exception e) {
            x=2;
            return x;
        } finally {
            x=3;
        }
    }
}
