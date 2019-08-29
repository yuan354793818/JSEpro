package noclassify;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.joda.time.DateTime;
import org.junit.Test;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.awt.print.PrinterJob;
import java.io.*;
import java.math.BigDecimal;
import java.net.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void test287() throws IOException {
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient client = builder.build();

        HttpPost post = new HttpPost("http://localhost:8085/print");

        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream content = response.getEntity().getContent();
        BufferedReader reader =new BufferedReader( new InputStreamReader(content));

        String buf;
        while ((buf = reader.readLine()) != null) {
            System.out.println(buf);
        }
    }

    @Test
    public void test313() {
        char[] chars = new char[2];
        System.out.println(chars[1]=='\0');
    }

    @Test
    public void test319() {
        String s = Integer.toBinaryString(213123);
        System.out.println(s);
    }

    @Test
    public void test325() {

    }
    public static int bitCount(int n) {
        // HD, Figure 5-2
        int count=0;
        for (int i = 0; i < 32; i++) {
            if ((n&1)==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }

    @Test
    public void test341() {
        System.out.println(~2+1);
    }

    @Test
    public void test346() {
        getSs("sd");
    }

    public void getSs(String s) {
        int i=9/0;
    }

    public void ggg(float s) {
        System.out.println(s);
    }

    public void ggg(Float s) {
        System.out.println(s);
    }
    @Test
    public void test366(){
        Float f = new Float(1);
        ggg(f);
    }

    
    @Test
    public void test365(){
        System.out.println((int)'Z');
    }


    @Test
    public void test375() {
        String[] strings = new String[2];
        System.out.println(strings[0]==null);
    }

    @Test
    public void test381() {
        System.out.println("CTGTTCGTTG".hashCode());
    }


    @Test
    public void test387() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\algorithm\\bb.txt");
        byte[] buf=new byte[5];
        StringBuffer sb=new StringBuffer();
        while (fis.read(buf)!=-1){
            sb.append(new String(buf));
            sb.append(System.lineSeparator());
            buf=new byte[5];
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test3872() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\algorithm\\bb.txt");
        byte[] buf=new byte[5];
        int len;
        StringBuffer sb=new StringBuffer();
        while ((len=fis.read(buf))!=-1){
            sb.append(new String(buf,0,len));
            sb.append(System.lineSeparator());
            buf=new byte[5];
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test414(){
        HashSet<String> set = new HashSet<>();
        String s = new String("11");
        String s1 = new String("11");
        set.add(s1);
        set.add(s);
        System.out.println(set);
    }

    @Test
    public void test424() {
        System.out.println(Integer.highestOneBit(2));
    }

    @Test
    public void test429() {
        System.out.println(Integer.highestOneBit(65));
    }

    @Test
    public void test434() {
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test439() {
        int[] ins={1,2,4};
        int[] ins1={1,2,4};
        System.out.println(Arrays.equals(ins,ins1));
    }

    @Test
    public void test446() {

    }


    public static void main(String[] args) {
       new JunitTest().fun();
    }
    @CallerSensitive
    public void fun() {
        System.out.println(Reflection.getCallerClass(1));
    }


    @Test
    public void test464() {
        System.out.println(ClassLoader.getSystemResource("").getFile());
    }

    @Test
    public void test468() {
        HashMap<String, String> map = new HashMap<>();
        map.put("ssss", null);
        System.out.println();
    }

    @Test
    public void test475() {
        File f=new File("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\blank");
        File[] files = f.listFiles();
        System.out.println(files.length);
    }

    @Test
    public void test462() {
        Pattern pattern=Pattern.compile("(?<!\\.)assets(\\.[a-zA-Z_]{2,30}){2,}");
        Matcher matcher = pattern.matcher("var action = \"assets.common.assets_SortGb\";");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void test493() {
        String s = "assets.cache.dep.detail";
        if (s.startsWith("assets.cache")){
            System.out.println("'"+s+"' : '"+s.replace("assets.cache","assets.common.cache")+"'");
        }
    }

    @Test
    public void test501() {

    }


    @Test
    public void test515() {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("assets.cache.getAssetsAdvanceScrapOpen");
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
    }


    public <T>  void getField(T t){
        System.out.println(t.getClass());
    }

    @Test
    public void test531() {
        getField(new Assets());
    }


    @Test
    public void test537() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://www.baidu.com");
        CloseableHttpResponse execute = httpclient.execute(httppost);
        System.out.println(EntityUtils.toString(execute.getEntity(),"UTF-8"));
    }
    
    @Test
    public void test547(){
        String[] tmpReportTypes =new String[]{};
        String reportTypes=null;
        for(String s:tmpReportTypes) {

        }
        System.out.println(tmpReportTypes.length);
    }


    @Test
    public void test556() {
        String s="sdsds";
        String[] ss= {"aaaa", "bbbb"};
        HashMap<String,Object> map=new HashMap<>();
        map.put("sd", s);
        map.put("aa",ss);
        map.put("null",null);
        System.out.println(map.get("ss"));
    }
    private Object getRealString(Object obj) {
        if (obj!=null) {
            if (obj instanceof String) {
                return ((String) obj).trim();
            }else if (obj instanceof String[]) {
                StringBuilder sb=new StringBuilder();
                for(String s:(String[])obj){
                    sb.append(s.trim()).append(",");
                }
                sb.deleteCharAt(sb.lastIndexOf(","));
                return sb.toString();
            }else {
                return obj;
            }
        }else {
            return null;
        }
    }

    @Test
    public void test585() {
        String s="sdsds";
        String[] ss= {"aaaa", "bbbb"};
        System.out.println(getRealString(s));
        System.out.println(getRealString(ss));
        Object realString = getRealString(null);
        System.out.println(realString);
    }


    @Test
    public void test597() {
        System.out.println(", ,".split(",").length);
    }

    @Test
    public void test602() {
        List<String> ll = new ArrayList<>();
        ll.add("sdsd");
        ll.add("111");
        ll.add("xxx");
        String string = ll.toString();
        System.out.println(string.replace('[','\0'));
    }

    @Test
    public void test612() {
        StringBuilder sb = new StringBuilder();
        sb.append("sdasdsad,");
        System.out.println(sb.deleteCharAt(sb.length()));
    }

    @Test
    public void test618() {
        List<String> ll = new ArrayList<>();
        ll.add("sdsd");
        ll.add("111");
        ll.add("xxx");
        String[] strings = ll.toArray(new String[]{});
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void test632() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        String format = nf.format(350158);
        System.out.println(format);
    }

    /**
     *  putAll 传引用
     */
    @Test
    public void test640() {
        Map<String,Object> map1=new HashMap<>();
        map1.put("oneman",new AA());
        Map<String,Object> map2=new HashMap<>();
        map2.putAll(map1);
        ((AA)map2.get("oneman")).name="sdsdsd";
        map2.put("oneman", new AA());
        System.out.println(((AA)map2.get("oneman")).name);
        System.out.println(((AA)map1.get("oneman")).name);
    }


    @Test
    public void test648() {
        List<String> rst=new ArrayList<>();
        String[] strings = rst.toArray(new String[]{});
        System.out.println(strings.length);
    }

    @Test
    public void test655() {
        Object a=null;
        String a1 = (String) a;
    }

    @Test
    public void test661() {
       // System.out.println(UUID.randomUUID().toString().replace('-','\0'));
        System.out.println( Md5Crypt.md5Crypt("yuanjiayu".getBytes()));
    }

    @Test
    public void test668() {
        DecimalFormat decimalFormat = new DecimalFormat();
        String format = decimalFormat.format(2 / 61);
        System.out.println(format);
    }


    @Test
    public void test677() {
        BigDecimal b=new BigDecimal(145435454);
        BigDecimal v=new BigDecimal(343.2343);
        System.out.println(new DecimalFormat("#0.00").format(b));
        System.out.println(b.add(v));
    }

    public  boolean isok;
    @Test
    public void test685() {
        System.out.println(isok);
    }


    @Test
    public void test692() {
        System.out.println(Arrays.toString(AA.class.getInterfaces()));
    }

    @Test
    public void test6927() {
        BigDecimal n= BigDecimal.valueOf(998);
        n=n.divide(BigDecimal.valueOf(2),1,BigDecimal.ROUND_HALF_EVEN);
        System.out.println(n);
        System.out.println(n.toString().substring(n.toString().indexOf(".")+1));
    }

    @Test
    public void test705() {
        BigDecimal n= BigDecimal.valueOf((double)998);
        System.out.println(n.toString());
    }

    @Test
    public void test711() {
        DecimalFormat decimalFormat=new DecimalFormat("#.0");
        BigDecimal d =BigDecimal.valueOf((double)2343434);
        System.out.println( d.toPlainString());
        System.out.println(decimalFormat.format(d));
        System.out.println((double)454543);
    }

    @Test
    public void test697() {
        System.out.println(Math.sqrt(10));
        System.out.println(Math.ceil(2.55));
        System.out.println(Math.pow(2,3));
    }

    @Test
    public void test704() throws IOException {
        File f = new File("E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\txt\\hh");
        f.mkdir();
        String s = f.getAbsolutePath() + "\\path.txt";
        File file = new File(s);
        file.createNewFile();
        String s1 = f.getAbsolutePath() + "\\files";
        File file1 = new File(s1);
        System.out.println( file1.mkdir());
    }

    @Test
    public void test716(){
        String s = "ass.jsp333.jsp";
        System.out.println(s.lastIndexOf(".jsp",55));
    }

    @Test
    public void test722() {
        Calendar calendar =Calendar.getInstance();
        System.out.println(calendar.toInstant().toString().substring(0,10));
    }

    @Test
    public void test728() {
        System.out.println("E:\\eclipse-workspace\\speedframework\\sfw.war\\WEB-INF\\source".replace("\\","/"));
    }

    @Test
    public void test733() {
        String zzzzx = "zzzzx";
        System.out.println(zzzzx.substring(0,zzzzx.length()-1));
    }
}


class AA implements  jjjj{
    public String name="yjy";
}

interface  jjjj{

}