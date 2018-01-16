/*
 * 时间：2016年12月10日10:56:55
 * 版本：0.2
 * 目的：添加两个组件。
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
		this.setLocation(400, 300);           //设置图形界面左上角的坐标
		this.setSize(300, 300);		          //设置组件的宽高
		
		add(tfTxt, BorderLayout.SOUTH);       //添加组件到窗口的南边
		add(taContent, BorderLayout.NORTH);
		pack();                               //使窗口正好容纳所有组件
		//关闭窗口
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.setVisible(true);		          //将图形界面设置为可见
	}

}
