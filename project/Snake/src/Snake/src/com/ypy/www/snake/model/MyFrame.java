package com.ypy.www.snake.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * 画板类
 * @author ypy
 */
public class MyFrame {
	public static void draw() throws IOException {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//读取配置文件
		Properties pro = new Properties();
		InputStream ips = new FileInputStream("snake.properties");
		pro.load(ips);
		//读取到蛇的尺寸
		int size = Integer.parseInt(pro.getProperty("size"));
		//读取游戏难度
		int level = Integer.parseInt(pro.getProperty("level"));
		if (size>=10 && size<=100) {
			if (level==-1||level==0||level==1) {
				Snake snake = new Snake(size, size, Direction.RIGHT,size);
				MyPanel mp = new MyPanel(snake, size, level);
				jf.add(mp);
				jf.addKeyListener(mp);
				new Thread(mp).start();
			} else {
				JOptionPane.showMessageDialog(jf, "难度设置错误！请设置1、0或-1！", null, JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(jf, "蛇的尺寸设置不合适！  范围（10~100）", null, JOptionPane.WARNING_MESSAGE);
		}
	}
}
