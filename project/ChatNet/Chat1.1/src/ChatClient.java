/*
 * ʱ�䣺2016��12��12��18:50:22
 * �汾��1.1
 * Ŀ�ģ��ͻ��˽��շ������˴���������Ϣ��
 * ˼·�������̡߳�
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatClient extends Frame{

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	Socket s = null;
	String str = null;
	DataOutputStream dous = null;
	DataInputStream dis = null;
	private boolean bConnected = false; 
	
	public static void main(String[] args) {
		new ChatClient().LaunchFrame();
	}
	
	public void LaunchFrame(){
		this.setLocation(400, 300);           //����ͼ�ν������Ͻǵ�����
		this.setSize(300, 300);		          //��������Ŀ��
		
		add(tfTxt, BorderLayout.SOUTH);       //�����������ڵ��ϱ�
		add(taContent, BorderLayout.NORTH);
		pack();                               //ʹ�������������������
		
		//�رմ���
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				disConnect();                 //�رմ���ʱ�Ͽ�����
				System.exit(0);
			}
		});
		
		tfTxt.addActionListener(new TFListener());//����Ӧ�¼���ӵ�tfTxt���������������Դ���Ӧ�¼��ķ�����
		
		this.setVisible(true);		          //��ͼ�ν�������Ϊ�ɼ�
		connect();                            //���ӵ�������
		
		new Thread(new RecvThread()).start();
	}
	
	//���ӷ����
	public void connect(){
		try {
			s = new Socket("10.163.194.139", 1234);
			dous = new DataOutputStream(s.getOutputStream());//ֻҪ�����Ͼ�������������ܲ��ϵķ���
			dis = new DataInputStream(s.getInputStream());
System.out.println("connected!");
			bConnected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//�Ͽ�����
	public void disConnect(){
		try {
			bConnected = false;                     //�ȹر��߳�  ��������
			if (dous != null) dous.close();         //�Ͽ�����ǰ�Źر���
			if (dis != null) dis.close();
			if (s != null) s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//�ڲ���
	private class TFListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {//�ûس��ͻ����
			str = tfTxt.getText().trim();//�õ�tfTxt������ݣ���ȥ���ո�
			//taContent.setText(str);
			tfTxt.setText("");                //�ûس���tfTxt�������
			SendServer();
		}
		
	}
	
	//���շ���������Ϣ���߳�
	private class RecvThread implements Runnable{

		@Override
		public void run() {
			try{
				while (bConnected) {
					String str = dis.readUTF();
					//System.out.println(str);
					taContent.setText(taContent.getText() + str + "\n");//���ϻ���
				}
			} catch (SocketException e) {
				System.out.println("�˳��ˣ�");
		    } catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//����Ϣ���Ͳ���ʾ����������
	public void SendServer(){
		try {
			dous.writeUTF(str);
			dous.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









