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
 * 登录后的主界面
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
	private JLabel label;//倒计时组件
	private JScrollPane scroll;//滚动条
	private JTextArea textArea;//文本框
	private int time;//考试时间
	private int topicId;//题号
	private String topic;//题目
	private String userAnswer;//用户答案
	private String correctAnswer;//正确答案
	private JRadioButton jrbA;//选项框
	private JRadioButton jrbB;//选项框
	private JRadioButton jrbC;//选项框
	private JRadioButton jrbD;//选项框
	private JButton button;//上一题按钮
	private JButton button_1;//提交按钮
	private Properties pro;
	private Set<String> proSet;//配置文件中的集合
	private Map<Integer, String> userAnswerMap;//用户所做题目的集合
	private Map<Integer, String> correctAnswerMap;//正确答案的集合
	private int score;//分数
	private boolean answerState;//判断能否答题
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
	 * 初始化界面
	 */
	public void init() {
		ImageIcon backgroundImage = new ImageIcon("image/background.jpg");
		JLabel Backgroundlabel = new JLabel(backgroundImage);
		//设置背景图片的大小
		Backgroundlabel.setBounds(0, 0, 850, 500);
		
		setTitle("\u5B66\u751F\u8003\u8BD5\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		contentPane.add(Backgroundlabel);
		//整体
		contentPane.setLayout(new GridLayout(2, 1, 10, 10));
		
		contentPane_2 = new JPanel();
		//包括图标和倒计时整体   和   题目
		contentPane_2.setLayout(new GridLayout(2, 1, 10, 10));
		
		contentPane_3 = new JPanel();
		//包括空控件和倒计时
		contentPane_3.setLayout(new GridLayout(1, 2, 500, 10));
		
		JLabel label_1 = new JLabel("");
		contentPane_3.add(label_1);
		
		//倒计时
		label = new JLabel("时间还剩：" + time);
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("华文行楷", Font.BOLD, 20));
		contentPane_3.add(label);
		
		contentPane_2.add(contentPane_3);

		//题目
		textArea = new JTextArea();
		textArea.setFont(new Font("华文行楷", Font.BOLD, 15));
		//滚动条
		scroll = new JScrollPane(textArea); 
		//设置水平和垂直滚动条自动显示
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//显示题目
		try {
			showTopic();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//往布局中添加滚动条后就不需要添加文本框了
		contentPane_2.add(scroll);
		textArea.setEditable(false);

		contentPane.add(contentPane_2);
		
		contentPane_1 = new JPanel();
		//包括选项和按钮
		contentPane_1.setLayout(new GridLayout(3, 2, 730, 40));
		contentPane.add(contentPane_1);
		
		//添加单选框
		addJRadioButton();
		
		//将所有JPanel都设为透明的
		contentPane.setOpaque(false);
		contentPane_1.setOpaque(false);
		contentPane_2.setOpaque(false);
		contentPane_3.setOpaque(false);
		//将图片置于最底层
		getLayeredPane().add(Backgroundlabel, new Integer(Integer.MIN_VALUE));
		
		Icon previous = new ImageIcon("image/previous.png");
		button = new JButton(previous);
		contentPane_1.add(button);
		/* 上一题按钮事件监听  
		 * 
		 * 判断是否允许答题
		 * 判断是否是第一题
		 * 如果是，提醒用户
		 * 如果不是，题号减1,并更新相关组件
		 */
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					if (topicId == 1) {
						JOptionPane.showMessageDialog(Main.this, "本题已经是第一题！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						topicId = topicId - 1;
						updateElement();
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Main.this, "答题时间到，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Main.this, "题目已答完，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		Icon next = new ImageIcon("image/next.png");
		button_1 = new JButton(next);
		contentPane_1.add(button_1);
		/* 提交按钮事件监听
		 * 
		 * 判断是否允许答题
		 * 判断是否选择了答案
		 * 判断是否是最后一题
		 */
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerState) {
					proSet = pro.stringPropertyNames();
					//判断是否选择答案
					if (jrbA.isSelected() || jrbB.isSelected() || jrbC.isSelected() || jrbD.isSelected()) {
						//判断是否是最后一题
						if (proSet.size() == topicId) {
							answerState = false;
							scoreOperator();
							try {
								recordExamInfo();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(Main.this, "题目已答完！", null, JOptionPane.WARNING_MESSAGE);
							JOptionPane.showMessageDialog(Main.this, "您答对"+(score/5)+"道题，得分为："+score+"分！", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							topicId = topicId + 1;
							updateElement();
						}
					} else {
						JOptionPane.showMessageDialog(Main.this, "您还没有选择答案！请选择！", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (time == 0) {
						JOptionPane.showMessageDialog(Main.this, "答题时间到，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(Main.this, "题目已答完，请退出答题系统！", null, JOptionPane.WARNING_MESSAGE);
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
				//先删除组件，再重新添加
				contentPane_3.remove(label);
				label = new JLabel("时间还剩：" + time);
				label.setForeground(Color.ORANGE);
				label.setFont(new Font("华文行楷", Font.BOLD, 20));
				contentPane_3.add(label);
				setVisible(true);//必须有
				if (time == 0) {
					answerState = false;
					JOptionPane.showMessageDialog(this, "答题时间到！", null, JOptionPane.WARNING_MESSAGE);
					scoreOperator();
					JOptionPane.showMessageDialog(this, "您答对"+(score/5)+"道题，得分为："+score+"分！", null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	/**
	 * 显示题目
	 * @throws IOException
	 */
	public void showTopic() throws IOException {
		FileInputStream f = new FileInputStream(new File("topic.properties"));
		pro.load(f);
		String[] topics = pro.getProperty("topic1").split(",,");
		topic = topics[0].substring(topics[0].indexOf("=")+1);
		correctAnswer = topics[1].substring(topics[1].indexOf("=")+1, topics[1].length()-1);
		if (topic == null) {
			JOptionPane.showMessageDialog(this, "题目为空！");
		}
		topicId = 1;
		textArea.setText("题目:\n" + topic);
	}
	
	/**
	 * 添加单选按钮
	 */
	public void addJRadioButton() {
		//必须将单选按钮都放到一个按钮组中，才能实现只选一个的功能
		ButtonGroup buttonGroup = new ButtonGroup();
		jrbA = new JRadioButton("A");
		//监听单选按钮事件
		jrbA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userAnswer = jrbA.getText();
				//选完后将答案保存在map集合中
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
	 * 点击按钮后更新组件
	 */
	public void updateElement() {
		String[] topics = pro.getProperty("topic"+topicId).split(",,");
		topic = topics[0].substring(topics[0].indexOf("=")+1);
		correctAnswer = topics[1].substring(topics[1].indexOf("=")+1, topics[1].length()-1);
		contentPane_2.remove(scroll);
		textArea = new JTextArea();
		textArea.setFont(new Font("华文行楷", Font.BOLD, 15));
		textArea.setText("题目:\n" + topic);
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
			if (correctAnswerValue.equals(userAnswerValue)) {
				score += 5;
			}
		}
	}

	/**
	 * 记录考试信息
	 * @throws IOException 
	 */
	public void recordExamInfo() throws IOException {
		FileOutputStream f = new FileOutputStream(new File("score.properties"), true);
		Properties proScore = new Properties();
		proScore.setProperty("score"+studentId, "[studentId="+studentId+",score="+score+"]");
		proScore.store(f, null);
	}
}
