/*
时间：2016年10月22日17:36:10
目的：UDP编程---客户端（要与服务器端同时打开运行）
*/
import java.net.*;
import java.io.*;

public class UDP_Client{
	public static void main(String[] args) throws Exception{
		
		//定义码头ds
		DatagramSocket ds = new DatagramSocket();
		
		long n = 10000L;//要发送的数据
		//String n = "guvonbneiobin有朋友";
		//定义集装箱
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		
		byte[] buf = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("192.168.38.129", 5678));
		
		ds.send(dp);//发送
		ds.close();//关闭码头
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>javac UDP_Client.java

G:\java\基础>java UDP_Client

G:\java\基础>
*/