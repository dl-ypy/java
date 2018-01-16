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
 * �û�ע��
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
	 * ��ʼ������
	 */
	public void init() {
		setTitle("\u6CE8\u518C\u754C\u9762");
		//ֻ�رյ�ǰ����
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
		//ע�ᰴť���¼���Ӧ
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//�ж���д��ʽ�Ƿ���ȷ
					if ("".equals(textField_1.getText()) || "".equals(textField.getText()) || "".equals(passwordField.getText())) {
						JOptionPane.showMessageDialog(Register.this, "��Ϣ����Ϊ�գ�", null, JOptionPane.WARNING_MESSAGE);
						return;
					} else if (passwordField.getPassword().length != 6){
						JOptionPane.showMessageDialog(Register.this, "�������Ϊ6λ����", null, JOptionPane.WARNING_MESSAGE);
						return;
					}
					//�û�����
					if(Tool.isExistById(textField_1.getText())) {
						JOptionPane.showMessageDialog(Register.this, "���û���ע�ᣡ", null, JOptionPane.WARNING_MESSAGE);
						return;
					}
					//���ѧ��
					Tool.addStudent(textField_1, textField, passwordField);
					JOptionPane.showMessageDialog(Register.this, "ע��ɹ���", null, JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		//���ð�ť���¼���Ӧ
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
