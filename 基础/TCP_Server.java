/*
ʱ�䣺2016��10��23��10:28:53
Ŀ�ģ�TCP---��������
*/
import java.net.*;
import java.io.*;

public class TCP_Server{
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(6666);//new����ss���󲢲����Զ������ͻ��˷���������
		
		while (true){
			Socket s = ss.accept();//�ȴ��ͻ��˵���������
														 //�����sʵ�ʾ������ӵ��ͻ��˵�s
														 //accept������ʽ���������Ӳ����ͻ�����
			
			System.out.println("һ�������Ѿ�����");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		}
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>javac TCP_Server.java

G:\java\����>java TCP_Server
һ�������Ѿ�����
���
*/