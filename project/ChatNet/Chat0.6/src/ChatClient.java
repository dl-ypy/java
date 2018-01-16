/*
 * ʱ�䣺2016��12��11��09:49:58
 * �汾��0.6
 * Ŀ�ģ��ûس���һ����Ϣ������ʾ��������������������
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Frame{

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	Socket s = null;
	String str = null;
	
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
				System.exit(0);
			}
		});
		
		tfTxt.addActionListener(new TFListener());//����Ӧ�¼���ӵ�tfTxt���������������Դ���Ӧ�¼��ķ�����
		
		this.setVisible(true);		          //��ͼ�ν�������Ϊ�ɼ�
		connect();                            //���ӵ�������
	}
	
	//���ӷ����
	public void connect(){
		try {
			s = new Socket("10.163.194.139", 1234);
System.out.println("connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//�ڲ���
	private class TFListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {//�ûس��ͻ����
			str = tfTxt.getText().trim();//�õ�tfTxt������ݣ���ȥ���ո�
			taContent.setText(str);
			tfTxt.setText("");                //�ûس���tfTxt�������
			SendServer();
		}
		
	}
	
	//����Ϣ���Ͳ���ʾ����������
	public void SendServer(){
		try {
			DataOutputStream dous = new DataOutputStream(s.getOutputStream());
			dous.writeUTF(str);
			dous.flush();
			dous.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









