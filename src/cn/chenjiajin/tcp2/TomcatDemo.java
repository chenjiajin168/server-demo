package cn.chenjiajin.tcp2;

import java.io.*;
import java.net.Socket;

public class TomcatDemo implements Runnable {
    private Socket socket;

    public TomcatDemo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = null;
            while ((str = reader.readLine()) != null) {
                if (str.equals("")) {
                    break;
                }
                System.out.println(str);
            }
            //告知客户端：读完了
            socket.shutdownInput();
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type:text/html;charset=utf-8");
            writer.println();
            writer.println("<html><hred></hred><body>你送的礼物收到了</body></html>");
            writer.flush();
            socket.shutdownOutput();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
