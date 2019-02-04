package gc;

import java.util.Arrays;

public class cloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("yjy", 18,new String[]{"aaa,2222"});
        Person clone = p1.clone();
        System.out.println(clone.getChildren()==p1.getChildren());
        System.out.println(clone);
    }
}


class Person{
    private String name;
    private int age;
    private String [] children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public String[] getChildren() {
        return children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    public Person(String name, int age, String[] children) {
        this.name = name;
        this.age = age;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", children=" + Arrays.toString(children) +
                '}';
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return new Person(this.name, this.age,this.children.clone());
    }
}
