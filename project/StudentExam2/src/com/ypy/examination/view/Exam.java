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
 * ����
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
	private JLabel timeLabel;//����ʱ���
	private JScrollPane scroll;//������
	private JTextArea textArea;//�ı���
	private int time;//����ʱ��
	private int topicId;//���
	private String userAnswer;//�û���
	private String correctAnswer;//��ȷ��
	private JRadioButton jrbA;//ѡ���
	private JRadioButton jrbB;//ѡ���
	private JRadioButton jrbC;//ѡ���
	private JRadioButton jrbD;//ѡ���
	private JButton previousButton;//��һ�ⰴť
	private JButton nextButton;//�ύ��ť
	private JButton[] buttons;
	private double score;//����
	private Map<Integer, String> userAnswerMap;//�û�������Ŀ�ļ���
	private Map<Integer, String> correctAnswerMap;//��ȷ�𰸵ļ���
	private boolean answerState;//�ж��ܷ����,ʱ�䵽���ߴ�����ʱ��Ϊfalse
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
		setTitle("���Խ���");
		setBounds(100, 100, 850, 500);
		//��ѯ��������Ŀ
		list = impl.selectAll();
		topicId = 1;
		time = 20;
		panel = new JPanel(new BorderLayout());
		panel2 = new JPanel(new GridLayout(4, 1, 5, 5));
		panel3 = new JPanel(new GridLayout(1, 2, 5, 5));
		panel4 = new JPanel(new GridLayout(10,5));
		//updateElement();
		timeLabel = new JLabel("ʣ��ʱ�䣺" + time+"ʱ�䲻���ˣ��������ͣ�");
		timeLabel.setForeground(Color.green);
		timeLabel.setFont(new Font("����", Font.BOLD, 20));
		textArea = new JTextArea();
		examination = list.get(topicId-1);
		textArea.setText(examination.getTp_title());
		scroll = new JScrollPane(textArea);
		//ʵ�ֵ�ѡ
		ButtonGroup buttonGroup = new ButtonGroup();
		jrbA = new JRadioButton("A"+examination.getTp_choicea());
		jrbB = new JRadioButton("B"+examination.getTp_choiceb());
		jrbC = new JRadioButton("C"+examination.getTp_choicec());
		jrbD = new JRadioButton("D"+examination.getTp_choiced());
		buttonGroup.add(jrbA);
		buttonGroup.add(jrbB);
		buttonGroup.add(jrbC);
		buttonGroup.add(jrbD);
		previousButton = new JButton("��һ��");
		nextButton = new JButton("��һ��");
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
		//��һ�ⰴť
		previousButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					if (topicId == 1) {
						JOptionPane.showMessageDialog(Exam.this, "�����Ѿ��ǵ�һ�⣡", null, JOptionPane.WARNING_MESSAGE);
					} else {
						topicId = topicId - 1;
						updateElement();
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Exam.this, "����ʱ�䵽�����˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Exam.this, "��Ŀ�Ѵ��꣬���˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		//��һ�ⰴť
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					//�ж��Ƿ�ѡ���
					if (jrbA.isSelected() || jrbB.isSelected() || jrbC.isSelected() || jrbD.isSelected()) {
						//�ж��Ƿ������һ��
						if (list.size() == topicId) {
							answerState = false;
							scoreOperator();
							recordExamInfo();
							JOptionPane.showMessageDialog(Exam.this, "��Ŀ�Ѵ��꣡", null, JOptionPane.WARNING_MESSAGE);
							JOptionPane.showMessageDialog(Exam.this, "�÷�Ϊ��"+score+"�֣�", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							topicId = topicId + 1;
							updateElement();
						}
					} else {
						JOptionPane.showMessageDialog(Exam.this, "����û��ѡ��𰸣���ѡ��", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Exam.this, "����ʱ�䵽�����˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Exam.this, "��Ŀ�Ѵ��꣬���˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		//������ѡ��ť�¼�
		jrbA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbA.getText().substring(0, 1);
				correctAnswer = examination.getTp_answer();
				//ѡ��󽫴𰸱�����map������
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
		//�ؼ�������Ӽ����¼�
		action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				topicId = Integer.parseInt(((JButton)e.getSource()).getText());
				updateElement();
			}
		};
	}
	
	/**
	 * �������
	 */
	public void updateElement() {
		panel.remove(scroll);
		textArea = new JTextArea();
		examination = list.get(topicId-1);
		textArea.setText(examination.getTp_title());
		scroll = new JScrollPane(textArea);
		//ʵ�ֵ�ѡ
		ButtonGroup buttonGroup = new ButtonGroup();
		jrbA = new JRadioButton("A"+examination.getTp_choicea());
		jrbB = new JRadioButton("B"+examination.getTp_choiceb());
		jrbC = new JRadioButton("C"+examination.getTp_choicec());
		jrbD = new JRadioButton("D"+examination.getTp_choiced());
		buttonGroup.add(jrbA);
		buttonGroup.add(jrbB);
		buttonGroup.add(jrbC);
		buttonGroup.add(jrbD);
		previousButton = new JButton("��һ��");
		nextButton = new JButton("��һ��");
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
	 * �������
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
			//�жϴ��Ƿ���ȷ
			if (correctAnswerValue.equals(userAnswerValue) || correctAnswerValue.equals(userAnswerValue.toLowerCase())) {
				int id = userAnswerEntry.getKey();
				score += list.get(id-1).getTp_score();
			}
		}
	}
	
	/**
	 * ������ȷ��
	 */
	public void saveCorrectAnswer() {
		//�� ��Ŀ-��ȷ�� �ļ�ֵ�Դ洢��map������
		correctAnswerMap.put(topicId, correctAnswer);
	}
	
	/**
	 * �����û���
	 */
	public void saveUserAnswer() {
		Set<Integer> answerIdSet = userAnswerMap.keySet();
		Iterator<Integer> it = answerIdSet.iterator();
		//�ж�֮ǰ�洢�����⣬�ͽ���ɾ��
		while (it.hasNext()) {
			int answerIdKey = it.next();
			if (answerIdKey == topicId) {
				it.remove();
			}
		}
		//�� ��Ŀ-�û��� �ļ�ֵ�Դ洢��map������
		userAnswerMap.put(topicId, userAnswer);
	}
	
	/**
	 * ��¼�ɼ�
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
			timeLabel = new JLabel("ʣ��ʱ�䣺" + time+"ʱ�䲻���ˣ��������ͣ�");
			timeLabel.setForeground(Color.green);
			timeLabel.setFont(new Font("����", Font.BOLD, 20));
			panel.add("North",timeLabel);
			setVisible(true);
				if (time == 0) {
					answerState = false;
					scoreOperator();
					recordExamInfo();
					JOptionPane.showMessageDialog(this, "����ʱ�䵽��", null, JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(this, "�÷�Ϊ��"+score+"�֣�", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

}
