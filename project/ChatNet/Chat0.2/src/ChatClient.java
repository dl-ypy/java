/*
 * ʱ�䣺2016��12��10��10:56:55
 * �汾��0.2
 * Ŀ�ģ�������������
 */
import java.awt.*;
import java.awt.event.*;

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
		
		this.setVisible(true);		          //��ͼ�ν�������Ϊ�ɼ�
	}

}
