/*
 * ʱ�䣺2016��12��10��10:36:17
 * �汾��0.1
 * Ŀ�ģ���ʾ������
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame{

	public static void main(String[] args) {
		new ChatClient().LaunchFrame();
	}
	
	public void LaunchFrame(){
		this.setLocation(400, 300);  //����ͼ�ν������Ͻǵ�����
		this.setSize(300, 300);		 //��������Ŀ��
		//�رմ���
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);		 //��ͼ�ν�������Ϊ�ɼ�
	}

}
