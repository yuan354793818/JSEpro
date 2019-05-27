import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {
    public LambdaTest() {

    }

    public static void main(String[] args) {
       // new Thread(()-> System.out.println("2324")).start();
        //List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
         //       "Date and Time API");
       // features.forEach(System.out::println);
        /*Computer c1=(a,b)->a+b;
        Computer c2=(a,b)->a*b;

        LambdaTest lambdaTest = new LambdaTest(c2);

        int result = lambdaTest.getResult(5, 2);
        System.out.println(result);*/


      /*  String[] strings={"1232","sdadas","sdsd"};
        List<String> list = Arrays.asList(strings);

        list.forEach(s -> System.out.println(s));*/



        List<Person> list = new ArrayList();
        list.add(new Person(1, "haha"));
        list.add(new Person(2, "rere"));
        list.add(new Person(3, "fefe"));

        System.out.println(list);

        Map<Integer, Person> mapp = list.stream().collect(Collectors.toMap(Person::getId, person ->person));

        System.out.println(mapp);

        System.out.println(mapp.get(1).getName());

        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));

        System.out.println(map);
    }

    Computer computer;

    public LambdaTest(Computer computer) {
        this.computer = computer;
    }

    public int  getResult(int a,int b){
       return computer.compute(a, b);
    }

    interface Computer{
        int compute(int a,int b);
    }
}


class Person {

    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



}

