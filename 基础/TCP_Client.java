/*
ʱ�䣺2016��10��23��10:14:05
Ŀ�ģ�TCP---�ͻ���
*/
import java.net.*;
import java.io.*;

public class TCP_Client{
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("10.163.196.39", 6666);//��������IP�Ͷ�Ӧ����Ķ˿ں�
																					 //��new Socket()�ɹ��������Ӧ������ʱ�г����ڼ���6666�˿ڣ����ӾͻὨ���ɹ�
																					 //��ν���ӳɹ�������˫��������һ��ͨ�Źܵ����ܹ���������
																					 //ֻҪnew Socket()�󣬿ͻ��˾ͻ���������˷����������������Ӳ��ɹ�������ͻ���ֹ
																					 //���ԣ�TCP����ڿͻ����Ҳ���������������Ĵ��룬�����ڷ�������ȴ�н�������Ĵ���
		
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("���");
		
		dos.flush();
		dos.close();
		s.close();
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>javac TCP_Client.java

G:\java\����>java TCP_Client
*/