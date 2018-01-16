package com.ypy.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * date:2017��7��11��10:53:35
 * target�����ӻ����档
 * @author ypy
 */
public class MyJFame {
	public static void main(String[] args) throws IOException {
		JFrame jf = new JFrame();
		//��ʾ����
		jf.setVisible(true);
		//���ô��ڴ�С
		jf.setSize(1000, 1000);
		//�رմ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //ʹ���ھ���
                jf.setLocationRelativeTo(null);
		//��ӻ���
		MyPanel mp = new MyPanel();
		jf.add(mp);
	}
	
}

//������
class MyPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.ORANGE);
		g.setColor(Color.BLACK);
		//��Բ����ʵ�Ǹ�Բ�����о���
		g.drawOval(300, 300, 200, 200);
		//������
		g.drawArc(350, 300, 100, 100, 90, 180);
		g.drawArc(350, 400, 100, 100, 270, 180);
		g.fillOval(385, 335, 30, 30);
		g.fillOval(385, 435, 30, 30);
		g.setFont(new Font("�����п�", Font.BOLD, 55));
		g.drawString("����ͼ", 300, 250);
	}
	
}

/*
***************JDK1.8���н��****************
*/
