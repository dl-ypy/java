import java.io.*;
import java.net.*;
import java.nio.channels.AcceptPendingException;

public class ChatServer {

	public static void main(String[] args) {
		boolean started = false;    //�жϷ������Ƿ��Ѿ�����
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		
		try {
			ss = new ServerSocket(1234);
		} catch (BindException e){
			System.out.println("�ö˿��ѱ�ʹ��...");
			System.out.println("��ر���س���������������");
			System.exit(0);      //��ʾ�����رճ���
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {	
			started = true;
			while (started){
				boolean bConnected = false;   //�ж��Ƿ���ͻ�������
				s = ss.accept();
System.out.println("a client connected!");    //�Ժ�Ҫע�͵�д������ߣ�����Ѱ��
				bConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while (bConnected){  //ֻҪ�����ϣ��Ϳ���һֱ����
					String str = dis.readUTF();    //�������˳��ֵĴ���������������
												   //�ر��˿ͻ��ˣ�û�пɶ��Ķ�����
					                               //������Ҫ��finally�ｫDataInputStream��Socket�ص�
					System.out.println(str);
				}
				//dis.close();
			}
		} catch (EOFException e){
			System.out.println("client closed!");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (dis != null) dis.close();
				if (s != null) s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
