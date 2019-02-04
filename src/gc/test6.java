package gc;

/**
 * Created by YJY on 2018/9/21.
 */
public class test6 {

    public static void main(String[] args) {
        Factory carfctory = CarFactorys.getCarFactory();
        Car car = (Car) carfctory.creat();


    }
}


class CarFactorys {
    private static Factory carFactory = new CarFactory();
    private static Factory superCarFactory = new SuperCarFactory();

    public static Factory getCarFactory() {
        return carFactory;
    }
    public static Factory getSuperCarFactory() {
        return superCarFactory;
    }

    private static class CarFactory implements Factory {

        @Override
        public Machine creat() {
            return new Car();
        }
    }

    private  static class SuperCarFactory extends CarFactory {
        @Override
        public Machine creat() {
            return new SuperCar();
        }
    }
}


interface Factory {
    public Machine creat();
}


class SuperCar extends Car {

}

class Car implements Machine {

    private int maxLife;

    @Override
    public boolean isAvailable() {
        if (maxLife <= 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void run(Human human) throws InterruptedException {
        if (human.isHaveDrivingLicense()) {
            System.out.println("run......");
            Thread.sleep(2000);
            maxLife--;
        } else {
            System.out.println("you haven't got DL");
        }
    }

    @Override
    public void stop(Human human) {

    }
}

interface Machine {
    public boolean isAvailable();

    public void run(Human human) throws InterruptedException;

    public void stop(Human human);
}

interface Human {
    public boolean isHaveDrivingLicense();
}