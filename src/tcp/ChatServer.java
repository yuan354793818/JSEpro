package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 模拟聊天室 多人聊天服务器
 */
public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            ConcurrentHashMap<Integer, Socket> map = new ConcurrentHashMap<>();

            //服务器端输入线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner scanner = new Scanner(System.in);
                    String str = null;

                    try {
                        while ((str = scanner.nextLine()) != null) {
                            if (str.equals("get")) {
                                for (Map.Entry<Integer, Socket> entry : map.entrySet()) {
                                    System.out.println(" 客户端  ： " + entry.getKey());
                                }
                            } else {
                                String[] split = str.split(":");
                                int key = 0;
                                try {
                                    key = Integer.valueOf(split[0].trim());
                                    synchronized (this.getClass()) {//检测含有，但获取时已经被删除
                                        if (map.containsKey(key)) {
                                            PrintStream ps = new PrintStream(map.get(key).getOutputStream());
                                            ps.println("服务器 ：" + split[1]);
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("无效输入");
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

            //周期检测存活socket，删除死亡socket
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        int delKey = 0;

                        for (Map.Entry<Integer, Socket> entry : map.entrySet()) {
                            if (entry.getValue().isClosed()) {
                                System.out.println("删除无效socket :" + entry.getKey());
                                delKey = entry.getKey();
                            }
                        }

                        map.remove(delKey);
                    }
                }
            }).start();

            //接受
            while (true) {
                Socket socket = server.accept(); //等待连接
                map.put(socket.getPort(), socket);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String msg = null;
                        try {
                            while ((msg = reader.readLine()) != null) {//保持一直接收
                                if (msg.trim().equals("quit")) {
                                    socket.close();
                                    return;
                                }
                                synchronized (this.getClass()) {
                                    for (Map.Entry<Integer, Socket> entry : map.entrySet()) {
                                        if (entry.getValue() != socket) {
                                            PrintStream ps = new PrintStream(entry.getValue().getOutputStream());
                                            ps.println(socket.getPort() + " : " + msg);
                                        }
                                    }
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
