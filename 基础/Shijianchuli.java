/*
	时间：2016年7月30日10:36:50
	目的：事件处理。
*/
import java.awt.*;
import java.awt.event.*;  //事件发生需要的包

public class Shijianchuli
{
	public static void main(String[] args)
	{
		Frame f = new Frame();
		Button bn = new Button("OK");
		f.add(bn);
		A aa = new A();
		B bb = new B();
		
		bn.addActionListener(aa);    //用aa监听单击按钮bn的事件
		
		f.pack();
		f.addWindowListener(bb);
		f.setVisible(true);
	}
}

class A implements ActionListener    //触发事件后的操作
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("哈哈哈哈哈哈哈哈");
	}
}

class B extends WindowAdapter
{
	public void windowClosing(WindowEvent e)         //点击关闭能够关闭窗口,方法名称不能变
	{
		System.exit(-1);
	}
}
/*
***************结果***************

*/