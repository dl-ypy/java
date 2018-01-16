import java.io.*;
import java.net.*;
import java.nio.channels.AcceptPendingException;

public class ChatServer {

	public static void main(String[] args) {
		boolean started = false;    //�жϷ������Ƿ��Ѿ�����
		
		try {
			ServerSocket ss = new ServerSocket(1234);
			started = true;
			while (started){
				boolean bConnected = false;   //�ж��Ƿ���ͻ�������
				Socket s = ss.accept();
System.out.println("a client connected!");    //�Ժ�Ҫע�͵�д������ߣ�����Ѱ��
				bConnected = true;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while (bConnected){  //ֻҪ�����ϣ��Ϳ���һֱ����
					String str = dis.readUTF();
					System.out.println(str);
				}
				dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
