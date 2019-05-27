package gc;

import org.junit.Test;

import java.io.File;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class test1 {

    @Test
    public void test2() {
        System.out.println(String.format("111%s111","yjy"));
    }

    @Test
    public void test4() {
         System.getProperties().entrySet().stream().forEach(entry-> System.out.println(entry.getKey()+"  "+
                 entry.getValue()));
    }

    @Test
    public void test7() throws UnknownHostException {

        java.lang.String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println(hostAddress);
    }

    @Test
    public void test0(){
        System.out.println(ClassLoader.getSystemResource(""));
    }

    @Test
    public void test00(){
        File file = new File("d:/", "QQ_file");

        File[] files = file.listFiles(File::isDirectory);
        assert files != null;

        for (File f : files) {
            System.out.println(f.getName());
        }
    }

    @Test
    public void test55() throws MalformedURLException {
        File file = new File("d:/", "QQ_file");
        System.out.println(file.toURI().toURL());

    }


    @Test
    public void test99(){

        System.out.println(String.class.isInstance(new String()));


    }

    @Test
    public void test01(){
        String v = new rtyui().getV();
        System.out.println(v);
    }

    @Test
    public void test789(){
        Class<String[]> aClass = String[].class;
        System.out.println(aClass.getComponentType());
    }

    @Test
    public void testx() throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<?> nihao = executorService.submit(() -> System.out.println("nihao"));
        System.out.println(nihao.get()!=null);
    }
}


interface blockMe {
    default  String getV(){
        return "yuanjiayu";
    }
}


class rtyui implements blockMe{
    @Override
    public String getV() {
        return "a";
    }
}