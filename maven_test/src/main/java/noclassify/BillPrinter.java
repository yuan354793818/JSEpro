package noclassify;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import java.awt.print.*;
import java.io.*;

public class BillPrinter {

    private String url;
    private String cookie;

    public BillPrinter(String url, String cookie) {
        this.url = url;
        this.cookie = cookie;
    }

    public enum PrintType {
        PDF("pdf"),
        EXCEL("excel");
        private String type;

        PrintType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private boolean checkType(PrintType printType) {
        int windowIndex = 0;
        if ((windowIndex = url.lastIndexOf("window_")) != -1) {
            windowIndex += 6;
            String equalType = url.substring(windowIndex);
            if (equalType.startsWith("=" + printType.getType())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PrintResult result = new BillPrinter("http://sbc.scu.edu.cn/sfw_u/e?page=assets.change.bills.changeBill.bill&type_=jxls&divisionPassed=&hasLowAssets=&belong=1&code=request_jasper&businessId=912371890&hasMaterial=N&source=normal&financeOutlaySubject=&businessCode=scrap&assetsTypes=&hasOther=false&backstockType=&materialMoney=&bpmNo=1905300191&state=0&acceptanceForm=&assetsType=equipment&hasHighAssets=&flittingoutType=&financeState=&isPrint=&sort=&hasSoft=N&node=manager&businessRole=manager&money=9950&mergeBpmNo=&isMerge=N&isCar=0&isdifferentcollege=N&isProjectToAssets=false&isNeedSso=&payId=912371890&maxPrice=9950&hasNonFixBook=false&equipmentMaxMoney=9950&advanceScrap=1&window_=pdf",
                "JSESSIONID=A102EB80B1893433BCC751585FAD4201")
                .print();
        System.out.println(result);
    }

    public PrintResult print() {
        if (url == null || url.trim().equals("")) {
            return new PrintResult(PrintResultState.PRINT_FAIL,"url不能为空");
        }
        if (cookie == null || cookie.trim().equals("")) {
            return new PrintResult(PrintResultState.PRINT_FAIL,"cookie不能为空");
        }
        int windowIndex = 0;
        PrintType printType = null;
        if ((windowIndex = url.lastIndexOf("window_")) != -1) {
            windowIndex += 7;
            String equalType = url.substring(windowIndex);
            if (equalType.startsWith("=")) {
                for (PrintType type : PrintType.values()) {
                    if (equalType.startsWith(type.getType(), 1)) {
                        printType = type;
                    }
                }
            } else {
                return new PrintResult(PrintResultState.URL_PRINT_TYPE_INCORRECT, "链接window_后没=");
            }
        } else {
            return new PrintResult(PrintResultState.URL_PRINT_TYPE_INCORRECT, "链接没有window_");
        }
        if (printType == null) {
            return new PrintResult(PrintResultState.URL_PRINT_TYPE_INCORRECT, "无此打印类型");
        }

        ByteArrayOutputStream errorStackMsg = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(errorStackMsg);
        PrintResult result=null;

        try {
            switch (printType) {
                case PDF:
                    result= printPdf();
                    break;
                case EXCEL:
                    result= printExcel();
                    break;
                default:
                    result = new PrintResult(PrintResultState.URL_PRINT_TYPE_INCORRECT, "无此打印类型");
            }
        } catch (Exception e) {
            e.printStackTrace(ps);
            result=new PrintResult(PrintResultState.PRINT_FAIL,e.getMessage(),errorStackMsg.toString());
        }
        return result;
    }

    private PrintResult printExcel() {
        return new PrintResult(PrintResultState.NO_STATE, "未实现");
    }

    /**
     * @return
     */
    private PrintResult printPdf() {
        ByteArrayOutputStream errorStackMsg = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(errorStackMsg);

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        get.addHeader("Cookie", cookie);
        HttpResponse response = null;
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace(ps);
            return new PrintResult(PrintResultState.URL_EXCUTE_ERROR, e.getMessage(),errorStackMsg.toString());
        }
        HttpEntity entity = null;
        if (response != null) {
            entity = response.getEntity();
        }else {
            return new PrintResult(PrintResultState.NO_RESPONSE,"无响应");
        }
        boolean isPdf=false;
        if (entity != null) {
            HeaderElement[] elements = entity.getContentType().getElements();
            for (HeaderElement element : elements) {
                if (element.getName().contains("pdf")) {
                    isPdf = true;
                }
            }
        }
        if (!isPdf) {
            return new PrintResult(PrintResultState.NOT_PDF_PROBABLY,"不是pdf格式");
        }
        InputStream content = null;
        try {
            content = entity.getContent();
        } catch (IOException e) {
            e.printStackTrace(ps);
            return new PrintResult(PrintResultState.PRINT_FAIL,e.getMessage(),errorStackMsg.toString());
        }
        //获取打印机名字
        int pIndex = url.indexOf("printer");
        String printerName=null;
        if (pIndex != -1) {
            pIndex+=7;
            String printerStr = url.substring(pIndex);
            if (printerStr.startsWith("=")) {
                int i=1;
                while (i < printerStr.length()) {
                    if (url.charAt(i) =='&') {
                        break;
                    }
                    i++;
                    if (i > 50) {
                        return new PrintResult(PrintResultState.PRINT_FAIL,"url可能有问题");
                    }
                }
                printerName=printerStr.substring(1,i);
            }
        }
        //找不到对应的就调默认打印机
        PrinterJob printerJob=PrinterJob.getPrinterJob();
        if (printerName != null) {
            PrintService[] printServices = PrinterJob.lookupPrintServices();
            for (PrintService service : printServices) {
                if (service.getName().contains(printerName)) {
                    try {
                        printerJob.setPrintService(service);
                    } catch (PrinterException e) {
                        e.printStackTrace(ps);
                        return new PrintResult(PrintResultState.PRINT_FAIL,e.getMessage(),errorStackMsg.toString());
                    }
                }
            }
        }
        PDDocument document = null;
        try {
            document = PDDocument.load(content);
        } catch (IOException e) {
            e.printStackTrace(ps);
            return new PrintResult(PrintResultState.NOT_PDF_PROBABLY,e.getMessage(),errorStackMsg.toString());
        }
        PDFPrintable pdf = new PDFPrintable(document, Scaling.SCALE_TO_FIT);//打印规则
        Book book = new Book(); //多页
        PageFormat format = new PageFormat();
        format.setOrientation(PageFormat.PORTRAIT);//纵向
        format.setPaper(getPaper());
        int pageNum=0;
        if (document != null) {
            pageNum=document.getNumberOfPages();
            book.append(pdf, format, pageNum);
        }else {
            return new PrintResult(PrintResultState.NOT_PDF_PROBABLY,"PDF文件为空");
        }
        printerJob.setPageable(book);
        printerJob.setCopies(1);//打印份数
        HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
        pars.add(Sides.ONE_SIDED); //设置单双页
        try {
            printerJob.print(pars);
        } catch (PrinterException e) {
            e.printStackTrace(ps);
            return new PrintResult(PrintResultState.PRINT_FAIL,e.getMessage(),errorStackMsg.toString());
        } finally {
            get.releaseConnection();
        }
        PrintResult printResult = new PrintResult(PrintResultState.PRINT_SUCCESS, "打印成功");
        printResult.setCostPageNum(pageNum);
        return printResult;
    }


    public static PrintResult print(InputStream inputStream) {
        ByteArrayOutputStream errorStackMsg = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(errorStackMsg);

        PrinterJob printerJob=PrinterJob.getPrinterJob();
        PDDocument document = null;
        try {
            document = PDDocument.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace(ps);
            return new PrintResult(PrintResultState.NOT_PDF_PROBABLY,e.getMessage(),errorStackMsg.toString());
        }
        PDFPrintable pdf = new PDFPrintable(document, Scaling.SCALE_TO_FIT);//打印规则
        Book book = new Book(); //多页
        PageFormat format = new PageFormat();
        format.setOrientation(PageFormat.PORTRAIT);//纵向
        format.setPaper(getPaper());
        int pageNum=0;
        if (document != null) {
            pageNum=document.getNumberOfPages();
            book.append(pdf, format, pageNum);
        }else {
            return new PrintResult(PrintResultState.NOT_PDF_PROBABLY,"PDF文件为空");
        }
        printerJob.setPageable(book);
        printerJob.setCopies(1);//打印份数
        HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
        pars.add(Sides.ONE_SIDED); //设置单双页
        try {
            printerJob.print(pars);
        } catch (PrinterException e) {
            e.printStackTrace(ps);
            return new PrintResult(PrintResultState.PRINT_FAIL,e.getMessage(),errorStackMsg.toString());
        }
        PrintResult printResult = new PrintResult(PrintResultState.PRINT_SUCCESS, "打印成功");
        printResult.setCostPageNum(pageNum);
        return printResult;
    }

    /**
     * 纸张大小设置
     *
     * @return
     */
    private static Paper getPaper() {
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
