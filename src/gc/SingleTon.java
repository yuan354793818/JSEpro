package gc;

public class SingleTon {

    private static SingleTon singleTon = new SingleTon(); //count1=1,count2=1
    public static int count1;
    public static int count2 = 99;   //覆盖之前的count2=0

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    public static void main(String[] args) {
        SingleTon singleTon = null;
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
