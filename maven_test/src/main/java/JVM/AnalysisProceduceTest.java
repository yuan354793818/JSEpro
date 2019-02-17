package JVM;

public class AnalysisProceduceTest {
    public static void main(String[] args) {
        Integer a = Ch.a;

    }
}

interface M1{
    static Integer a=0;
}
interface M2{
    static  Integer a=0;
}

class Fa{
   static Integer a;
}


class Ch extends Fa  implements M1{
    static Integer a;
}