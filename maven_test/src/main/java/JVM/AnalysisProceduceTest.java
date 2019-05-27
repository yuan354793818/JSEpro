package JVM;

public class AnalysisProceduceTest {
    public static void main(String[] args) {
        Integer a = Ch.a;

    }
}

interface M1{
     int a=0;
}
interface M2 extends M1{
    int a=0;
}
interface M3 {
    int a=0;
}

class Fa implements M2{
   static int a;
}


class Ch extends Fa  implements M3{
    static int a;
}