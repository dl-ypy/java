/*
时间：2016年10月23日10:28:53
目的：TCP---服务器端
*/
import java.net.*;
import java.io.*;

public class TCP_Server{
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(6666);//new出的ss对象并不会自动监听客户端发出的请求
		
		while (true){
			Socket s = ss.accept();//等待客户端的连接请求
														 //这里的s实际就是连接到客户端的s
														 //accept是阻塞式方法，连接不到就会阻塞
			
			System.out.println("一个连接已经建立");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>javac TCP_Server.java

G:\java\基础>java TCP_Server
一个连接已经建立
你好
*/