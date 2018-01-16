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
		setTitle("修改用户信息界面");
		setBounds(500, 30, 500, 400);
		panel = new JPanel(new GridLayout(6, 2, 5, 5));
		user = impl.selectById(user_id);
		if (user.getUser_id() == 0) {
			JOptionPane.showMessageDialog(UpdateUser.this, "没有此用户！", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		idLabel = new JLabel("用户编号");
		idText = new JTextField(String.valueOf(user.getUser_id()));
		//设置不允许修改学生编号
		idText.setEditable(false);
		typeLabel = new JLabel("用户身份");
		Integer[] types = new Integer[]{1,0};
		typeText = new JComboBox<>(types);
		//为下拉列表设置默认值
		typeText.setSelectedItem(user.getUser_type());
		institureLabel = new JLabel("学生学院");
		String[] institure = new String[]{"软件学院","计算机学院","理学院","国防科技学院"};
		institureText = new JComboBox<>(institure);
		institureText.setSelectedItem(user.getUser_institure());
		gradeLabel = new JLabel("学生年级");
		String[] grade = new String[]{"大一","大二","大三","大四"};
		gradeText = new JComboBox<>(grade);
		gradeText.setSelectedItem(user.getUser_grade());
		classLabel = new JLabel("学生班级");
		String[] cls = new String[]{"一班","二班","三班"};
		classText = new JComboBox<>(cls);
		classText.setSelectedItem(user.getUser_class());
		backButton = new JButton("返回");
		updateButton = new JButton("修改");
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
				user.setUser_class(classText.getItemAt(classText.getSelectedIndex()));
				user.setUser_grade(gradeText.getItemAt(gradeText.getSelectedIndex()));
				user.setUser_institure(institureText.getItemAt(institureText.getSelectedIndex()));
				user.setUser_type(typeText.getItemAt(typeText.getSelectedIndex()));
				int n = impl.updateById(user_id, user);
				if (n != -1) {
					JOptionPane.showMessageDialog(UpdateUser.this, "修改成功！", null, JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(UpdateUser.this, "修改失败！", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
