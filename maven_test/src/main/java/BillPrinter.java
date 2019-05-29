import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import java.awt.print.*;
import java.io.IOException;
import java.io.InputStream;

public class BillPrinter {
    public static void main(String[] args)  {
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet("http://zc.swust.edu.cn/sfw/e?page=assets.bills.changeBill.bill&type_=jxls&divisionPassed=&hasLowAssets=&belong=&code=request_jasper&businessId=409528&hasMaterial=N&source=normal&financeOutlaySubject=&businessCode=scrap&assetsTypes=&hasOther=false&backstockType=&materialMoney=&bpmNo=22011974&state=0&assetsType=furniture_low&hasHighAssets=&financeState=&isPrint=&sort=&hasSoft=N&node=division&businessRole=manager&money=600&mergeBpmNo=&isMerge=N&isCar=0&isdifferentcollege=&isProjectToAssets=false&isNeedSso=&payId=409528&maxPrice=100&hasNonFixBook=false&equipmentMaxMoney=100&advanceScrap=1&window_=pdf");        get.addHeader("Cookie","JSESSIONID=E271806213B531E638C76D06E6874248");
        HttpResponse response = null;
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        /*OutputStream os = new FileOutputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\resources/xx.pdf");
        entity.writeTo(os);*/
//        BufferedReader reader=new BufferedReader(new InputStreamReader(content));
//
//        String buf;
//        while ((buf = reader.readLine()) != null) {
//            System.out.println(buf);
//        }

        InputStream content = null;
        try {
            content = entity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrinterJob printerJob= PrinterJob.getPrinterJob();

        PDDocument document= null;
        try {
            document = PDDocument.load(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PDFPrintable pdf=new PDFPrintable(document, Scaling.SCALE_TO_FIT);

        Book book=new Book();
        PageFormat format=new PageFormat();
        format.setOrientation(PageFormat.PORTRAIT);
        format.setPaper(getPaper());

        book.append(pdf, format, document.getNumberOfPages());
        printerJob.setPageable(book);
        printerJob.setCopies(1);

        HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
        pars.add(Sides.DUPLEX); //设置单双页
        try {
            printerJob.print(pars);
        } catch (PrinterException e) {
            e.printStackTrace();
        }finally {
            get.releaseConnection();
        }
    }


    public static Paper getPaper() {
        Paper paper = new Paper();
        // 默认为A4纸张，对应像素宽和高分别为 595, 842
        int width = 595;
        int height = 842;
        // 设置边距，单位是像素，10mm边距，对应 28px
        int marginLeft = 10;
        int marginRight = 0;
        int marginTop = 10;
        int marginBottom = 0;
        paper.setSize(width, height);
        // 下面一行代码，解决了打印内容为空的问题
        paper.setImageableArea(marginLeft, marginRight, width - (marginLeft + marginRight), height - (marginTop + marginBottom));
        return paper;
    }
}
