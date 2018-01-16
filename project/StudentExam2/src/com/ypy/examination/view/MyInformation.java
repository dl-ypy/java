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

public class MyInformation extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private JPanel panel;
	private JLabel idLabel;
	private JTextField idText;
	private JLabel accountLabel;
	private JTextField accountText;
	private JLabel pwdLabel;
	private JTextField pwdText;
	private JLabel nameLabel;
	private JTextField nameText;
	private JLabel ageLabel;
	private JTextField ageText;
	private JLabel sexLabel;
	private JTextField idCardText;
	private JLabel idCardLabel;
	private JTextField phoneText;
	private JLabel phoneLabel;
	private JComboBox<String> sexText;
	private JLabel institureLabel;
	private JTextField institureText;
	private JLabel gradeLabel;
	private JTextField gradeText;
	private JLabel classLabel;
	private JTextField classText;
	private JButton backButton;
	private JButton updateButton;
	UserServiceImpl impl = new UserServiceImpl();
	User user = new User();
	
	public MyInformation(int user_id) {
		this.user_id = user_id;
		init();
	}

	public void init() {
		setTitle("�ҵ���Ϣ");
		setBounds(500, 30, 750, 500);
		panel = new JPanel(new GridLayout(13, 2, 5, 5));
		user = impl.selectById(user_id);
		if (user.getUser_id() == 0) {
			JOptionPane.showMessageDialog(MyInformation.this, "û�д��û���", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		idLabel = new JLabel("�û����:");
		idText = new JTextField(String.valueOf(user.getUser_id()));
		idText.setEditable(false);
		accountLabel = new JLabel("ѧ���˻�:");
		accountText = new JTextField(user.getUser_account());
		pwdLabel = new JLabel("�˻�����:");
		pwdText = new JTextField(user.getUser_password());
		nameLabel = new JLabel("ѧ������:");
		nameText = new JTextField(user.getUser_name());
		ageLabel = new JLabel("ѧ������:");
		ageText = new JTextField(String.valueOf(user.getUser_age()));
		sexLabel = new JLabel("ѧ���Ա�:");
		String[] str = new String[]{"��","Ů"};
		sexText = new JComboBox<>(str);
		sexText.setSelectedItem(user.getUser_sex());
		idCardLabel = new JLabel("���֤:");
		idCardText = new JTextField(user.getUser_idcard());
		phoneLabel = new JLabel("�绰����:");
		phoneText = new JTextField(String.valueOf(user.getUser_phone()));
		institureLabel = new JLabel("ѧ��ѧԺ:");
		institureText = new JTextField(user.getUser_institure());
		institureText.setEditable(false);
		gradeLabel = new JLabel("ѧ���꼶:");
		gradeText = new JTextField(user.getUser_grade());
		gradeText.setEditable(false);
		classLabel = new JLabel("ѧ���༶:");
		classText = new JTextField(user.getUser_class());
		classText.setEditable(false);
		backButton = new JButton("����");
		updateButton = new JButton("�޸�");
		panel.add(idLabel);
		panel.add(idText);
		panel.add(accountLabel);
		panel.add(accountText);
		panel.add(pwdLabel);
		panel.add(pwdText);
		panel.add(nameLabel);
		panel.add(nameText);
		panel.add(ageLabel);
		panel.add(ageText);
		panel.add(sexLabel);
		panel.add(sexText);
		panel.add(idCardLabel);
		panel.add(idCardText);
		panel.add(phoneLabel);
		panel.add(phoneText);
		panel.add(institureLabel);
		panel.add(institureText);
		panel.add(gradeLabel);
		panel.add(gradeText);
		panel.add(classLabel);
		panel.add(classText);
		panel.add(backButton);
		panel.add(updateButton);
		setContentPane(panel);
		panel.setBackground(Color.red);
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
				if (accountText.getText().equals("") || pwdText.getText().equals("") || nameText.getText().equals("") || ageText.getText().equals("") || idCardText.getText().equals("") || phoneText.getText().equals("")) {
					JOptionPane.showMessageDialog(MyInformation.this, "��Ϣ��д����ȫ��", null, JOptionPane.WARNING_MESSAGE);
				} else {
					if (!RuleUtil.userAccountRepeat(accountText.getText(), user_id)) {
						if (!RuleUtil.passwordRule(pwdText.getText())) {
							if (RuleUtil.ageRule(ageText.getText())) {
								if (RuleUtil.idCardIsCorrect(idCardText.getText())) {
									if (RuleUtil.phoneIsCorrect(phoneText.getText())) {
										user.setUser_account(accountText.getText());
										user.setUser_age(Integer.parseInt(ageText.getText()));
										user.setUser_idcard(idCardText.getText());
										user.setUser_name(nameText.getText());
										user.setUser_password(pwdText.getText());
										user.setUser_phone(Long.parseLong(phoneText.getText()));
										user.setUser_sex(sexText.getItemAt(sexText.getSelectedIndex()));
										int n = impl.updateById(user_id, user);
										if (n != -1) {
											JOptionPane.showMessageDialog(MyInformation.this, "�޸ĳɹ���", null, JOptionPane.INFORMATION_MESSAGE);
										} else {
											JOptionPane.showMessageDialog(MyInformation.this, "�޸�ʧ�ܣ�", null, JOptionPane.WARNING_MESSAGE);
										}
									} else {
										JOptionPane.showMessageDialog(MyInformation.this, "�绰�����ʽ����", null, JOptionPane.WARNING_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(MyInformation.this, "���֤�����ʽ����", null, JOptionPane.WARNING_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(MyInformation.this, "�����ʽ���ԣ�", null, JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(MyInformation.this, "�����ٶ�д�������£�", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(MyInformation.this, "���˻����ѱ�ʹ�ã�", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
}
