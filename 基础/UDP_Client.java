/*
ʱ�䣺2016��10��22��17:36:10
Ŀ�ģ�UDP���---�ͻ��ˣ�Ҫ���������ͬʱ�����У�
*/
import java.net.*;
import java.io.*;

public class UDP_Client{
	public static void main(String[] args) throws Exception{
		
		//������ͷds
		DatagramSocket ds = new DatagramSocket();
		
		long n = 10000L;//Ҫ���͵�����
		//String n = "guvonbneiobin������";
		//���弯װ��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		
		byte[] buf = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("192.168.38.129", 5678));
		
		ds.send(dp);//����
		ds.close();//�ر���ͷ
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>javac UDP_Client.java

G:\java\����>java UDP_Client

G:\java\����>
*/