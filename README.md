手写服务器demo
理解服务器的核心原理
步骤:
1.创建一个服务端对象(ServerSocket)
2.侦听客户端的连接,获取和客户端通信的Socket对象
3.从Socket获取输入流,接收服务器发送的数据
4.调用Socket对象对象shutdownInput方法通知客户端数据接收完毕
5.从Socket中拿到输出流往客户端发送数据
6.调用Socket对象对象shutdownOutput方法通知客户端数据发送完毕
7.关闭Socket对象
