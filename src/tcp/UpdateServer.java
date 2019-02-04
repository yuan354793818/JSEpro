package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by YJY on 2018/9/22.
 */
public class UpdateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread() {
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                        PrintStream printStream = new PrintStream(socket.getOutputStream());

                        String filename = br.readLine();

                        File dir = new File("update");

                        dir.mkdir();

                        File file = new File(dir, filename);

                        if (file.exists()) {
                            printStream.println("exist");
                            socket.close();
                        } else {
                            printStream.println("ok");
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            byte[] buf = new byte[8196];
                            int len;
                            while ((len = inputStream.read(buf)) != -1) {
                                fileOutputStream.write(buf, 0, len);
                            }
                            fileOutputStream.close();
                            socket.close();
                        }
                    } catch (IOException e  ) {
                        e.printStackTrace();
                    }

                    }
                }.start();
            }

        }
    }
