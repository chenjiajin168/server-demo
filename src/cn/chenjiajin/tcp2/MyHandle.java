package cn.chenjiajin.tcp2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyHandle {

    // 模拟服务器一直在线
    // http://localhost:8080/
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("服务器启动成功");
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new TomcatDemo(socket)).start();
        }
    }

}
