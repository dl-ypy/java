package com.ypy.examination.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ypy.examination.model.User;
import com.ypy.examination.service.impl.UserServiceImpl;

public class UpdateUser extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private JPanel panel;
	private JLabel idLabel;
	private JTextField idText;
	private JLabel typeLabel;
	private JComboBox<Integer> typeText;
	private JLabel institureLabel;
	private JComboBox<String> institureText;
	private JLabel gradeLabel;
	private JComboBox<String> gradeText;
	private JLabel classLabel;
	private JComboBox<String> classText;
	private JButton backButton;
	private JButton updateButton;
	UserServiceImpl impl = new UserServiceImpl();
	User user = new User();

	public UpdateUser(int user_id) {
		this.user_id = user_id;
		init();
	}

	public UpdateUser() {
		super();
	}

	private void init() {
		setTitle("�޸��û���Ϣ����");
		setBounds(500, 30, 500, 400);
		panel = new JPanel(new GridLayout(6, 2, 5, 5));
		user = impl.selectById(user_id);
		if (user.getUser_id() == 0) {
			JOptionPane.showMessageDialog(UpdateUser.this, "û�д��û���", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		idLabel = new JLabel("�û����");
		idText = new JTextField(String.valueOf(user.getUser_id()));
		//���ò������޸�ѧ�����
		idText.setEditable(false);
		typeLabel = new JLabel("�û����");
		Integer[] types = new Integer[]{1,0};
		typeText = new JComboBox<>(types);
		//Ϊ�����б�����Ĭ��ֵ
		typeText.setSelectedItem(user.getUser_type());
		institureLabel = new JLabel("ѧ��ѧԺ");
		String[] institure = new String[]{"���ѧԺ","�����ѧԺ","��ѧԺ","�����Ƽ�ѧԺ"};
		institureText = new JComboBox<>(institure);
		institureText.setSelectedItem(user.getUser_institure());
		gradeLabel = new JLabel("ѧ���꼶");
		String[] grade = new String[]{"��һ","���","����","����"};
		gradeText = new JComboBox<>(grade);
		gradeText.setSelectedItem(user.getUser_grade());
		classLabel = new JLabel("ѧ���༶");
		String[] cls = new String[]{"һ��","����","����"};
		classText = new JComboBox<>(cls);
		classText.setSelectedItem(user.getUser_class());
		backButton = new JButton("����");
		updateButton = new JButton("�޸�");
		panel.add(idLabel);
		panel.add(idText);
		panel.add(typeLabel);
		panel.add(typeText);
		panel.add(institureLabel);
		panel.add(institureText);
		panel.add(gradeLabel);
		panel.add(gradeText);
		panel.add(classLabel);
		panel.add(classText);
		panel.add(backButton);
		panel.add(updateButton);
		panel.setBackground(Color.red);
		setContentPane(panel);
		myEvent();
	}
	
	public void myEvent() {
		//���ذ�ť
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		//�޸İ�ť
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setUser_class(classText.getItemAt(classText.getSelectedIndex()));
				user.setUser_grade(gradeText.getItemAt(gradeText.getSelectedIndex()));
				user.setUser_institure(institureText.getItemAt(institureText.getSelectedIndex()));
				user.setUser_type(typeText.getItemAt(typeText.getSelectedIndex()));
				int n = impl.updateById(user_id, user);
				if (n != -1) {
					JOptionPane.showMessageDialog(UpdateUser.this, "�޸ĳɹ���", null, JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(UpdateUser.this, "�޸�ʧ�ܣ�", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
