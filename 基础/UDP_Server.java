/*
ʱ�䣺2016��10��22��17:21:16
Ŀ�ģ�UDP���---�������ˣ�Ҫ��ͻ���ͬʱ�����У�
*/
import java.net.*;
import java.io.*;

//�����������ͷ��װ��
public class UDP_Server{
	public static void main(String[] args) throws Exception{
		//������ͷ
		DatagramSocket ds = new DatagramSocket(5678);  //5678��ʾ�˷�����ռ�õĶ˿ں�
		//������������������ݵļ�װ��
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		try{
			while (true){
				//����ͷ���ü�װ����ܶԷ����͹���������
				ds.receive(dp);
				
				//�Ӽ�װ����ȡ���Է����͵�����
				ByteArrayInputStream bais = new ByteArrayInputStream(buf);
				DataInputStream dis = new DataInputStream(bais);
				System.out.println(dis.readLong());
			}
		}
		catch (Exception e){
			e.printStackTrace();
			ds.close();//�ر���ͷ
		}
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>javac UDP_Server.java

G:\java\����>java UDP_Server
10000

*/