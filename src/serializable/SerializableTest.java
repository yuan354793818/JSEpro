package serializable;

import org.junit.Test;

import java.io.*;

public class SerializableTest {
    @Test
    public void test1() throws IOException {
        Apple apple=new Apple(998,"apple");
        OutputStream os=new FileOutputStream(new File("d:\\apple.java"));
        ObjectOutputStream oos=new ObjectOutputStream(os);
        oos.writeObject(apple);
        oos.close();
        os.close();
    }

    @Test
    public void test2() throws ClassNotFoundException, IOException {
        InputStream is=new FileInputStream(new File("d:\\apple.java"));
        ObjectInputStream ois=new ObjectInputStream(is);
        Apple o = (Apple) ois.readObject();
        System.out.println(o);

        ois.close();
        is.close();
    }

}


class Apple implements Serializable {
    private int price;
    transient private String name;

    public Apple(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
