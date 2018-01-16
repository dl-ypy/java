/*
 * 时间：2016年12月12日18:50:22
 * 版本：1.1
 * 目的：客户端接收服务器端传过来的消息。
 * 思路：运用线程。
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ChatClient extends Frame{

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	Socket s = null;
	String str = null;
	DataOutputStream dous = null;
	DataInputStream dis = null;
	private boolean bConnected = false; 
	
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
				disConnect();                 //关闭窗口时断开连接
				System.exit(0);
			}
		});
		
		tfTxt.addActionListener(new TFListener());//将响应事件添加到tfTxt组件（该组件本身自带响应事件的方法）
		
		this.setVisible(true);		          //将图形界面设置为可见
		connect();                            //连接到服务器
		
		new Thread(new RecvThread()).start();
	}
	
	//连接服务端
	public void connect(){
		try {
			s = new Socket("10.163.194.139", 1234);
			dous = new DataOutputStream(s.getOutputStream());//只要连接上就用这个流，就能不断的发送
			dis = new DataInputStream(s.getInputStream());
System.out.println("connected!");
			bConnected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//断开连接
	public void disConnect(){
		try {
			bConnected = false;                     //先关闭线程  否则会出错
			if (dous != null) dous.close();         //断开连接前才关闭流
			if (dis != null) dis.close();
			if (s != null) s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//内部类
	private class TFListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {//敲回车就会调用
			str = tfTxt.getText().trim();//得到tfTxt里的内容，并去掉空格
			//taContent.setText(str);
			tfTxt.setText("");                //敲回车后tfTxt里面清空
			SendServer();
		}
		
	}
	
	//接收服务器端消息的线程
	private class RecvThread implements Runnable{

		@Override
		public void run() {
			try{
				while (bConnected) {
					String str = dis.readUTF();
					//System.out.println(str);
					taContent.setText(taContent.getText() + str + "\n");//加上换行
				}
			} catch (SocketException e) {
				System.out.println("退出了！");
		    } catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//将消息发送并显示到服务器端
	public void SendServer(){
		try {
			dous.writeUTF(str);
			dous.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









