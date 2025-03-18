package cn.chenjiajin.tcp.demo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient2 {
    //TCP编程-客户端
    public static void main(String[] args) throws Exception {
//        1、先创建一个服务端
        Socket client = new Socket("localhost", 9999);
//        2、从socked中拿到输出流
        OutputStream out = client.getOutputStream();
//        往服务器端发生数据
        out.write("服务端你好 hello".getBytes());
//        3、调用服务端的shutdownOutput方法通知服务端：数据发送完毕
        client.shutdownOutput();
//        4、拿到输入流获取服务器反馈的数据
        InputStream in = client.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            //将拿到的数据转成字符串并打印出来看看
            System.out.println(new String(buffer));
        }
//        5、shutdownInput方法通知服务器端数据接收完毕
        client.shutdownInput();
//        6、关闭socket对象,也相当于关闭两种流
        client.close();
    }
}
