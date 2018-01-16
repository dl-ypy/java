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
		setTitle("我的信息");
		setBounds(500, 30, 750, 500);
		panel = new JPanel(new GridLayout(13, 2, 5, 5));
		user = impl.selectById(user_id);
		if (user.getUser_id() == 0) {
			JOptionPane.showMessageDialog(MyInformation.this, "没有此用户！", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		idLabel = new JLabel("用户编号:");
		idText = new JTextField(String.valueOf(user.getUser_id()));
		idText.setEditable(false);
		accountLabel = new JLabel("学生账户:");
		accountText = new JTextField(user.getUser_account());
		pwdLabel = new JLabel("账户密码:");
		pwdText = new JTextField(user.getUser_password());
		nameLabel = new JLabel("学生姓名:");
		nameText = new JTextField(user.getUser_name());
		ageLabel = new JLabel("学生年龄:");
		ageText = new JTextField(String.valueOf(user.getUser_age()));
		sexLabel = new JLabel("学生性别:");
		String[] str = new String[]{"男","女"};
		sexText = new JComboBox<>(str);
		sexText.setSelectedItem(user.getUser_sex());
		idCardLabel = new JLabel("身份证:");
		idCardText = new JTextField(user.getUser_idcard());
		phoneLabel = new JLabel("电话号码:");
		phoneText = new JTextField(String.valueOf(user.getUser_phone()));
		institureLabel = new JLabel("学生学院:");
		institureText = new JTextField(user.getUser_institure());
		institureText.setEditable(false);
		gradeLabel = new JLabel("学生年级:");
		gradeText = new JTextField(user.getUser_grade());
		gradeText.setEditable(false);
		classLabel = new JLabel("学生班级:");
		classText = new JTextField(user.getUser_class());
		classText.setEditable(false);
		backButton = new JButton("返回");
		updateButton = new JButton("修改");
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
		//返回按钮
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		//修改按钮
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (accountText.getText().equals("") || pwdText.getText().equals("") || nameText.getText().equals("") || ageText.getText().equals("") || idCardText.getText().equals("") || phoneText.getText().equals("")) {
					JOptionPane.showMessageDialog(MyInformation.this, "信息填写不完全！", null, JOptionPane.WARNING_MESSAGE);
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
											JOptionPane.showMessageDialog(MyInformation.this, "修改成功！", null, JOptionPane.INFORMATION_MESSAGE);
										} else {
											JOptionPane.showMessageDialog(MyInformation.this, "修改失败！", null, JOptionPane.WARNING_MESSAGE);
										}
									} else {
										JOptionPane.showMessageDialog(MyInformation.this, "电话号码格式错误！", null, JOptionPane.WARNING_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(MyInformation.this, "身份证号码格式错误！", null, JOptionPane.WARNING_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(MyInformation.this, "年龄格式不对！", null, JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(MyInformation.this, "密码再多写几个数呗！", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(MyInformation.this, "该账户名已被使用！", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
}
