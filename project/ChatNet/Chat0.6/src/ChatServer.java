import java.io.*;
import java.net.*;
import java.nio.channels.AcceptPendingException;

public class ChatServer {
	static Socket s = null;

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			while (true){
				s = ss.accept();
System.out.println("a client connected!");    //�Ժ�Ҫע�͵�д������ߣ�����Ѱ��
				AcceptMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���ܴӿͻ��˷�������Ϣ
	public static void AcceptMessage(){
		try {
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = dis.readUTF();
			System.out.println(str);
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
