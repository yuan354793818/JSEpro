package design_patterns;

public class FactoryDemo {
}


abstract class AbstractFactory{
    public abstract AbstractProduct1 getProduct1();
    public abstract AbstractProduct2 getProduct2();
}


interface Product{

}

abstract class AbstractProduct1 implements Product{

}

abstract class AbstractProduct2 implements Product{

}

class SportsCar1 extends AbstractProduct1{

}

class SportsCar2 extends AbstractProduct2{

}

class SportsCarFactory extends AbstractFactory{

    public AbstractProduct1 getProduct1() {
        return new SportsCar1();
    }

    public AbstractProduct2 getProduct2() {
        return new SportsCar2();
    }
}


class SuvFactory extends AbstractFactory{
    public AbstractProduct1 getProduct1() {
        return null;
    }

    public AbstractProduct2 getProduct2() {
        return null;
    }
}