package guava;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception {

        Bag bag=new Bag();
        Bag nullbag=null;
        //Optional.ofNullable(bag).ifPresent(t->t.count=99);
         Optional.ofNullable(bag).orElse(new Bag());
        Optional.ofNullable(bag).orElseGet(Bag::new);
        Optional.ofNullable(bag).orElseThrow(Exception::new);
        Integer integer = Optional.ofNullable(nullbag).map(bag1 -> bag1.count).orElseGet(() -> 18343);

        System.out.println(bag.count);
        System.out.println(integer);

        String[] strings = {"sdsad", "sdasd", "1111"};

        Stream<String> stream = Arrays.stream(strings);

        BOX1 box1=new BOX1();



        //box1.setBox2(new BOX2());
        Optional<BOX2> box2 = Optional.ofNullable(box1).map(BOX1::getBox2);
        //box2.get();
        Optional<BOX1> box11 = Optional.ofNullable(box1).map(box -> box.getBox2()).map(box -> box.getBox1());
        box11.get();

        Optional<BOX2> box21 = Optional.ofNullable(box1).flatMap(b -> b.getBox21());


    }

    public static int getSum() {

        return 1;
    }



}


interface Box extends Consumer<Integer> {

    @Override
    void accept(Integer integer);
}

class Bag{
    @wowo(value ="whs",max = 10,min = 1)
    public Integer count =null;
    public Bag() {
        System.out.println(" book create");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface wowo{

    public String value();

    public int min() default 1;

    public int max() default 10;


}


class  BOX1{
    private BOX2 box2;

    public void say() {
        System.out.println("BOX1111");
    }


    public Optional<BOX2> getBox21() {
        return Optional.ofNullable(box2);
    }


    public BOX2 getBox2() {
        return box2;
    }

    public void setBox2(BOX2 box2) {
        this.box2 = box2;
    }
}

class BOX2{
    private BOX1 box1;

    public void say() {
        System.out.println("BOX2222");
    }

    public BOX1 getBox1() {
        return box1;
    }

    public void setBox1(BOX1 box1) {
        this.box1 = box1;
    }
}


class BOX3{
    public void say() {
        System.out.println("BOX3333");
    }
}