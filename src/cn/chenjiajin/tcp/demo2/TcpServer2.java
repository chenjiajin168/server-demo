package cn.chenjiajin.tcp.demo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer2 {
    //TCP编程-服务端
    public static void main(String[] args) throws Exception {
//        1:创建一个服务端对象(ServerSocket)
        ServerSocket serverSocket = new ServerSocket(9999);
//        2:等待接收数据，阻塞方法accept
        Socket socket = serverSocket.accept();
//        3:获取输入流, 接收客户端发送的数据
        InputStream in = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            //将拿到的数据转成字符串并打印出来看看
            System.out.println(new String(buffer));
        }
//        4:调用服务端的shutdownInput方法通知客户端数据接收完毕
        socket.shutdownInput();

//        5:从服务端往客户端发送数据，获取输出流
        OutputStream out = socket.getOutputStream();
        out.write("你送的礼物收到了".getBytes());
        //6:告知客户端，发送数据结束
        socket.shutdownOutput();
//        out.close();
//        7:关闭Socket对象
        socket.close();


    }
}
