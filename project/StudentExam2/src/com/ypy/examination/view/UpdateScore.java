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
import javax.swing.JTextField;
import com.ypy.examination.model.Score;
import com.ypy.examination.service.impl.ScoreServiceImpl;
import com.ypy.examination.util.RuleUtil;

public class UpdateScore extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score_id;
	private JPanel panel;
	private JLabel idLabel;
	private JTextField idText;
	private JLabel userIdLabel;
	private JTextField userIdText;
	private JLabel courseLabel;
	private JTextField courseText;
	private JLabel norScoreLabel;
	private JTextField norScoreText;
	private JLabel minScoreLabel;
	private JTextField minScoreText;
	private JLabel endScoreLabel;
	private JTextField endScoreText;
	private JLabel totScoreLabel;
	private JTextField totScoreText;
	private JButton backButton;
	private JButton updateButton;
	ScoreServiceImpl impl = new ScoreServiceImpl();
	Score score = new Score();
	
	public UpdateScore() {
		super();
	}
	public UpdateScore(int score_id) {
		super();
		this.score_id = score_id;
		init();
	}
	
	public void init() {
		setTitle("�޸ĳɼ���Ϣ����");
		setBounds(500, 30, 500, 400);
		panel = new JPanel(new GridLayout(8, 2, 5, 5));
		
		score = impl.selectById(score_id);
		if (score.getScore_id() == 0) {
			JOptionPane.showMessageDialog(UpdateScore.this, "û�д��û���", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		idLabel = new JLabel("�ɼ����");
		idText = new JTextField(String.valueOf(score.getScore_id()));
		//���ò������޸ĳɼ����
		idText.setEditable(false);
		userIdLabel = new JLabel("�û���ţ�");
		userIdText = new JTextField(String.valueOf(score.getUser_id()));
		userIdText.setEditable(false);
		courseLabel = new JLabel("�γ̣�");
		courseText = new JTextField(score.getCourse());
		norScoreLabel = new JLabel("ƽʱ�ɼ���");
		norScoreText = new JTextField(String.valueOf(score.getNormal_score()));
		minScoreLabel = new JLabel("���гɼ���");
		minScoreText = new JTextField(String.valueOf(score.getMid_score()));
		endScoreLabel = new JLabel("��ĩ�ɼ���");
		endScoreText = new JTextField(String.valueOf(score.getEnd_score()));
		totScoreLabel = new JLabel("���ճɼ���");
		totScoreText = new JTextField(String.valueOf(score.getTotal_score()));
		totScoreText.setEditable(false);
		backButton = new JButton("����");
		updateButton = new JButton("�޸�");
		panel.add(idLabel);
		panel.add(idText);
		panel.add(userIdLabel);
		panel.add(userIdText);
		panel.add(courseLabel);
		panel.add(courseText);
		panel.add(norScoreLabel);
		panel.add(norScoreText);
		panel.add(minScoreLabel);
		panel.add(minScoreText);
		panel.add(endScoreLabel);
		panel.add(endScoreText);
		panel.add(totScoreLabel);
		panel.add(totScoreText);
		panel.add(backButton);
		panel.add(updateButton);
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
		
		//�޸İ�ť
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!courseText.getText().equals("") && !norScoreText.getText().equals("") && !minScoreText.getText().equals("") && !endScoreText.getText().equals("")) {
					if (RuleUtil.scoreRule(norScoreText.getText()) && RuleUtil.scoreRule(minScoreText.getText()) && RuleUtil.scoreRule(endScoreText.getText())) {
						score.setCourse(courseText.getText());
						score.setEnd_score(Double.parseDouble(endScoreText.getText()));
						score.setMid_score(Double.parseDouble(minScoreText.getText()));
						score.setNormal_score(Double.parseDouble(norScoreText.getText()));
						score.setTotal_score(Double.parseDouble(endScoreText.getText())+Double.parseDouble(minScoreText.getText())+Double.parseDouble(norScoreText.getText()));
						int n = impl.updateById(score_id, score);
						if (n != -1) {
							JOptionPane.showMessageDialog(UpdateScore.this, "�޸ĳɹ���", null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(UpdateScore.this, "�޸�ʧ�ܣ�", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(UpdateScore.this, "������ʽ����", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(UpdateScore.this, "��Ϣ��������", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
