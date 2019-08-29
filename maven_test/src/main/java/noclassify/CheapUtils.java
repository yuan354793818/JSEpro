package noclassify;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
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

    /**
     * 下划线转驼峰 sec_xxx --> secXxx
     *
     * @param s
     * @param titleCase 首字母是否大写
     * @return
     */
    public static String mapUnderscoreToCamelCase(String s, boolean titleCase) {
        s = s.toLowerCase();
        StringBuilder fieldStr = new StringBuilder();
        boolean upperCase = titleCase;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                upperCase = true;
            } else {
                if (upperCase) {
                    fieldStr.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    fieldStr.append(c);
                }
            }
        }
        return fieldStr.toString();
    }

    @Test
    public void test66() {
        System.out.println(mapUnderscoreToCamelCase("JHSBDS_SDSD_SDSDSD", true));
    }

    /**
     * 驼峰转下划线
     *
     * @param s
     * @return
     */
    public static String camelCaseToMapUnderscore(String s) {
        StringBuilder fieldStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c > 64 && c < 91) {
                fieldStr.append('_').append(Character.toLowerCase(c));
            } else {
                fieldStr.append(c);
            }
        }
        return fieldStr.toString();
    }

    @Test
    public void test85() {
        System.out.println(camelCaseToMapUnderscore("assetsTypeSort"));
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
            Pattern pattern = Pattern.compile("/w+");
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
        wordsAddQuotation("E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/collection sql.txt",
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
        System.out.println(getDiffString("E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/collection sql.txt",
                "E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/collection sql2.txt")
                .size());
    }

    static Pattern pattern = Pattern.compile("(?<!/.)assets(/.[a-zA-Z_]{2,30}){2,}");

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
        HashSet<String> s1 = getAllPageAndActionPath(new File("E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/source/assetsreport/view"));
        HashSet<String> s2 = getAllPageAndActionPath(new File("E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/source/assetsreport/resource"));
        HashSet<String> s3 = getAllPageAndActionPath(new File("E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/source/depreciation/view"));
        HashSet<String> s4 = getAllPageAndActionPath(new File("E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/source/depreciation/resource"));

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
        fileReplace(new File("E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/add_note.txt"));
    }

    /**
     * 两文件相同行合并
     *
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
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/txt/mergeLines.txt"));
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
        mergeLine(new File("E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/txt/fields.txt"),
                new File("E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/txt/values.txt"));
    }

    /**
     *
     * @param localHeadPath  5.3.5版本：本地头路径，到sfw.war下source为止，如
     *                       E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/source
     *                       6.0版本：depreciation和assetsreport除外模块
     *                       E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/product/material 定位到哪个模块
     * @param fileList  需要抽取的文件路径，从svn上copy即可，注意一个路径一行，没有分隔符，如
     *                   /assets5.0/branches/testing/assets-5.3.5-snapshot/src/cn/speedit/assets/action/MaterialChangeAction.java
     *                   /assets5.0/branches/testing/assets-5.3.5-snapshot/view/common/business/accept/materialFormRequest.jsp
     *                   /assets5.0/branches/testing/assets-5.3.5-snapshot/resource/js/material.js
     * @param outputPath  输出路径
     * @param is6_0  是否是6.0版本，depreciation和assetsreport包直接false，不用6.0的规则
     * @throws IOException
     *
     *
     * 输出文件夹下有个deploy.sh部署脚本，recover.sh恢复脚本，以及files文件夹下为需要升级的文件
     * 部署方法：
     *      将 outputPath输出路径 所定义的文件夹压缩，上传到linux服务器，解压到任意位置，进入解压后的文件夹
     *      ./deploy.sh 服务器下war包路径 服务器下tomcat路径，如：
     *      ./deploy.sh /speedec/webapps/sfw.war/...  /speedec/server/apache-tomcat-assets/... ; 即可替换和重启tomcat
     *      ./recover.sh /speedec/webapps/sfw.war/...  /speedec/server/apache-tomcat-assets/... ; 即可恢复和重启tomcat
     */
    public void packageKamiUtsuwa(String localHeadPath,String fileList, String outputPath,boolean is6_0) throws IOException {
        localHeadPath = localHeadPath.replace("\\", "/");
        if (localHeadPath.charAt(localHeadPath.length() - 1) == '/') {
            localHeadPath = localHeadPath.substring(0, localHeadPath.length() - 1);
        }
        fileList = fileList.replace("\\", "/");
        outputPath = outputPath.replace("\\", "/");
        File outputFolder = new File(outputPath);
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }
        File files = new File(outputFolder.getAbsolutePath() + "/files");
        files.mkdir();
        File deploySh = new File(outputFolder.getAbsolutePath() + "/deploy.sh");
        File recoverSh = new File(outputFolder.getAbsolutePath() + "/recover.sh");
        FileOutputStream deployShellWriter = new FileOutputStream(deploySh);
        FileOutputStream recoverShellWriter = new FileOutputStream(recoverSh);
        BufferedReader bd = new BufferedReader(new FileReader(fileList));
        String check = ("warPath=$1;tomcatPath=$2;" +
                "if test -d $warPath ; " +
                "then " +
                "   if [ $( echo $warPath | grep  '.war' | grep 'speedec/webapps/' -c  ) -eq 1 ];" +
                "       then warPath=${warPath%.war*}'.war';" +
                "   else echo '非法war包路径！';exit; " +
                "   fi; " +
                "else echo '非法war包路径';exit; " +
                "fi;" +
                "if test -d $tomcatPath ; " +
                "then " +
                "   if [ $( echo $tomcatPath | grep -c 'speedec/server/apache-tomcat-' ) -eq 1 ];" +
                "       then tomcatPath='speedec/server/apache-tomcat-'${tomcatPath#*speedec/server/apache-tomcat-};" +
                "       tomcatPath=${tomcatPath%/bin*};" +
                "   else echo '非法tomcat路径！';exit; " +
                "   fi; " +
                "else echo '非法tomcat包路径';exit; " +
                "fi;");
        deployShellWriter.write(check.getBytes());
        recoverShellWriter.write(check.getBytes());
        String buf;
        while ((buf = bd.readLine()) != null) {
            String trim = buf.trim();
            String product = null;
            int ed = -1;
            String localPath;
            String tail = null;
            int st;
            if (trim.lastIndexOf(".jsp") == trim.length() - 4) {
                ed = trim.indexOf("/view/");
                tail = trim.substring(ed);
            } else if (trim.lastIndexOf(".js") == trim.length() - 3) {
                ed = trim.indexOf("/resource/");
                tail = trim.substring(ed);
            } else if (trim.lastIndexOf(".java") == trim.length() - 5) {
                ed = trim.indexOf("/src/");
                tail = "/classes" + trim.substring(ed + 4, trim.length() - 4) + "class";
            } else {
                if (trim.contains("/bill/")) {
                    ed = trim.indexOf("/bill/");
                } else if (trim.contains("/custom/")) {
                    ed = trim.indexOf("/custom/");
                } else if (trim.contains("/process/")) {
                    ed = trim.indexOf("/process/");
                }
                tail = trim.substring(ed);
            }
            if (!is6_0) {
                st = trim.lastIndexOf("/", ed - 1);
                product = trim.substring(st + 1, ed);
                if (product.contains("assetsreport")) {
                    product = "assetsreport";
                } else if (product.contains("depreciation")) {
                    product = "depreciation";
                } else if (product.contains("assets")) {
                    product = "assets";
                }
                localPath = localHeadPath + "/" + product + tail;
            } else {
                localPath = localHeadPath + "/" + tail;
            }
            File file = new File(localPath);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(files.getAbsolutePath() + "/" + file.getName());
                byte[] fb = new byte[1024];
                int len = -1;
                while ((len = fis.read(fb)) != -1) {
                    fos.write(fb, 0, len);
                }
                fis.close();
                fos.close();
            }
            // 备份及移动脚本拼写
            String rPath = null;
            if (!is6_0) {
                rPath = "${warPath}/WEB-INF/source/" + product + tail;
            }else{
                rPath ="${warPath}/WEB-INF/product"+localHeadPath.substring(localHeadPath.indexOf("/assets/"))+tail;
            }
            Calendar calendar = Calendar.getInstance();
            String time = calendar.toInstant().toString().substring(0, 10);
            String bakSh = "mv " + rPath + " " + rPath + time + ";";
            deployShellWriter.write(bakSh.getBytes());
            String moveSh = "cp ./files/" + file.getName() + " " + rPath + ";";
            deployShellWriter.write(moveSh.getBytes());
            // 恢复备份脚本
            String recoverDelSh = " rm -f " + rPath + ";";
            String recoverMvSh = "mv " + rPath + time + " " + rPath + ";";
            recoverShellWriter.write(("if [ -f " + rPath + time + " ] ; then ").getBytes());
            recoverShellWriter.write(recoverDelSh.getBytes());
            recoverShellWriter.write(recoverMvSh.getBytes());
            recoverShellWriter.write(" echo '恢复成功！'; ".getBytes());
            recoverShellWriter.write(("else echo '未找到备份文件'" + rPath + time + "; fi;").getBytes());
        }
        //重启tomcat脚本
        deployShellWriter.write(("kill -9 $(ps -aef|grep -v grep| grep /${tomcatPath}/|awk '{print $2}');").getBytes());
        deployShellWriter.write(("${tomcatPath}/bin/startup.sh;").getBytes());

        recoverShellWriter.write(("kill -9 $(ps -aef|grep -v grep| grep /${tomcatPath}/|awk '{print $2}');").getBytes());
        recoverShellWriter.write(("${tomcatPath}/bin/startup.sh;").getBytes());
    }
    @Test
    public void test400() throws IOException {
        packageKamiUtsuwa("E:/eclipse-workspace/speedframework/sfw.war/WEB-INF/source",
                "E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/txt/filelist.txt",
                "E:/JavaEEworkspace/JavaEEworkspace/JSEpro/maven_test/src/main/java/noclassify/txt/ppc",false);
    }
}
