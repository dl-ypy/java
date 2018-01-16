package com.ypy.www.exam.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
/**
 * ��¼���������
 * @author ypy
 */
public class Main extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JPanel contentPane_2;
	private JPanel contentPane_3;
	private JLabel label;//����ʱ���
	private JScrollPane scroll;//������
	private JTextArea textArea;//�ı���
	private int time;//����ʱ��
	private int topicId;//���
	private String topic;//��Ŀ
	private String userAnswer;//�û���
	private String correctAnswer;//��ȷ��
	private JRadioButton jrbA;//ѡ���
	private JRadioButton jrbB;//ѡ���
	private JRadioButton jrbC;//ѡ���
	private JRadioButton jrbD;//ѡ���
	private JButton button;//��һ�ⰴť
	private JButton button_1;//�ύ��ť
	private Properties pro;
	private Set<String> proSet;//�����ļ��еļ���
	private Map<Integer, String> userAnswerMap;//�û�������Ŀ�ļ���
	private Map<Integer, String> correctAnswerMap;//��ȷ�𰸵ļ���
	private int score;//����
	private boolean answerState;//�ж��ܷ����
	private String studentId;

	public Main(String studentId) {
		this.studentId = studentId;
		pro = new Properties();
		userAnswerMap = new HashMap<Integer, String>();
		correctAnswerMap = new HashMap<Integer, String>();
		score = 0;
		answerState = true;
		time = 60;
		init();
	}
	
	/**
	 * ��ʼ������
	 */
	public void init() {
		ImageIcon backgroundImage = new ImageIcon("image/background.jpg");
		JLabel Backgroundlabel = new JLabel(backgroundImage);
		//���ñ���ͼƬ�Ĵ�С
		Backgroundlabel.setBounds(0, 0, 850, 500);
		
		setTitle("\u5B66\u751F\u8003\u8BD5\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		contentPane.add(Backgroundlabel);
		//����
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		
		contentPane_2 = new JPanel();
		//����ͼ��͵���ʱ����   ��   ��Ŀ
		contentPane_2.setLayout(new GridLayout(2, 1, 10, 10));
		
		contentPane_3 = new JPanel();
		//�����տؼ��͵���ʱ
		contentPane_3.setLayout(new GridLayout(1, 2, 500, 10));
		
		JLabel label_1 = new JLabel("");
		contentPane_3.add(label_1);
		
		//����ʱ
		label = new JLabel("ʱ�仹ʣ��" + time);
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("�����п�", Font.BOLD, 20));
		contentPane_3.add(label);
		
		contentPane_2.add(contentPane_3);

		//��Ŀ
		textArea = new JTextArea();
		textArea.setFont(new Font("�����п�", Font.BOLD, 15));
		//������
		scroll = new JScrollPane(textArea); 
		//����ˮƽ�ʹ�ֱ�������Զ���ʾ
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//��ʾ��Ŀ
		try {
			showTopic();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//����������ӹ�������Ͳ���Ҫ����ı�����
		contentPane_2.add(scroll);
		textArea.setEditable(false);

		contentPane.add(contentPane_2);
		
		contentPane_1 = new JPanel();
		//����ѡ��Ͱ�ť
		contentPane_1.setLayout(new GridLayout(3, 2, 730, 40));
		contentPane.add(contentPane_1);
		
		//��ӵ�ѡ��
		addJRadioButton();
		
		//������JPanel����Ϊ͸����
		contentPane.setOpaque(false);
		contentPane_1.setOpaque(false);
		contentPane_2.setOpaque(false);
		contentPane_3.setOpaque(false);
		//��ͼƬ������ײ�
		getLayeredPane().add(Backgroundlabel, new Integer(Integer.MIN_VALUE));
		
		Icon previous = new ImageIcon("image/previous.png");
		button = new JButton(previous);
		contentPane_1.add(button);
		/* ��һ�ⰴť�¼�����  
		 * 
		 * �ж��Ƿ��������
		 * �ж��Ƿ��ǵ�һ��
		 * ����ǣ������û�
		 * ������ǣ���ż�1,������������
		 */
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					if (topicId == 1) {
						JOptionPane.showMessageDialog(Main.this, "�����Ѿ��ǵ�һ�⣡", null, JOptionPane.WARNING_MESSAGE);
					} else {
						topicId = topicId - 1;
						updateElement();
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Main.this, "����ʱ�䵽�����˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Main.this, "��Ŀ�Ѵ��꣬���˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		Icon next = new ImageIcon("image/next.png");
		button_1 = new JButton(next);
		contentPane_1.add(button_1);
		/* �ύ��ť�¼�����
		 * 
		 * �ж��Ƿ��������
		 * �ж��Ƿ�ѡ���˴�
		 * �ж��Ƿ������һ��
		 */
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					proSet = pro.stringPropertyNames();
					//�ж��Ƿ�ѡ���
					if (jrbA.isSelected() || jrbB.isSelected() || jrbC.isSelected() || jrbD.isSelected()) {
						//�ж��Ƿ������һ��
						if (proSet.size() == topicId) {
							answerState = false;
							scoreOperator();
							try {
								recordExamInfo();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(Main.this, "��Ŀ�Ѵ��꣡", null, JOptionPane.WARNING_MESSAGE);
							JOptionPane.showMessageDialog(Main.this, "�����"+(score/5)+"���⣬�÷�Ϊ��"+score+"�֣�", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							topicId = topicId + 1;
							updateElement();
						}
					} else {
						JOptionPane.showMessageDialog(Main.this, "����û��ѡ��𰸣���ѡ��", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Main.this, "����ʱ�䵽�����˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Main.this, "��Ŀ�Ѵ��꣬���˳�����ϵͳ��", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
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
				//��ɾ����������������
				contentPane_3.remove(label);
				label = new JLabel("ʱ�仹ʣ��" + time);
				label.setForeground(Color.ORANGE);
				label.setFont(new Font("�����п�", Font.BOLD, 20));
				contentPane_3.add(label);
				setVisible(true);//������
				if (time == 0) {
					answerState = false;
					JOptionPane.showMessageDialog(this, "����ʱ�䵽��", null, JOptionPane.WARNING_MESSAGE);
					scoreOperator();
					JOptionPane.showMessageDialog(this, "�����"+(score/5)+"���⣬�÷�Ϊ��"+score+"�֣�", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	/**
	 * ��ʾ��Ŀ
	 * @throws IOException
	 */
	public void showTopic() throws IOException {
		FileInputStream f = new FileInputStream(new File("topic.properties"));
		pro.load(f);
		String[] topics = pro.getProperty("topic1").split(",,");
		topic = topics[0].substring(topics[0].indexOf("=")+1);
		correctAnswer = topics[1].substring(topics[1].indexOf("=")+1, topics[1].length()-1);
		if (topic == null) {
			JOptionPane.showMessageDialog(this, "��ĿΪ�գ�");
		}
		topicId = 1;
		textArea.setText("��Ŀ:\n" + topic);
	}
	
	/**
	 * ��ӵ�ѡ��ť
	 */
	public void addJRadioButton() {
		//���뽫��ѡ��ť���ŵ�һ����ť���У�����ʵ��ֻѡһ���Ĺ���
		ButtonGroup buttonGroup = new ButtonGroup();
		jrbA = new JRadioButton("A");
		//������ѡ��ť�¼�
		jrbA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbA.getText();
				//ѡ��󽫴𰸱�����map������
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		buttonGroup.add(jrbA);
		contentPane_1.add(jrbA);
		
		jrbB = new JRadioButton("B");
		jrbB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbB.getText();
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		buttonGroup.add(jrbB);
		contentPane_1.add(jrbB);
		
		jrbC = new JRadioButton("C");
		jrbC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbC.getText();
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		buttonGroup.add(jrbC);
		contentPane_1.add(jrbC);
		
		jrbD = new JRadioButton("D");
		jrbD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbD.getText();
				saveCorrectAnswer();
				saveUserAnswer();
			}
		});
		buttonGroup.add(jrbD);
		contentPane_1.add(jrbD);
	}
	
	/**
	 * �����ť��������
	 */
	public void updateElement() {
		String[] topics = pro.getProperty("topic"+topicId).split(",,");
		topic = topics[0].substring(topics[0].indexOf("=")+1);
		correctAnswer = topics[1].substring(topics[1].indexOf("=")+1, topics[1].length()-1);
		contentPane_2.remove(scroll);
		textArea = new JTextArea();
		textArea.setFont(new Font("�����п�", Font.BOLD, 15));
		textArea.setText("��Ŀ:\n" + topic);
		scroll = new JScrollPane(textArea);
		contentPane_2.add(scroll);
		contentPane_1.remove(jrbA);
		contentPane_1.remove(jrbB);
		contentPane_1.remove(jrbC);
		contentPane_1.remove(jrbD);
		contentPane_1.remove(button);
		contentPane_1.remove(button_1);
		addJRadioButton();
		contentPane_1.add(button);
		contentPane_1.add(button_1);
		setVisible(true);
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
			if (correctAnswerValue.equals(userAnswerValue)) {
				score += 5;
			}
		}
	}

	/**
	 * ��¼������Ϣ
	 * @throws IOException 
	 */
	public void recordExamInfo() throws IOException {
		FileOutputStream f = new FileOutputStream(new File("score.properties"), true);
		Properties proScore = new Properties();
		proScore.setProperty("score"+studentId, "[studentId="+studentId+",score="+score+"]");
		proScore.store(f, null);
	}
}
