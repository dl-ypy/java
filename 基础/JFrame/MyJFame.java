package com.ypy.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * date:2017年7月11日10:53:35
 * target：可视化界面。
 * @author ypy
 */
public class MyJFame {
	public static void main(String[] args) throws IOException {
		JFrame jf = new JFrame();
		//显示窗口
		jf.setVisible(true);
		//设置窗口大小
		jf.setSize(1000, 1000);
		//关闭窗口
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //使窗口居中
                jf.setLocationRelativeTo(null);
		//添加画布
		MyPanel mp = new MyPanel();
		jf.add(mp);
	}
	
}

//画布类
class MyPanel extends JPanel {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.ORANGE);
		g.setColor(Color.BLACK);
		//画圆，其实是该圆的外切矩形
		g.drawOval(300, 300, 200, 200);
		//画弧线
		g.drawArc(350, 300, 100, 100, 90, 180);
		g.drawArc(350, 400, 100, 100, 270, 180);
		g.fillOval(385, 335, 30, 30);
		g.fillOval(385, 435, 30, 30);
		g.setFont(new Font("华文行楷", Font.BOLD, 55));
		g.drawString("八卦图", 300, 250);
	}
	
}

/*
***************JDK1.8运行结果****************
*/
