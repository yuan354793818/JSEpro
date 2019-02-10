package JVM;

class Price {
    static  Price P = new Price(2.7);
    static double apple = 20;//加上final后 输出结果为17.3
    //static  Price P = new Price(2.7);  加在这不加final 也是17.3 static按照先后顺序执行
    double actp;

    public Price(double orange) {
        actp = apple - orange;
    }
}

public class ConstantValueTest {
    public static void main(String[] args) {
        System.out.println(Price.P.actp);//结果为-2.7

    }

}
/*这个程序中，在类加载阶段的准备阶段p和apple会被编译器赋予对应类型的默认初值（null和0.0），
在随后的类加载的初始化阶段，由于static字段执行顺序是由字段在源文件中出现的顺序决定的，所以会先执行new，
分配对象空间并对其做初始化，在这个时候apple的值还是0.0，所以最终结果为-2.7。

当使用final时，字面量20会在编译期加入Price类的常量池中的CONSTANT_Double_info，
在遇到final字段时，在编译时编译器将会为该静态属性赋予ConstantValue属性，
ConstantValue屬性的作用是通知虚拟机自动为静态变量赋值 ，
对于类变量，有两种方式赋值：在类构造器<clinit>方法中或者使用ConstantValue属性，
具有该属性的静态字段将会在类加载的准备阶段被赋予所指定的的值。所以最终结果为17.3。
*/