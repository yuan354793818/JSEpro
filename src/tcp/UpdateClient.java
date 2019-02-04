package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by YJY on 2018/9/22.
 */
public class UpdateClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 12345);
        File file = getFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        //传输文件名看server是否已有，有则不上传
        ps.println(file.getName());

        String s=br.readLine();

        if (s.equals("exist")) {
            System.out.println("has been uploaded!");
            socket.close();
        } else if (s.equals("ok")) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buf = new byte[8196];
            int len;
            while ((len = fileInputStream.read(buf)) != -1) {
                ps.write(buf, 0, len);
            }
            fileInputStream.close();
            socket.close();
        }
    }



    public static File getFile(){
        Scanner scanner=new Scanner(System.in);
        while(true) {
            File file = new File(scanner.nextLine());
            if (!file.exists()) {
                System.out.println("file is not exist");
            } else if (file.isDirectory()) {
                System.out.println("your input is directory,please input again!");
            } else {
                return file;
            }
        }
    }
}
