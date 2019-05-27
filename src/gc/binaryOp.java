package gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class binaryOp {
    public static void main(String[] args) {
        List<Person1> list = new ArrayList();
        list.add(new Person1(1, "haha"));
        list.add(new Person1(2, "rere"));
        list.add(new Person1(3, "fefe"));
        Map<String, Person1> mapp = list.stream().collect(Collectors.toMap(Person1::getName, person ->person,(first,second)->second));
    }
}


class Person1{
    private  int age;
    private String name;

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}