package cn.chenjiajin.tcp.demo1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    //TCP编程-服务端
    public static void main(String[] args) throws Exception {
        //1:创建一个服务端对象(ServerSocket)，可以省略ip地址
        ServerSocket serverSocket = new ServerSocket(8888);

        //2:accept方法侦听客户端的连接, 获取和客户端通信的Socket对象
        Socket socket = serverSocket.accept();

        //3:从Socket获取输入流, 接收客户端发送的数据
        InputStream is = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len, "UTF-8"));
        }

        //4:调用服务端的shutdownInput方法通知客户端数据接收完毕
        socket.shutdownInput();
        //5:从服务端中拿到输出流往客户端发送数据
        OutputStream out = socket.getOutputStream();
        out.write("服务器: 在线，你好啊客户端".getBytes("UTF-8"));
        //6:调用服务端的shutdownOutput方法通知客户端数据发送完毕
        socket.shutdownOutput();
        //7:关闭服务端的Socket对象，顺便关闭两个流
        socket.close();


    }
}
