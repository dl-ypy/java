import java.io.*;
import java.net.*;

public class ChatServer {
	boolean started = false;    //�жϷ������Ƿ��Ѿ�����
	ServerSocket ss = null;

	public static void main(String[] args) {
		new ChatServer().start();
	}
	
	//����ֱ����main������new�ڲ��࣬��Ϊmain������static��
	//������һ��������new
	public void start(){
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
				Socket s = ss.accept();
				Client c = new Client(s);
System.out.println("a client connected!");    //�Ժ�Ҫע�͵�д������ߣ�����Ѱ��
				new Thread(c).start();				
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
	
	//һ���ڲ�����̣߳��Ƿ����ڲ���ȡ�����ǲ���ֻ������ʹ�ã�
	class Client implements Runnable{
		private Socket s;
		private DataInputStream dis = null;
		private boolean bConnected = false;
		
		public Client(Socket s){
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				while (bConnected){  //ֻҪ�����ϣ��Ϳ���һֱ����
					String str = dis.readUTF();     //�������˳��ֵĴ���������������
					   								//�ر��˿ͻ��ˣ�û�пɶ��Ķ�����
                    								//������Ҫ��finally�ｫDataInputStream��Socket�ص�
					System.out.println(str);
				}
			}catch (EOFException e){
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
}
