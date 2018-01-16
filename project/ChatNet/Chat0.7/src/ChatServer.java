import java.io.*;
import java.net.*;
import java.nio.channels.AcceptPendingException;

public class ChatServer {

	public static void main(String[] args) {
		boolean started = false;    //判断服务器是否已经启动
		
		try {
			ServerSocket ss = new ServerSocket(1234);
			started = true;
			while (started){
				boolean bConnected = false;   //判断是否与客户端连接
				Socket s = ss.accept();
System.out.println("a client connected!");    //以后要注释的写到最左边，方便寻找
				bConnected = true;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while (bConnected){  //只要连接上，就可以一直接收
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
