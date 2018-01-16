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
System.out.println("a client connected!");    //以后要注释的写到最左边，方便寻找
				AcceptMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//接受从客户端发来的消息
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
