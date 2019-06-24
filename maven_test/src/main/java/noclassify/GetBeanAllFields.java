package noclassify;

import java.lang.reflect.Field;

public class GetBeanAllFields {
    public static void main(String[] args) {
        System.out.println(getFieldString(Assets.class,"a."));
    }

    /**
     * 将所有bean private字段驼峰转换输出sql
     * @param clazz
     * @param prefix
     * @return
     */
    public static String getFieldString(Class clazz,String prefix) {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field f : fields) {
            if (f.getModifiers() == 2) {  // 单独 private 修饰
                StringBuilder fieldStr=new StringBuilder();
                for (char c:f.getName().toCharArray()){
                    if (c>64&&c<91){
                        fieldStr.append('_').append(Character.toLowerCase(c));
                    }else {
                        fieldStr.append(c);
                    }
                }
                sb.append(prefix).append(fieldStr).append(",");
            }
        }
        return sb.toString();
    }

}
