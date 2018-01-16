package com.ypy.examination.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import com.ypy.examination.util.RuleUtil;
/**
 * 用户登录
 * @author 
 */
public class Login extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel userAccountLabel;
	private JLabel userPwdLabel;
	private JTextField userAccountText;
	private JPasswordField userPwdText;
	private JLabel userTypeLabel;
	private JComboBox<String> userTypeBox;
	private JButton loginButton;
	private JButton exitButton;
	private JPanel panel;
	private JPanel panel2;
	private JLabel welcomeLable;
	

	public Login() {
		init();
	}
	
	/**
	 * 初始化界面
	 */
	private void init() {
		setTitle("我的登录窗口");
		//设置不能缩放
		setResizable(true);
		//设置无边框
		//setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BorderFactory.createEmptyBorder(10, 10, 10, 10);
		panel = new JPanel();
		panel2 = new JPanel(new BorderLayout());
//		panel.setBorder(border);
		//frame.setLocationRelativeTo(null);
		welcomeLable = new JLabel("欢迎王智超进入考试系统",JLabel.CENTER);
		panel.setBackground(Color.gray);
		//设置窗口位置和大小
		setBounds(500, 320, 450, 250);
		setContentPane(panel2);
		panel.setLayout(new GridLayout(4, 2, 10, 10));
		userAccountLabel = new JLabel("用户名：");
		
		
		userAccountText = new JTextField();
		
		
		userPwdLabel = new JLabel("用户密码：");
		
		
		userPwdText = new JPasswordField();
		
		
		userTypeLabel = new JLabel("用户身份：");
		
		
		String[] str = {"管理员","普通用户"};
		userTypeBox = new JComboBox<>(str);
		loginButton = new JButton("登录");
		exitButton = new JButton("注销");
		
		panel.add(userAccountLabel);
		panel.add(userAccountText);
		panel.add(userPwdLabel);
		panel.add(userPwdText);
		panel.add(userTypeLabel);
		panel.add(userTypeBox);
		panel.add(loginButton);
		panel.add(exitButton);
		panel2.add("North", welcomeLable);
		panel2.add("Center", panel);
		panel.setBackground(Color.red);
		myEvent();
	}
	
	public void myEvent() {
		//点击退出按钮
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//点击登录按钮
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//得到用户账户、密码和身份
				String user_account = userAccountText.getText();
				String user_password = String.valueOf(userPwdText.getPassword());
				String user_type_str = userTypeBox.getItemAt(userTypeBox.getSelectedIndex());
				int user_type = -1;
				if (user_account.equals("") || user_password.equals("")) {
					JOptionPane.showMessageDialog(Login.this, "用户名或密码为空！", null, JOptionPane.WARNING_MESSAGE);
				} else {
					if ("管理员".equals(user_type_str)) {
						user_type = 1;
						int user_id = RuleUtil.userExist(user_account, user_password, user_type);
						if (user_id != -1) {
							ManagerMenu managerMenu = new ManagerMenu(user_id, Login.this);
							managerMenu.setVisible(true);
							Login.this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(Login.this, "用户名或密码错误！", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						user_type = 0;
						int user_id = RuleUtil.userExist(user_account, user_password, user_type);
						if (user_id != -1) {
							StudentMenu menu = new StudentMenu(user_id, Login.this);
							menu.setVisible(true);
							Login.this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(Login.this, "用户名或密码错误！", null, JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
	}
}

