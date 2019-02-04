package gc;


import java.io.*;

public class IOdemo {
    public static void main(String[] args) throws IOException {
       IOdemo iOdemo=new IOdemo();
       iOdemo.BufferWriterTest();


    }

    public void FileInputStreamTest() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\items.txt");
        byte[] buf=new byte[1024];
        StringBuffer buffer = new StringBuffer();
        while (fis.read(buf) != -1) {
            buffer.append(new String(buf));
        }
        System.out.println(buffer.toString());
    }
    public void BufferReaderTest() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\items.txt"));
        String buf;
        StringBuffer buffer = new StringBuffer();
        while ((buf = br.readLine()) != null) {
            buffer.append(buf);
        }
        System.out.println(buffer.toString());
    }

    public void StringWriterTest() throws FileNotFoundException {
        StringWriter br = new StringWriter(111);
        br.write("232");
        StringBuffer buffer = br.getBuffer();
        System.out.println(buffer.toString());
    }

    public void InputStreamReadTest() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\items.txt"));
        char[] chars = new char[32];
        StringBuffer buffer = new StringBuffer();

        while (isr.read(chars) != -1) {
            buffer.append(chars);
        }


        System.out.println(buffer.toString());
    }

    public void BufferWriterTest() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\bb.txt"));
        writer.write("ccccccccc");
        writer.close();

    }

    public void printStreamTest() throws FileNotFoundException {
        PrintStream ps = new PrintStream("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\bb.txt");
    }
}
