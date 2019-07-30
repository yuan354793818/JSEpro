package noclassify;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheapUtils {


    /**
     * 将所有bean private字段驼峰转换输出sql
     *
     * @param clazz
     * @param prefix
     * @param tuofen 是否驼峰转换
     * @return
     */
    public static String getFieldString(Class clazz, String prefix, boolean tuofen) {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field f : fields) {
            if (f.getModifiers() == 2) {  // 单独 private 修饰
                StringBuilder fieldStr = new StringBuilder();
                for (char c : f.getName().toCharArray()) {
                    if (c > 64 && c < 91 && tuofen) {
                        fieldStr.append('_').append(Character.toLowerCase(c));
                    } else {
                        fieldStr.append(c);
                    }
                }
                sb.append(prefix).append(fieldStr).append(",");
            }
        }
        return sb.toString();
    }

    @Test
    public void test43() {
        System.out.println(getFieldString(Assets.class, ":", false));
    }


    /**
     * 给一组单词添加引号或者括号
     *
     * @param path
     * @param preAndPost
     * @param hasSpliter 是否有分隔符，没有则认定为一排一个单词，有则只提取字母
     * @return
     * @throws IOException
     */
    public static boolean wordsAddQuotation(String path, String preAndPost, boolean hasSpliter) throws IOException {
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
        } else {
            while ((buf = brd.readLine()) != null) {
                sb.append(preAndPost).append(buf).append(preAndPost);
                sb.append(",");
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
                "'", false);
    }


    public static HashSet getDiffString(String p1, String p2) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader(p1));
        BufferedReader br2 = new BufferedReader(new FileReader(p2));
        HashSet<String> rst = new HashSet<>();
        String buf;
        while ((buf = br1.readLine()) != null) {
            rst.add(buf.trim());
        }
        while ((buf = br2.readLine()) != null) {
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

    static Pattern pattern = Pattern.compile("(?<!\\.)assets(\\.[a-zA-Z_]{2,30}){2,}");

    /**
     * 根据正则找到对应string放入hashset
     *
     * @param dirOrfile
     * @return
     */
    public static HashSet<String> getAllPageAndActionPath(File dirOrfile) {
        HashSet<String> rst = new HashSet<>();
        if (dirOrfile.exists()) {
            if (dirOrfile.isFile()) {
                BufferedReader brd = null;

                try {
                    brd = new BufferedReader(new FileReader(dirOrfile));
                    String buf;
                    while ((buf = brd.readLine()) != null) {
                        Matcher matcher = pattern.matcher(buf);
                        while (matcher.find()) {
                            String group = matcher.group();
                            int i = buf.indexOf(group);
                            if (buf.substring(7, i).contains("e?page=")) {
                                rst.remove(group);
                                rst.add(group + ".jsp");
                            } else {
                                rst.add(group);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (dirOrfile.isDirectory()) {
                for (File f : dirOrfile.listFiles()) {
                    rst.addAll(getAllPageAndActionPath(f));
                }
            }
        }
        return rst;
    }

    @Test
    public void test145() {
        HashSet<String> s1 = getAllPageAndActionPath(new File("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source\\assetsreport\\view"));
        HashSet<String> s2 = getAllPageAndActionPath(new File("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source\\assetsreport\\resource"));
        HashSet<String> s3 = getAllPageAndActionPath(new File("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source\\depreciation\\view"));
        HashSet<String> s4 = getAllPageAndActionPath(new File("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source\\depreciation\\resource"));

        s1.addAll(s2);
        s1.addAll(s3);
        s1.addAll(s4);

        HashSet<String> rst = new HashSet<>();
        for (String s : s1) {
            if (s.startsWith("assets.cache")) {
                rst.add("'" + s + "' : '" + s.replace("assets.cache", "assets.common.cache") + "',");
            } else {
                rst.add("'" + s + "' : '" + s + "',");
            }
        }
        rst.stream().sorted().forEach(System.out::println);
    }


    public static void fileReplace(File dirOrfile) {
        if (dirOrfile.exists()) {
            if (dirOrfile.isFile()) {
                BufferedReader brd = null;
                FileOutputStream fos = null;
                StringBuilder rst = new StringBuilder();
                try {
                    brd = new BufferedReader(new FileReader(dirOrfile));
                    String buf;
                    while ((buf = brd.readLine()) != null) {
                        Matcher matcher = pattern.matcher(buf);
                        if (matcher.find()) {
                            int start = matcher.start();
                            int end = matcher.end();
                            if (buf.charAt(start - 1) == '=') {
                                rst.append(buf.substring(0, start))
                                        .append("\"+getRealPath(\"")
                                        .append(matcher.group())
                                        .append("\")");

                                if (buf.charAt(end) == '"' || buf.charAt(end) == '\'') {
                                    rst.append(buf.substring(end));
                                } else {
                                    rst.append("+\"" + buf.substring(end));
                                }
                            } else if (buf.charAt(start - 1) == '"') {
                                rst.append(buf.substring(0, start))
                                        .append("getRealPath(\"")
                                        .append(matcher.group())
                                        .append("\")");
                                if (buf.charAt(end) == '"' || buf.charAt(end) == '\'') {
                                    rst.append(buf.substring(end));
                                } else {
                                    rst.append("+\"" + buf.substring(end));
                                }
                            }
                            rst.append(System.lineSeparator());
                        } else {
                            rst.append(buf).append(System.lineSeparator());
                        }
                    }
                    fos = new FileOutputStream(dirOrfile);
                    fos.write(rst.toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (dirOrfile.isDirectory()) {
                for (File f : dirOrfile.listFiles()) {
                    fileReplace(f);
                }
            }
        }
    }

    @Test
    public void test212() {
        fileReplace(new File("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\add_note.txt"));
    }

    /**
     * 两文件相同行合并
     * @param f1
     * @param f2
     * @throws IOException
     */
    public void mergeLine(File f1, File f2) throws IOException {
        BufferedReader bd1 = new BufferedReader(new FileReader(f1));
        BufferedReader bd2 = new BufferedReader(new FileReader(f2));
        String buf1, buf2 = null;
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> rst = new ArrayList<>();
        while ((buf1 = bd1.readLine()) != null) {
            l1.add(buf1.trim());
        }
        while ((buf2 = bd2.readLine()) != null) {
            l2.add(buf2.trim());
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\txt\\mergeLines.txt"));
        for (int i = 0; i < l1.size(); i++) {
            if (i >= l2.size()) {
                bw.write(l1.get(i));
                bw.newLine();
            } else {
                bw.write(l1.get(i) + "     " + l2.get(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    @Test
    public void test265() throws IOException {
        mergeLine(new File("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\txt\\fields.txt"),
                new File("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\txt\\values.txt"));
    }
}
