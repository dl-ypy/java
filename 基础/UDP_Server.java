/*
时间：2016年10月22日17:21:16
目的：UDP编程---服务器端（要与客户端同时打开运行）
*/
import java.net.*;
import java.io.*;

//打个比喻，码头集装箱
public class UDP_Server{
	public static void main(String[] args) throws Exception{
		//定义码头
		DatagramSocket ds = new DatagramSocket(5678);  //5678表示此服务器占用的端口号
		//定义可以用来接收数据的集装箱
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		try{
			while (true){
				//在码头上用集装箱接受对方发送过来的数据
				ds.receive(dp);
				
				//从集装箱中取出对方发送的数据
				ByteArrayInputStream bais = new ByteArrayInputStream(buf);
				DataInputStream dis = new DataInputStream(bais);
				System.out.println(dis.readLong());
			}
		}
		catch (Exception e){
			e.printStackTrace();
			ds.close();//关闭码头
		}
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>javac UDP_Server.java

G:\java\基础>java UDP_Server
10000

*/