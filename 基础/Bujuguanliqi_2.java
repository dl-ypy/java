/*
		ʱ�䣺2016��7��20��08:03:57
		Ŀ�ģ����ֹ�����֮GridLayout
*/
import java.awt.*;
public class Bujuguanliqi_2
{
		public static void main(String args[])
		{
				Frame f;
				f = new Frame();
				Button b1 = new Button("b1");
				Button b2 = new Button("b2");
				Button b3 = new Button("b3");
				Button b4 = new Button("b4");
				Button b5 = new Button("b5");
				f.setLayout(new GridLayout(2, 10));//����Ϊ�к��У����������п϶�Ϊָ�����֣������Ǹ���������Ԫ������������ģ��������о�����ָ���������з���ȫ��Ԫ��
				
				f.add(b1);
				f.add(b2);
				f.add(b3);
				f.add(b4);
				f.add(b5);
				
				f.pack();//���û�д���䣬����������Ϊһ��ֻ�б���ı�����
				f.setVisible(true);
		}
}
/*
***************���***************
*/