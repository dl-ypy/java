/*
 * 时间：2016年12月10日10:36:17
 * 版本：0.1
 * 目的：显示出窗口
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame{

	public static void main(String[] args) {
		new ChatClient().LaunchFrame();
	}
	
	public void LaunchFrame(){
		this.setLocation(400, 300);  //设置图形界面左上角的坐标
		this.setSize(300, 300);		 //设置组件的宽高
		//关闭窗口
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);		 //将图形界面设置为可见
	}

}
