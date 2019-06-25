package noclassify;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheapUtils {
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


    /** 给一组单词添加引号或者括号
     * @param str
     * @return
     */
    public static  String wordsAddQuotation(String str,String preAndPost){
        Pattern pattern=Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb=new StringBuilder();
        while (matcher.find()){
          sb.append(preAndPost+matcher.group(0)+preAndPost+",");
        }
        return sb.toString().substring(0,sb.lastIndexOf(","));
    }

    @Test
    public void test49() {
        System.out.println(wordsAddQuotation("software,invisible_assets,non_patents,copyright,chartered_right,patent,trademark","\'"));
    }

}
