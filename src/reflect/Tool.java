package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by YJY on 2018/9/23.
 */
public class Tool {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Book book=new Book();
        Tool.setProperty(1,book,"price",888);
        System.out.println(book.getPrice());
    }
    public static void setProperty(int model,Object object, String propertyName,Object value) throws NoSuchFieldException, IllegalAccessException {
        Class  clazz=object.getClass();

        switch (model){
            case 1:
                Field field=clazz.getDeclaredField(propertyName);

                field.setAccessible(true);
                field.set(object,value);
                break;
            case 2:
                Method[] list=clazz.getMethods();
                Class<?>[] parameterizedTypes=list[0].getParameterTypes();

                break;
        }
    }


}

class Book{
    private int price=100;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}