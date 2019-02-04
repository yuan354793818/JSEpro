package design_patterns;


public class Test {
    public static void main(String[] args) {
        Pig pig=new Pig();
        pig.run();

    }
}

class Animal{
    public Animal() {
      //  System.out.println("animal cons");
    }

    public void run() {

        System.out.println("animal run");
    }
}

class Pig extends  Animal{
    public Pig() {
        //System.out.println("pig cons");
    }

    @Override
    public void run() {
        super.run();
        System.out.println(this.getClass().getSimpleName());
        System.out.println("pig run");
    }
}