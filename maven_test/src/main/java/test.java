
public class test {
    public static void main(String[] args) {
       Sample sample1=new Sample();
        Sample sample2=sample1;
    }
}

class Sample{
    public int run(int a,int b) {
        int c=a*b;
        int x=99;
        int y=88;
        int sum=x*y;
        c=sum*c;

        int l=1092;

        c=c+l*l;
        return c;
    }
}