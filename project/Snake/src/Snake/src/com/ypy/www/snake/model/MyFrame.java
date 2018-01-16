package com.ypy.www.snake.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * ������
 * @author ypy
 */
public class MyFrame {
	public static void draw() throws IOException {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ȡ�����ļ�
		Properties pro = new Properties();
		InputStream ips = new FileInputStream("snake.properties");
		pro.load(ips);
		//��ȡ���ߵĳߴ�
		int size = Integer.parseInt(pro.getProperty("size"));
		//��ȡ��Ϸ�Ѷ�
		int level = Integer.parseInt(pro.getProperty("level"));
		if (size>=10 && size<=100) {
			if (level==-1||level==0||level==1) {
				Snake snake = new Snake(size, size, Direction.RIGHT,size);
				MyPanel mp = new MyPanel(snake, size, level);
				jf.add(mp);
				jf.addKeyListener(mp);
				new Thread(mp).start();
			} else {
				JOptionPane.showMessageDialog(jf, "�Ѷ����ô���������1��0��-1��", null, JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(jf, "�ߵĳߴ����ò����ʣ�  ��Χ��10~100��", null, JOptionPane.WARNING_MESSAGE);
		}
	}
}
