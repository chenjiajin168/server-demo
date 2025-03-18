package cn.chenjiajin.tcp.demo1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    //TCP编程-客户端
    public static void main(String[] args) throws Exception {
        //1、先创建一个连接某个服务器的socket对象
        Socket client = new Socket("127.0.0.1", 8888);
        //2、从socked中拿到输出流往服务器端发生数据
        OutputStream out = client.getOutputStream();
        //往服务器发送数据
        out.write("客户端: 你好，服务器！".getBytes("UTF-8"));
        //3、调用客户端的shutdownOutput方法通知服务端数据发送完毕
        client.shutdownOutput();
        //4、从socoet中拿到输入流获取服务器反馈的数据
        InputStream is = client.getInputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = is.read(buffer)) != -1) {
            //数据在buffer里，拿出来
            System.out.println(new String(buffer, 0, len, "UTF-8"));
            //转换成字节数组可以指定编码格式
        }
        //5、调用socket对象的shutdownInput方法通知服务器端数据接收完毕
        client.shutdownInput();
        //6、关闭socket对象
        client.close();
    }
}
