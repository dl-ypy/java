/*
 * ʱ�䣺2016��12��12��11:17:02
 * �汾��1.0
 * Ŀ�ģ����������˽��յ�����Ϣ���͸��ͻ��ˡ�
 * ˼·���ü��ϱ���ͻ��˵�Socket��
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
	DataOutputStream dous = null;
	
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
	}
	
	//���ӷ����
	public void connect(){
		try {
			s = new Socket("10.163.194.139", 1234);
			dous = new DataOutputStream(s.getOutputStream());//ֻҪ�����Ͼ�������������ܲ��ϵķ���
System.out.println("connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//�Ͽ�����
	public void disConnect(){
		try {
			dous.close();         //�Ͽ�����ǰ�Źر���
			s.close();
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
			dous.writeUTF(str);
			dous.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









