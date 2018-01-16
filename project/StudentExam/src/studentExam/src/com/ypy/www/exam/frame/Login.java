package com.ypy.www.exam.frame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.ypy.www.exam.tool.Tool;
/**
 * 用户登录
 * @author ypy
 */
public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Login() {
		init();
	}
	
	/**
	 * 初始化界面
	 */
	public void init() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//设置窗口位置和大小
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 20));
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 16));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u6CE8\u518C");
		//点击注册后的事件
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1,2两句使得锁定子窗口
				//Login.this.setEnabled(false);//1
				Register register = new Register();
				//register.setAlwaysOnTop(true);//2
				register.setVisible(true);
			}
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u767B\u5F55");
		//点击登录后的事件
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = textField_1.getText();
				try {
					//用户存在
					if (Tool.isExistById(id)) {
						//密码正确
						if (Tool.isMate(id, password)) {
							Properties proScore = new Properties();
							FileInputStream f = new FileInputStream(new File("score.properties"));
							proScore.load(f);
							//判断是否答过题
							if (proScore.getProperty("score"+id) == null) {
								Main main = new Main(id);
								main.setVisible(true);
								//不显示登录界面
								Login.this.setVisible(false);
								new Thread(main).start();
							} else {
								JOptionPane.showMessageDialog(Login.this, "您已完成答题！", null, JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(Login.this, "密码错误！", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(Login.this, "该用户还未注册！", null, JOptionPane.WARNING_MESSAGE);
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(button_1);
	}

}
