package gc;

/**
 * Created by YJY on 2018/9/21.
 */
public class test4 {
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);
    }
}

final class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }
}
final class SingletonBeta {
    private static SingletonBeta singleton=null;
    private SingletonBeta(){}

    public static SingletonBeta getInstance(){
        if (singleton==null){
            singleton=new SingletonBeta();
        }
        return singleton;
    }
}