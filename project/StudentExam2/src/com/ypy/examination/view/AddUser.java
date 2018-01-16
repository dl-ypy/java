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
		setTitle("添加用户");
		setBounds(500, 30, 500, 500);
		panel = new JPanel(new GridLayout(8, 2, 5, 5));
		nameLabel = new JLabel("学生姓名：");
		nameText = new JTextField();
		ageLabel = new JLabel("学生年龄：");
		ageText = new JTextField();
		sexLabel = new JLabel("学生性别：");
		String[] sex = new String[]{"男","女"};
		sexText = new JComboBox<>(sex);
		typeLabel = new JLabel("学生身份");
		Integer[] types = new Integer[]{1,0};
		typeText = new JComboBox<>(types);
		typeText.setSelectedItem(0);
		institureLabel = new JLabel("学生学院：");
		String[] institure = new String[]{"软件学院","计算机学院","理学院","国防科技学院"};
		institureText = new JComboBox<>(institure);
		institureText.setSelectedItem("软件学院");
		gradeLabel = new JLabel("学生年级：");
		String[] grade = new String[]{"大一","大二","大三","大四"};
		gradeText = new JComboBox<>(grade);
		gradeText.setSelectedItem("大一");
		classLabel = new JLabel("学生班级：");
		String[] cls = new String[]{"一班","二班","三班"};
		classText = new JComboBox<>(cls);
		classText.setSelectedItem("一班");
		backButton = new JButton("返回");
		addButton = new JButton("添加");
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
		//返回按钮
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		//添加按钮
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
							JOptionPane.showMessageDialog(AddUser.this, "添加成功！", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(AddUser.this, "添加失败！", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(AddUser.this, "年龄格式错误！", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(AddUser.this, "信息不完整！", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

}
