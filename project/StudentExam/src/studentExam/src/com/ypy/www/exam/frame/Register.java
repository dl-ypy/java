package com.ypy.www.exam.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.ypy.www.exam.tool.Tool;
/**
 * 用户注册
 * @author ypy
 */
public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Register() {
		init();
	}
	
	/**
	 * 初始化界面
	 */
	public void init() {
		setTitle("\u6CE8\u518C\u754C\u9762");
		//只关闭当前窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		contentPane.add(label);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField);
		
		JButton button = new JButton("\u6CE8\u518C");
		//注册按钮的事件响应
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//判断填写格式是否正确
					if ("".equals(textField_1.getText()) || "".equals(textField.getText()) || "".equals(passwordField.getText())) {
						JOptionPane.showMessageDialog(Register.this, "信息不能为空！", null, JOptionPane.WARNING_MESSAGE);
						return;
					} else if (passwordField.getPassword().length != 6){
						JOptionPane.showMessageDialog(Register.this, "密码必须为6位数！", null, JOptionPane.WARNING_MESSAGE);
						return;
					}
					//用户存在
					if(Tool.isExistById(textField_1.getText())) {
						JOptionPane.showMessageDialog(Register.this, "该用户已注册！", null, JOptionPane.WARNING_MESSAGE);
						return;
					}
					//添加学生
					Tool.addStudent(textField_1, textField, passwordField);
					JOptionPane.showMessageDialog(Register.this, "注册成功！", null, JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		//重置按钮的事件响应
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
				passwordField.setText("");
			}
		});
		contentPane.add(btnNewButton);
	}

}
