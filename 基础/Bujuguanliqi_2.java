/*
		时间：2016年7月20日08:03:57
		目的：布局管理器之GridLayout
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
				f.setLayout(new GridLayout(2, 10));//参数为行和列，输出结果中行肯定为指定数字，但列是根据行数和元素数推算出来的，看多少列就能在指定的行数中放下全部元素
				
				f.add(b1);
				f.add(b2);
				f.add(b3);
				f.add(b4);
				f.add(b5);
				
				f.pack();//如果没有此语句，则输出结果变为一个只有标题的标题栏
				f.setVisible(true);
		}
}
/*
***************结果***************
*/