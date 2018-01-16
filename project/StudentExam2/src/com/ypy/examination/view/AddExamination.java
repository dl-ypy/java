package com.ypy.examination.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.ypy.examination.model.Examination;
import com.ypy.examination.service.impl.ExaminationServiceImpl;
import com.ypy.examination.util.RuleUtil;

public class AddExamination extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private JPanel panel;
	private JLabel titleLabel;
	private JTextArea titleText;
	private JLabel choiceALabel;
	private JTextField choiceAText;
	private JLabel choiceBLabel;
	private JTextField choiceBText;
	private JLabel choiceCLabel;
	private JTextField choiceCText;
	private JLabel choiceDLabel;
	private JTextField choiceDText;
	private JLabel scoreLabel;
	private JTextField scoreText;
	private JLabel answerLabel;
	private JTextField answerText;
	private JButton backButton;
	private JButton addButton;
	
	public AddExamination(int user_id) {
		this.user_id = user_id;
		init();
	}

	public void init() {
		setTitle("添加试题");
		setBounds(500, 30, 500, 500);
		panel = new JPanel(new GridLayout(9, 2, 5, 5));
		titleLabel = new JLabel("试题题目：");
		titleText = new JTextArea();
		choiceALabel = new JLabel("选项A：");
		choiceAText = new JTextField();
		choiceBLabel = new JLabel("选项B：");
		choiceBText = new JTextField();
		choiceCLabel = new JLabel("选项C：");
		choiceCText = new JTextField();
		choiceDLabel = new JLabel("选项D：");
		choiceDText = new JTextField();
		scoreLabel = new JLabel("试题分数：");
		scoreText = new JTextField();
		answerLabel = new JLabel("试题答案：");
		answerText = new JTextField();
		backButton = new JButton("返回");
		addButton = new JButton("添加");
		panel.add(titleLabel);
		panel.add(titleText);
		panel.add(choiceALabel);
		panel.add(choiceAText);
		panel.add(choiceBLabel);
		panel.add(choiceBText);
		panel.add(choiceCLabel);
		panel.add(choiceCText);
		panel.add(choiceDLabel);
		panel.add(choiceDText);
		panel.add(scoreLabel);
		panel.add(scoreText);
		panel.add(answerLabel);
		panel.add(answerText);
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
						if (!answerText.getText().equals("") && !choiceAText.getText().equals("") && !choiceBText.getText().equals("") && !choiceCText.getText().equals("") && !choiceDText.getText().equals("") && !scoreText.getText().equals("") && !titleText.getText().equals("")) {
							if (RuleUtil.scoreRule(scoreText.getText())) {
								if (RuleUtil.answerRule(answerText.getText())) {
									ExaminationServiceImpl impl = new ExaminationServiceImpl();
									Examination examination = new Examination();
									examination.setTp_answer(answerText.getText());
									examination.setTp_choicea(choiceAText.getText());
									examination.setTp_choiceb(choiceBText.getText());
									examination.setTp_choicec(choiceCText.getText());
									examination.setTp_choiced(choiceDText.getText());
									examination.setTp_score(Double.parseDouble(scoreText.getText()));
									examination.setTp_title(titleText.getText());
									examination.setUser_id(user_id);
									int n = impl.add(examination);
									if (n != -1) {
										JOptionPane.showMessageDialog(AddExamination.this, "添加成功！", null, JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(AddExamination.this, "添加失败！", null, JOptionPane.WARNING_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(AddExamination.this, "答案应该为A、B、C、D或a、b、c、d！", null, JOptionPane.WARNING_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(AddExamination.this, "分数格式错误！", null, JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(AddExamination.this, "信息不完整！", null, JOptionPane.WARNING_MESSAGE);
						}
					}
				});
	}
}
