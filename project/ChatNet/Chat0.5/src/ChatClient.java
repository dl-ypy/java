/*
 * ʱ�䣺2016��12��10��21:27:35
 * �汾��0.5
 * Ŀ�ģ��ͻ������ӷ�������
 */
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Frame{

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	
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
			Socket s = new Socket("10.163.194.139", 1234);
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
		public void actionPerformed(ActionEvent e) {
			String s = tfTxt.getText().trim();//�õ�tfTxt������ݣ���ȥ���ո�
			taContent.setText(s);
			tfTxt.setText("");                //�ûس���tfTxt�������
		}
		
	}

}









