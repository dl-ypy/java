package com.ypy.examination.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentMenu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private Login login;
	private JPanel panel;
	private JPanel panel2;
	private JLabel welcomeLable;
	private JButton examButton;
	private JButton selectUserButton;
	private JButton selectScoreButton;
	private JButton logoutButton;
	
	public StudentMenu(int uer_id, Login login) {
		this.user_id = uer_id;
		this.login = login;
		init();
	}

	public void init() {
		setTitle("学生菜单");
		setBounds(750, 530, 500, 200);
		panel = new JPanel(new BorderLayout());
		panel2 = new JPanel(new FlowLayout());
		welcomeLable = new JLabel("欢迎进入学生菜单！",JLabel.CENTER);
		welcomeLable.setFont(new Font("华文行楷", Font.BOLD, 30));
		examButton = new JButton("开始考试");
		selectUserButton = new JButton("我的信息");
		selectScoreButton = new JButton("我的成绩");
		logoutButton = new JButton("注销");
		panel2.add(examButton);
		panel2.add(selectUserButton);
		
		panel2.add(logoutButton);
		panel.add("North", welcomeLable);
		panel.add("Center", panel2);
		panel.setBackground(Color.red);
		setContentPane(panel);
		MyEvent();
	}

	public void MyEvent() {
		//开始考试按钮
		examButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Exam exam = new Exam(user_id);
				exam.setVisible(true);
				new Thread(exam).start();
			}
		});
		
		//我的信息按钮
		selectUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MyInformation information = new MyInformation(user_id);
				information.setVisible(true);
			}
		});
		
		//我的成绩按钮
		selectScoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyScore myScore = new MyScore(user_id);
				myScore.setVisible(true);
			}
		});
		
		//注销按钮
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentMenu.this.setVisible(false);
				login.setVisible(true);
			}
		});
	}

}
