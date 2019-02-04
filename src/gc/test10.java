package gc;


import java.util.HashSet;
import java.util.Objects;

public class test10 {

    private Fruit fruit;

    public void todo(Fruit apple) {

    }

    public static void main(String[] args) {
        Fruit fruit1 = new Fruit("apple", 1);
        Fruit fruit2 = new Fruit("apple", 2);

        HashSet<Fruit> set = new HashSet<>();
        set.add(fruit1);
        set.add(fruit2);

        System.out.println(set);
    }


}


class Fruit {
    private String name;
    private int id;

    public Fruit(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fruit)){
            return false;
        }
        Fruit fruit = (Fruit) obj;
        return Objects.equals(this.id, fruit.id) && Objects.equals(this.name, fruit.name);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}