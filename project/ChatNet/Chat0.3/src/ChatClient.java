/*
 * 时间：2016年12月10日21:02:42
 * 版本：0.3
 * 目的：为tfTxt组件添加回车响应事件。
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
		
		tfTxt.addActionListener(new TFListener());//将响应事件添加到tfTxt组件（该组件本身自带响应事件的方法）
		
		this.setVisible(true);		          //将图形界面设置为可见
	}
	
	//内部类
	private class TFListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = tfTxt.getText().trim();//得到tfTxt里的内容，并去掉空格
			taContent.setText(s);
			tfTxt.setText("");                //敲回车后tfTxt里面清空
		}
		
	}

}









