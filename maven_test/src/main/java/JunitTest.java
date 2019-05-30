import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.joda.time.DateTime;
import org.junit.Test;

import java.awt.print.PrinterJob;
import java.io.*;
import java.math.BigDecimal;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JunitTest {
    @Test
    public void test1() {
        System.out.println(new DateTime().toDate());
        System.out.println(new DateTime().plusMillis(4000).toDate());
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        String wktKWlo = URLDecoder.decode("WktKWlo", "utf-8");
        String encode = URLEncoder.encode("e?page=assets.terminal.printCode.print&printCode=WktKWlo", "utf-8");
        System.out.println(encode);

    }

    @Test
    public void test3() {
        System.out.println(new DateTime().dayOfYear().addToCopy(7).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(new DateTime().plusDays(7).toString("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(sdf.parse(sdf.format(new Date())));
        System.out.println(new DateTime());
    }

    @Test
    public void test5() {
        Map<String, Object> map = new HashMap<>();
        map.put("sdsd", "Sdsds");
        map.put("sd2sd", null);
        map.put("sd1sd", "Sdsds");
        map.put("sd5sd", "Sdsds");
    }

    @Test
    public void test6() {
        String ss = Integer.toOctalString(34), integer;
    }


    @Test
    public void test9() {

        boolean matches = "ds".matches("Windows(?=95|98|NT|2000)");

    }


    @Test
    public void test10() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\list.jsp"));
        String buf;
        while ((buf = reader.readLine()) != null) {
            boolean matches = buf.matches("assets(.[a-z]{2,15}){1,6}");
            if (matches) {
                System.out.println("true");
            }
        }
    }


    @Test
    public void test11() throws UnsupportedEncodingException, MalformedURLException {
        URL url = new URL("http://speedcn.vicp.cc:1380/sfw/e?page=base.index&entry=1");
        String query = url.getQuery();
        System.out.println(query);
    }

    @Test
    public void test12() throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("e?page=null", "UTF-8");
    }


    @Test
    public void test44() {
        String nima = String.format("HHH%sAAA", "nima");
        System.out.println(nima);
    }


    @Test
    public void test99() {
        Arrays.stream("yuan,jia,yu".split(",", 5)).forEach(System.out::println);
    }


    @Test
    public void test111() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " is " + (char) i);
        }
    }

    @Test
    public void test232() {
        Object o = null;
        System.out.println(String.valueOf(o));      //返回字符串 "null"
        System.out.println(String.valueOf(null));   // 直接报错
    }


    @Test
    public void test2321() {
        System.out.println("asdf".codePointAt(2));
    }

    @Test
    public void test130() {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextInt(10));
        }
    }

    @Test
    public void test134() {
        int[][] a = new int[][]{{1, 2, 3}};
        System.out.println(a.length);
    }

    @Test
    public void test140() {
        System.out.println(new BigDecimal(998).subtract(BigDecimal.valueOf(11)));
    }

    @Test
    public void test146() {
        List<String> list = new ArrayList<>();
        list.add("");
        System.out.println(list.size());
    }

    @Test
    public void test153() {
        for (int i = 42; i < 46; i++) {
            System.out.println((char) i);
        }
    }

    @Test
    public void test160() {
        Properties properties = new Properties();
        properties.setProperty("name", "true");
        System.setProperties(properties);
        System.out.println(Boolean.getBoolean("name"));
    }

    @Test
    public void test168() {
        System.out.println(Boolean.logicalXor(true, false));
    }

    @Test
    public void test173() {
        System.out.println(Byte.parseByte("-23", 2));
    }

    @Test
    public void test177() {
        System.out.println(0x80000000);
    }

    @Test
    public void test183() {
        Integer.toString(12345678);
    }

    @Test
    public void test188() {
        int q = 123;
        System.out.println((q << 6) + (q << 5) + (q << 2));
    }

    @Test
    public void test194() {
        String s="yuan jiaytu" +
                " asdfasdas ";
        Arrays.stream(s.split("\\s")).forEach(s1 -> System.out.println(s1));
    }

    @Test
    public void test201() {
        String s = "sdsd";
        String x = new String("sdsd");
        System.out.println(x==s);
    }


    @Test
    public void test209() {

        System.out.println(9>>> 31);
    }

    @Test
    public void test215() {
        System.out.println("As".compareTo("Aaa"));
    }


    @Test
    public void test221() {
       String s="http://zc.swust.edu.cn/sfw/e?page=assets.bills.changeBill.bill&type_=jxls&divisionPassed=&hasLowAssets=&belong=&code=request_jasper&businessId=409528&hasMaterial=N&source=normal&financeOutlaySubject=&businessCode=scrap&assetsTypes=&hasOther=false&backstockType=&materialMoney=&bpmNo=22011974&state=0&assetsType=furniture_low&hasHighAssets=&financeState=&isPrint=&sort=&hasSoft=N&node=division&businessRole=manager&money=600&mergeBpmNo=&isMerge=N&isCar=0&isdifferentcollege=&isProjectToAssets=false&isNeedSso=&payId=409528&maxPrice=100&hasNonFixBook=false&equipmentMaxMoney=100&advanceScrap=1&window_=pdf";
        int window_ = s.lastIndexOf("window_");
        System.out.println(window_);
        System.out.println(s.charAt(window_+7));
    }

    @Test
    public void test229() {
        System.out.println(BillPrinter.PrintType.PDF.getType());
    }

    @Test
    public void test234() {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        try {
            int i=9;
            int v=i/0;
        } catch (Exception e) {
            e.printStackTrace(ps);
        }
        System.out.println(baos.toString());
    }

    @Test
    public void test244() {
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet("http://localhost:8083/sfw/e?page=assets.bills.changeBill.bills&type_=jxls&belong=1&code=backstockBillVoucher&businessId=1912280155&hasMaterial=N&source=normal&businessCode=backstock&hasOther=false&backstockType=3&bpmNo=1808220014&state=1&assetsType=equipment&sort=&hasSoft=N&node=divisionhead&businessRole=division&money=5000&isMerge=N&isCar=0&isdifferentcollege=N&isProjectToAssets=false&isNeedSso=&payId=1912280155&maxPrice=5000&hasNonFixBook=false&equipmentMaxMoney=5000&advanceScrap=1&window_=pdf");
        get.addHeader("Cookie","JSESSIONID=FEBDD54B1A9D270BDD230761E79D7366");
        try {
            HttpResponse execute = client.execute(get);
            Header contentType = execute.getEntity().getContentType();
            HeaderElement[] elements = contentType.getElements();
            for (HeaderElement element : elements) {
                System.out.println(element.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test259() throws IOException {
        FileInputStream fis=new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\xx.txt");
        PDDocument load = PDDocument.load(fis);
    }

    @Test
    public void test274() {
        Arrays.stream(PrinterJob.lookupPrintServices()).forEach(printService -> {
            System.out.println(printService.getName());
        });
    }

    @Test
    public void test282() throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.toString());
    }
}

