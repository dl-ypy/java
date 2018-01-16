/*
		时间：2016年7月20日07:35:52
		目的：布局管理器之BorderLayout
*/
import java.awt.*;
public class Bujuguanliqi_1
{
		public static void main(String args[])
		{
				Frame f;
				f = new Frame();
				Button bn = new Button("BN");
				Button bs = new Button("BS");
				Button bw = new Button("BW");
				Button be = new Button("BE");
				Button bc = new Button("BC");
				
				//放到东南西北不同位置
				f.add(bn, BorderLayout.NORTH);
				f.add(bs, BorderLayout.SOUTH);
				f.add(bw, BorderLayout.WEST);
				f.add(be, BorderLayout.EAST);
				f.add(bc, BorderLayout.CENTER);
				
				f.setSize(200, 200);
				f.setVisible(true);
		}
}
/*
***************结果***************
*/