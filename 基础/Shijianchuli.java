/*
	ʱ�䣺2016��7��30��10:36:50
	Ŀ�ģ��¼�����
*/
import java.awt.*;
import java.awt.event.*;  //�¼�������Ҫ�İ�

public class Shijianchuli
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		Button bn = new Button("OK");
		f.add(bn);
		A aa = new A();
		B bb = new B();
		
		bn.addActionListener(aa);    //��aa����������ťbn���¼�
		
		f.pack();
		f.addWindowListener(bb);
		f.setVisible(true);
	}
}

class A implements ActionListener    //�����¼���Ĳ���
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("����������������");
	}
}

class B extends WindowAdapter
{
	public void windowClosing(WindowEvent e)         //����ر��ܹ��رմ���,�������Ʋ��ܱ�
	{
		System.exit(-1);
	}
}
/*
***************���***************

*/