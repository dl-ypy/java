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
 * �û���¼
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
	 * ��ʼ������
	 */
	public void init() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//���ô���λ�úʹ�С
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("�����п�", Font.BOLD, 20));
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.BOLD, 16));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("�����п�", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u6CE8\u518C");
		//���ע�����¼�
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1,2����ʹ�������Ӵ���
				//Login.this.setEnabled(false);//1
				Register register = new Register();
				//register.setAlwaysOnTop(true);//2
				register.setVisible(true);
			}
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u767B\u5F55");
		//�����¼����¼�
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = textField_1.getText();
				try {
					//�û�����
					if (Tool.isExistById(id)) {
						//������ȷ
						if (Tool.isMate(id, password)) {
							Properties proScore = new Properties();
							FileInputStream f = new FileInputStream(new File("score.properties"));
							proScore.load(f);
							//�ж��Ƿ�����
							if (proScore.getProperty("score"+id) == null) {
								Main main = new Main(id);
								main.setVisible(true);
								//����ʾ��¼����
								Login.this.setVisible(false);
								new Thread(main).start();
							} else {
								JOptionPane.showMessageDialog(Login.this, "������ɴ��⣡", null, JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(Login.this, "�������", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(Login.this, "���û���δע�ᣡ", null, JOptionPane.WARNING_MESSAGE);
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
