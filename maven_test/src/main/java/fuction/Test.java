package fuction;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "yjy");
        map.put(2, "llh");
        map.put(3, "yh");
        map.put(4, "zhangsan");
        map.put(5, "wangwu");


        Set<Map.Entry<Integer, String>> entries = map.entrySet();


        List<List<String>> listList = new ArrayList<>();

        listList.add(new ArrayList<String>(Arrays.asList("qwer", "rty", "tytt")));
        listList.add(new ArrayList<String>(Arrays.asList("aaaaa", "bbbb", "cccc")));
        listList.add(new ArrayList<String>(Arrays.asList("997867", "2323", "22222")));

      /*  Stream<List<String>> stream = listList.stream();

        Stream<String> stringStream = stream.flatMap(child -> child.stream());*/

        //stringStream.peek(System.out::println).collect(Collectors.toList());

        //String reduce = stringStream.filter(s->s.compareTo("aaaa")>0).reduce( String::concat).get();

        //stringStream.sorted().limit(4).forEach(System.out::println);

        //BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\近期解决.txt"));
        //Stream<String> lines = reader.lines();

        /*boolean b = stringStream.noneMatch(s -> s.length() > 8);
        System.out.println(b);*/

        //List<String> collect = stringStream.collect(Collectors.toList());

       /* Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(()->Math.random()).limit(10).forEach(System.out::println);*/

        //Stream.iterate(0, n -> n+3).limit(10).forEach(System.out::println);


       /* IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);*/

    /*    Stream.generate(() -> Math.random() * 1000).limit(100).collect(Collectors.partitioningBy(s->{
            if ((double)s>100){
                return true;
            }else {
                return false;
            }
        })).forEach((a, b)-> {
            if (a){
                System.out.println("group1 size:"+b.size());
            }else {
                System.out.println("group2 size:"+b.size());
            }
        });*/
/*

        Stream.generate(() -> Math.random() * 1000).limit(100).collect(Collectors.groupingBy(s -> {
            if ((double)s < 100d && (double)s > 0) {
                return "0到100的数";
            }else if ((double)s >100 && (double)s<200){
                return "100到200的数";
            }else {
                return "200以上的数";
            }
        })).forEach((a,b)->{
            System.out.println(a+" size:"+b.size());
        });
*/

    }


    @org.junit.Test
    public void test1() {
        Optional<Double> minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double::min);
        System.out.println(minValue.get());
    }
}
