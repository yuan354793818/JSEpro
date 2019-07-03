package noclassify;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
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
     * @param
     * @return
     */
    public static boolean wordsAddQuotation(String path,String preAndPost,boolean hasSpliter) throws IOException {
        BufferedReader brd = null;
        brd = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String buf;
        if (hasSpliter) {
            while ((buf = brd.readLine()) != null) {
                sb.append(buf);
            }
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(sb.toString());
            StringBuilder rsb = new StringBuilder();
            while (matcher.find()) {
                rsb.append(preAndPost).append(matcher.group(0)).append(preAndPost).append(",");
                rsb.append(System.lineSeparator());
            }
            sb.delete(0, sb.length());
            sb.append(rsb);
        }else {
            while ((buf = brd.readLine()) != null) {
                sb.append(preAndPost).append(buf).append(preAndPost);
                sb.append(",");
                sb.append(System.lineSeparator());
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        FileOutputStream fw = new FileOutputStream(path);
        fw.write(sb.toString().getBytes());
    //        用Writer会被截断，原因不明
    //        int i=0;
    //        for ( ; i < sb.length()-100; i+=100) {
    //            fw.write(rStr,i,100);
    //        }
    //        if (i > sb.length()) {
    //            fw.write(rStr,i,sb.length());
    //        }
        return true;
    }

    @Test
    public void test49() throws IOException {
        wordsAddQuotation("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\collection sql.txt",
                "'",false);
    }


    public static HashSet getDiffString(String p1, String p2) throws IOException {
        BufferedReader br1=new BufferedReader(new FileReader(p1));
        BufferedReader br2=new BufferedReader(new FileReader(p2));
        HashSet<String> rst = new HashSet<>();
        String buf;
        while ((buf=br1.readLine())!=null){
            rst.add(buf.trim());
        }
        while ((buf=br2.readLine())!=null){
            if (rst.contains(buf.trim())) {
                rst.remove(buf.trim());
            }
        }
        return rst;
    }


    @Test
    public void test80() throws IOException {
        System.out.println(getDiffString("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\collection sql.txt",
                "E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\collection sql2.txt")
                .size());
    }
}
