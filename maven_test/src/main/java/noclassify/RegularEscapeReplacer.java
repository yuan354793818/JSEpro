package noclassify;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * oracle sql 中 regexp_replace(p1,p2,p3) 方法中第二个参数转义
 * 例：
 * update business_bill_template set action = regexp_replace(action, '^assets.', 'assets.material.') where action like 'assets.%material%';
 * 替换为
 * update business_bill_template set action = regexp_replace(action, '^assets\.', 'assets.material.') where action like 'assets.%material%';
 */
public class RegularEscapeReplacer {

    private static String inputFilep;
    private static String outFilep;

    /**
     * 设置输入文件和输出文件路径
     *
     * @param inputFile
     * @param outFile
     */
    public static void setPath(String inputFile, String outFile) {
        inputFilep = inputFile;
        outFilep = outFile;
    }

    public static void main(String[] args) throws IOException {
        RegularEscapeReplacer.setPath("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\6.0拆分.sql",
                "D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\xx.sql");
        RegularEscapeReplacer.doTransfer('?', '.');
    }

    /**
     * 执行转换并输出
     *
     * @param chars 要转义的字符集 如 '?','.','('
     * @throws IOException
     */
    public static void doTransfer(char... chars) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFilep));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFilep));
        String buf;
        StringBuilder bd = new StringBuilder();
        StringBuilder result = new StringBuilder();
        while ((buf = reader.readLine()) != null) {
            bd.append(buf);
            bd.append(System.lineSeparator());
        }

        int head = 0;
        int tail = 0;

        Pattern compile = Pattern.compile("regexp_replace");
        Matcher matcher = compile.matcher(bd.toString());
        while (matcher.find()) {
            tail = matcher.end();
            result.append(bd.substring(head, tail + 1));
            int start = matcher.end();
            int end = start;
            int charCount = 1;
            while (charCount > 0) {
                char c = bd.charAt(++end);
                if (c == ')') {
                    charCount--;
                } else if (c == '(') {
                    charCount++;
                }
                if (end > Integer.MAX_VALUE / 3) {
                    throw new RuntimeException("可能死循环了");
                }
            }
            String subRst = transfer(bd, start, end, chars);
            result.append(subRst);
            head = end;
        }
        result.append(bd.substring(head));
        writer.write(result.toString());
        reader.close();
        writer.close();
    }

    private static String transfer(StringBuilder bd, int start, int end, char... chars) {
        String result = bd.substring(start + 1, end);
        for (char a : chars) {
            String[] split = result.split(",");
            String replace;
            Pattern compile = Pattern.compile("(?<!\\\\)\\" + a);
            Matcher matcher = compile.matcher(split[1]);
            if (matcher.find()) {
                replace = split[1].replace(a + "", "\\" + a);
            } else {
                replace = split[1];
            }
            result = split[0] + "," + replace + "," + split[2];
        }
        return result;
    }
}
