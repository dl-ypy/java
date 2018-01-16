/*
时间：2016年10月23日10:14:05
目的：TCP---客户端
*/
import java.net.*;
import java.io.*;

public class TCP_Client{
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("10.163.196.39", 6666);//连接主机IP和对应程序的端口号
																					 //当new Socket()成功后，如果对应主机此时有程序在监听6666端口，连接就会建立成功
																					 //所谓连接成功，就是双方建立了一个通信管道，能够传送数据
																					 //只要new Socket()后，客户端就会向服务器端发送连接请求，如连接不成功，程序就会终止
																					 //所以，TCP编程在客户端找不到发送连接请求的代码，但是在服务器端却有接受请求的代码
		
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("你好");
		
		dos.flush();
		dos.close();
		s.close();
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>javac TCP_Client.java

G:\java\基础>java TCP_Client
*/