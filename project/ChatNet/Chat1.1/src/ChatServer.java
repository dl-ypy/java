import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	boolean started = false;    //判断服务器是否已经启动
	ServerSocket ss = null;
	
	List<Client> clients = new ArrayList<Client>();     //定义集合

	public static void main(String[] args) {
		new ChatServer().start();
	}
	
	//不能直接在main方法中new内部类，因为main方法是static的
	//这里用一个方法来new
	public void start(){
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
				Socket s = ss.accept();
				Client c = new Client(s);
System.out.println("a client connected!");    //以后要注释的写到最左边，方便寻找
				new Thread(c).start();	
				clients.add(c);    //添加到结合中
				//dis.close();
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (ss != null) ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//一个内部类的线程（是否用内部类取决于是不是只被本类使用）
	class Client implements Runnable{
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;
		
		public Client(Socket s){
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//给客户端发送消息
		public void send(String str){
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				while (bConnected){  //只要连接上，就可以一直接收
					String str = dis.readUTF();     //服务器端出现的错误就是这里引起的
					   								//关闭了客户端，没有可读的东西了
                    								//所以需要在finally里将DataInputStream和Socket关掉
System.out.println(str);
					for (int i=0; i<clients.size(); i++){
						Client c = clients.get(i);
						c.send(str);
					}
				}
			}catch (EOFException e){
				System.out.println("client closed!");
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if (dis != null) dis.close();
					if (dos != null) dos.close();
					if (s != null) s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
