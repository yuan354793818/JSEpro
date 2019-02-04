package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 多人聊天客户端
 */
public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12345);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());


        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String str = null;
                try {
                    while ((str = reader.readLine()) != null) {
                            System.out.println(str);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thr1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                String str = null;

                while ((str = scanner.nextLine())!=null) {
                    if (str.equals("quit")) {
                        try {
                            ps.println("quit");
                            socket.close();
                            return;
                        } catch ( IOException e) {
                            e.printStackTrace();
                        }
                    }
                    ps.println(str);
                }

            }
        }).start();
    }
}
