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
import com.ypy.examination.util.RuleUtil;

public class AddUser extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel typeLabel;
	private JComboBox<Integer> typeText;
	private JLabel institureLabel;
	private JComboBox<String> institureText;
	private JLabel gradeLabel;
	private JComboBox<String> gradeText;
	private JLabel classLabel;
	private JComboBox<String> classText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel ageLabel;
	private JTextField ageText;
	private JLabel sexLabel;
	private JComboBox<String> sexText;
	private JButton backButton;
	private JButton addButton;
	
	public AddUser() {
		init();
	}

	public void init() {
		setTitle("����û�");
		setBounds(500, 30, 500, 500);
		panel = new JPanel(new GridLayout(8, 2, 5, 5));
		nameLabel = new JLabel("ѧ��������");
		nameText = new JTextField();
		ageLabel = new JLabel("ѧ�����䣺");
		ageText = new JTextField();
		sexLabel = new JLabel("ѧ���Ա�");
		String[] sex = new String[]{"��","Ů"};
		sexText = new JComboBox<>(sex);
		typeLabel = new JLabel("ѧ�����");
		Integer[] types = new Integer[]{1,0};
		typeText = new JComboBox<>(types);
		typeText.setSelectedItem(0);
		institureLabel = new JLabel("ѧ��ѧԺ��");
		String[] institure = new String[]{"���ѧԺ","�����ѧԺ","��ѧԺ","�����Ƽ�ѧԺ"};
		institureText = new JComboBox<>(institure);
		institureText.setSelectedItem("���ѧԺ");
		gradeLabel = new JLabel("ѧ���꼶��");
		String[] grade = new String[]{"��һ","���","����","����"};
		gradeText = new JComboBox<>(grade);
		gradeText.setSelectedItem("��һ");
		classLabel = new JLabel("ѧ���༶��");
		String[] cls = new String[]{"һ��","����","����"};
		classText = new JComboBox<>(cls);
		classText.setSelectedItem("һ��");
		backButton = new JButton("����");
		addButton = new JButton("���");
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(ageLabel);
		panel.add(ageText);
		panel.add(sexLabel);
		panel.add(sexText);
		panel.add(typeLabel);
		panel.add(typeText);
		panel.add(institureLabel);
		panel.add(institureText);
		panel.add(gradeLabel);
		panel.add(gradeText);
		panel.add(classLabel);
		panel.add(classText);
		panel.add(backButton);
		panel.add(addButton);
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
		
		//��Ӱ�ť
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserServiceImpl impl = new UserServiceImpl();
				User user = new User();
				if (!nameText.getText().equals("") && !ageText.getText().equals("")) {
					if (RuleUtil.ageRule(ageText.getText())) {
						user.setUser_name(nameText.getText());
						user.setUser_age(Integer.parseInt(ageText.getText()));
						user.setUser_sex(sexText.getItemAt(sexText.getSelectedIndex()));
						user.setUser_institure(institureText.getItemAt(institureText.getSelectedIndex()));
						user.setUser_grade(gradeText.getItemAt(gradeText.getSelectedIndex()));
						user.setUser_class(classText.getItemAt(classText.getSelectedIndex()));
						int n = impl.add(user);
						if (n != -1) {
							JOptionPane.showMessageDialog(AddUser.this, "��ӳɹ���", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(AddUser.this, "���ʧ�ܣ�", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(AddUser.this, "�����ʽ����", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(AddUser.this, "��Ϣ��������", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}
