import java.io.*;
import java.net.*;
import java.nio.channels.AcceptPendingException;

public class ChatServer {

	public static void main(String[] args) {
		boolean started = false;    //判断服务器是否已经启动
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		
		try {
			ss = new ServerSocket(1234);
		} catch (BindException e){
			System.out.println("该端口已被使用...");
			System.out.println("请关闭相关程序并重启服务器！");
			System.exit(0);      //提示错误后关闭程序
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {	
			started = true;
			while (started){
				boolean bConnected = false;   //判断是否与客户端连接
				s = ss.accept();
System.out.println("a client connected!");    //以后要注释的写到最左边，方便寻找
				bConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while (bConnected){  //只要连接上，就可以一直接收
					String str = dis.readUTF();    //服务器端出现的错误就是这里引起的
												   //关闭了客户端，没有可读的东西了
					                               //所以需要在finally里将DataInputStream和Socket关掉
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
