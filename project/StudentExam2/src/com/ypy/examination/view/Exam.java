package com.ypy.examination.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ypy.examination.model.Examination;
import com.ypy.examination.model.Score;
import com.ypy.examination.service.impl.ExaminationServiceImpl;
import com.ypy.examination.service.impl.ScoreServiceImpl;

/**
 * 考试
 * @author 
 */
public class Exam extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JLabel timeLabel;//倒计时组件
	private JScrollPane scroll;//滚动条
	private JTextArea textArea;//文本框
	private int time;//考试时间
	private int topicId;//题号
	private String userAnswer;//用户答案
	private String correctAnswer;//正确答案
	private JRadioButton jrbA;//选项框
	private JRadioButton jrbB;//选项框
	private JRadioButton jrbC;//选项框
	private JRadioButton jrbD;//选项框
	private JButton previousButton;//上一题按钮
	private JButton nextButton;//提交按钮
	private JButton[] buttons;
	private double score;//分数
	private Map<Integer, String> userAnswerMap;//用户所做题目的集合
	private Map<Integer, String> correctAnswerMap;//正确答案的集合
	private boolean answerState;//判断能否答题,时间到或者答完题时设为false
	private ExaminationServiceImpl impl = new ExaminationServiceImpl();
	private Examination examination;
	private List<Examination> list;
	private ActionListener action;
	
	public Exam(int user_id) {
		this.user_id = user_id;
		init();
	}
	
	public void init() {
		answerState = true;
		score = 0;
		userAnswerMap = new HashMap<Integer, String>();
		correctAnswerMap = new HashMap<Integer, String>();
		setTitle("考试界面");
		setBounds(100, 100, 850, 500);
		//查询到所有题目
		list = impl.selectAll();
		topicId = 1;
		time = 20;
		panel = new JPanel(new BorderLayout());
		panel2 = new JPanel(new GridLayout(4, 1, 5, 5));
		panel3 = new JPanel(new GridLayout(1, 2, 5, 5));
		panel4 = new JPanel(new GridLayout(10,5));
		//updateElement();
		timeLabel = new JLabel("剩余时间：" + time+"时间不多了，大侠加油！");
		timeLabel.setForeground(Color.green);
		timeLabel.setFont(new Font("宋体", Font.BOLD, 20));
		textArea = new JTextArea();
		examination = list.get(topicId-1);
		textArea.setText(examination.getTp_title());
		scroll = new JScrollPane(textArea);
		//实现单选
		ButtonGroup buttonGroup = new ButtonGroup();
		jrbA = new JRadioButton("A"+examination.getTp_choicea());
		jrbB = new JRadioButton("B"+examination.getTp_choiceb());
		jrbC = new JRadioButton("C"+examination.getTp_choicec());
		jrbD = new JRadioButton("D"+examination.getTp_choiced());
		buttonGroup.add(jrbA);
		buttonGroup.add(jrbB);
		buttonGroup.add(jrbC);
		buttonGroup.add(jrbD);
		previousButton = new JButton("上一题");
		nextButton = new JButton("下一题");
		myEvent();
		buttons = new JButton[list.size()];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(String.valueOf(i+1));
			buttons[i].addActionListener(action);
			panel4.add(buttons[i]);
		}
		panel3.add(previousButton);
		panel3.add(nextButton);
		panel2.add(jrbA);
		panel2.add(jrbB);
		panel2.add(jrbC);
		panel2.add(jrbD);
		panel.add("North", timeLabel);
		panel.add("Center", scroll);
		panel.add("East", panel2);
		panel.add("South", panel3);
		panel.add("West", panel4);
		panel.setBackground(Color.red);
		setContentPane(panel);
	}
	
	public void myEvent() {
		//上一题按钮
		previousButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					if (topicId == 1) {
						JOptionPane.showMessageDialog(Exam.this, "本题已经是第一题！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						topicId = topicId - 1;
						updateElement();
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Exam.this, "答题时间到，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Exam.this, "题目已答完，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		//下一题按钮
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					//判断是否选择答案
					if (jrbA.isSelected() || jrbB.isSelected() || jrbC.isSelected() || jrbD.isSelected()) {
						//判断是否是最后一题
						if (list.size() == topicId) {
							answerState = false;
							scoreOperator();
							recordExamInfo();
							JOptionPane.showMessageDialog(Exam.this, "题目已答完！", null, JOptionPane.WARNING_MESSAGE);
							JOptionPane.showMessageDialog(Exam.this, "得分为："+score+"分！", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							topicId = topicId + 1;
							updateElement();
						}
					} else {
						JOptionPane.showMessageDialog(Exam.this, "您还没有选择答案！请选择！", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Exam.this, "答题时间到，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Exam.this, "题目已答完，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		//监听单选按钮事件
		jrbA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbA.getText().substring(0, 1);
				correctAnswer = examination.getTp_answer();
				//选完后将答案保存在map集合中
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		jrbB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbB.getText().substring(0, 1);
				correctAnswer = examination.getTp_answer();
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		jrbC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbC.getText().substring(0, 1);
				correctAnswer = examination.getTp_answer();
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		jrbD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbD.getText().substring(0, 1);
				correctAnswer = examination.getTp_answer();
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		//控件数组添加监听事件
		action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				topicId = Integer.parseInt(((JButton)e.getSource()).getText());
				updateElement();
			}
		};
	}
	
	/**
	 * 更新组件
	 */
	public void updateElement() {
		panel.remove(scroll);
		textArea = new JTextArea();
		examination = list.get(topicId-1);
		textArea.setText(examination.getTp_title());
		scroll = new JScrollPane(textArea);
		//实现单选
		ButtonGroup buttonGroup = new ButtonGroup();
		jrbA = new JRadioButton("A"+examination.getTp_choicea());
		jrbB = new JRadioButton("B"+examination.getTp_choiceb());
		jrbC = new JRadioButton("C"+examination.getTp_choicec());
		jrbD = new JRadioButton("D"+examination.getTp_choiced());
		buttonGroup.add(jrbA);
		buttonGroup.add(jrbB);
		buttonGroup.add(jrbC);
		buttonGroup.add(jrbD);
		previousButton = new JButton("上一题");
		nextButton = new JButton("下一题");
		panel4.removeAll();
		myEvent();
		buttons = new JButton[list.size()];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(String.valueOf(i+1));
			buttons[i].addActionListener(action);
			panel4.add(buttons[i]);
		}
		panel3.removeAll();
		panel2.removeAll();
		panel2.add(jrbA);
		panel2.add(jrbB);
		panel2.add(jrbC);
		panel2.add(jrbD);
		panel3.add(previousButton);
		panel3.add(nextButton);
		panel.add("Center", scroll);
		panel.add("East", panel2);
		panel.add("South", panel3);
		panel.add("West", panel4);
		setContentPane(panel);
		setVisible(true);
	}
	
	/**
	 * 计算分数
	 */
	public void scoreOperator() {
		Set<Entry<Integer, String>> correctAnswerSet = correctAnswerMap.entrySet();
		Set<Entry<Integer, String>> userAnswerSet = userAnswerMap.entrySet();
		Iterator<Entry<Integer, String>> correctAnswerIt = correctAnswerSet.iterator();
		Iterator<Entry<Integer, String>> userAnswerIt = userAnswerSet.iterator();
		while(correctAnswerIt.hasNext()) {
			Entry<Integer, String> correctAnswerEntry = correctAnswerIt.next();
			Entry<Integer, String> userAnswerEntry = userAnswerIt.next();
			String correctAnswerValue = correctAnswerEntry.getValue();
			String userAnswerValue = userAnswerEntry.getValue();
			//判断答案是否正确
			if (correctAnswerValue.equals(userAnswerValue) || correctAnswerValue.equals(userAnswerValue.toLowerCase())) {
				int id = userAnswerEntry.getKey();
				score += list.get(id-1).getTp_score();
			}
		}
	}
	
	/**
	 * 保存正确答案
	 */
	public void saveCorrectAnswer() {
		//将 题目-正确答案 的键值对存储到map集合中
		correctAnswerMap.put(topicId, correctAnswer);
	}
	
	/**
	 * 保存用户答案
	 */
	public void saveUserAnswer() {
		Set<Integer> answerIdSet = userAnswerMap.keySet();
		Iterator<Integer> it = answerIdSet.iterator();
		//判断之前存储过此题，就将其删除
		while (it.hasNext()) {
			int answerIdKey = it.next();
			if (answerIdKey == topicId) {
				it.remove();
			}
		}
		//将 题目-用户答案 的键值对存储到map集合中
		userAnswerMap.put(topicId, userAnswer);
	}
	
	/**
	 * 记录成绩
	 */
	public void recordExamInfo() {
		Score myScore = new Score(user_id, "java", 100, 100, score, score+200);
		ScoreServiceImpl scoreServiceImpl = new ScoreServiceImpl();
		scoreServiceImpl.add(myScore);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (answerState) {
			time--;
			panel.remove(timeLabel);
			timeLabel = new JLabel("剩余时间：" + time+"时间不多了，大侠加油！");
			timeLabel.setForeground(Color.green);
			timeLabel.setFont(new Font("宋体", Font.BOLD, 20));
			panel.add("North",timeLabel);
			setVisible(true);
				if (time == 0) {
					answerState = false;
					scoreOperator();
					recordExamInfo();
					JOptionPane.showMessageDialog(this, "答题时间到！", null, JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(this, "得分为："+score+"分！", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

}
