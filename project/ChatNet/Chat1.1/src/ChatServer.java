import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	boolean started = false;    //�жϷ������Ƿ��Ѿ�����
	ServerSocket ss = null;
	
	List<Client> clients = new ArrayList<Client>();     //���弯��

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
				clients.add(c);    //��ӵ������
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
		
		//���ͻ��˷�����Ϣ
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
				while (bConnected){  //ֻҪ�����ϣ��Ϳ���һֱ����
					String str = dis.readUTF();     //�������˳��ֵĴ���������������
					   								//�ر��˿ͻ��ˣ�û�пɶ��Ķ�����
                    								//������Ҫ��finally�ｫDataInputStream��Socket�ص�
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
