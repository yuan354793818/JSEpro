package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 模拟聊天室 多人聊天服务器
 */
public class NioChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            ConcurrentHashMap<Integer, BufferedReader> readServer = new ConcurrentHashMap<>();
            ConcurrentHashMap<Integer, PrintStream> writeServer = new ConcurrentHashMap<>();

            // 建立连接线程
            new Thread(() -> {
                while (true) {
                    Socket socket = null; //等待连接
                    try {
                        socket = server.accept();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    BufferedReader reader = null;
                    PrintStream ps = null;
                    try {
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        ps = new PrintStream(socket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    readServer.put(socket.getPort(), reader);
                    writeServer.put(socket.getPort(), ps);
                }

            }).start();
            //输出消息线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        List<String> msgs = new ArrayList<>();
                        for (Map.Entry<Integer, BufferedReader> entry : readServer.entrySet()) {
                            try {
                                BufferedReader reader = entry.getValue();
                                StringBuilder builder = new StringBuilder();
                                String buf=reader.readLine();
                                msgs.add(builder.toString());
                                System.out.println("msgs:\n " + msgs);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        for (Map.Entry<Integer, PrintStream> entry : writeServer.entrySet()) {
                            PrintStream ps = entry.getValue();
                            msgs.forEach(s -> {
                                ps.print(s);
                            });
                        }


                        try {
                            Thread.sleep(2000);
                            System.out.println("服务器扫描完毕");
                            System.out.println(readServer.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            ).start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
