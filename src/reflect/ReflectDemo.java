package reflect;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by YJY on 2018/9/23.
 */
public class ReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("src/com/yjy/reflect/animal.property"));
        String string=bufferedReader.readLine();
        Class clazz=Class.forName(string);
        //Animal animal= (Animal) clazz.newInstance();
        //animal.showFeature();
        Constructor constructor=clazz.getConstructor(String.class);
        Animal pig= (Animal) constructor.newInstance("peiqi");
        Method showFeature= (Method) clazz.getMethod("showFeature",String.class).invoke(pig,"1234");
        //pig.showFeature();

        //Field name=clazz.getField("name");
        Field name=clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(pig,"bajie");
        Method showFeature2= (Method) clazz.getMethod("showFeature",String.class).invoke(pig,"7890");
    }
}



interface Animal{
    public void  showFeature();
}

class Pig implements Animal{
    private String name;
    public Pig(String name){
        this.name=name;
    }

    @Override
    public void showFeature() {
        System.out.println(name+"  henhenhen");
    }
    public void showFeature(String num) {
        System.out.println(name+"  henhenhen  "+num);
    }
}


class Cat implements Animal{

    @Override
    public void showFeature() {
        System.out.println("miaomiaomiao");
    }
}

class Dog implements Animal{

    @Override
    public void showFeature() {
        System.out.println("wangwangwang");
    }
}
