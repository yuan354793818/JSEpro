package noclassify;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Set;

public class ReflectionsTest {
    @Test
    public void test1() throws MalformedURLException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        Reflections reflections = new Reflections("JVM", new MethodParameterScanner());

        Set<Method> methods = reflections.getMethodsReturn(int.class);


        System.out.println(stopwatch);

        methods.forEach(method -> System.out.println(method.getName()));

    }

    @Test
    public void test2(){
        Reflections reflections=new Reflections("JVM",  new SubTypesScanner(false));
        reflections.getAllTypes().stream().filter(s -> {
            return s.matches("[\\u4e00-\\u9fa5]*");
        }).forEach(System.out::println);
    }

}
