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

public class UpdateExamination extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tp_id;
	private JPanel panel;
	private JLabel idLabel;
	private JTextField idText;
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
	private JButton updateButton;
	ExaminationServiceImpl impl = new ExaminationServiceImpl();
	Examination exam = new Examination();
	
	public UpdateExamination(int tp_id) {
		super();
		this.tp_id = tp_id;
		init();
	}
	public UpdateExamination() {
		super();
	}
	
	public void init() {
		setTitle("�޸�������Ϣ����");
		setBounds(500, 30, 500, 400);
		panel = new JPanel(new GridLayout(9, 2, 5, 5));
		exam = impl.selectById(tp_id);
		if (exam.getTp_id() == 0) {
			JOptionPane.showMessageDialog(UpdateExamination.this, "û�д��û���", null, JOptionPane.WARNING_MESSAGE);
			return;
		}
		idLabel = new JLabel("��Ŀ��ţ�");
		idText = new JTextField(String.valueOf(exam.getTp_id()));
		//���ò������޸���Ŀ���
		idText.setEditable(false);
		titleLabel = new JLabel("�������ݣ�");
		titleText = new JTextArea(exam.getTp_title());
		choiceALabel = new JLabel("ѡ��A��");
		choiceAText = new JTextField(exam.getTp_choicea());
		choiceBLabel = new JLabel("ѡ��B��");
		choiceBText = new JTextField(exam.getTp_choiceb());
		choiceCLabel = new JLabel("ѡ��C��");
		choiceCText = new JTextField(exam.getTp_choicec());
		choiceDLabel = new JLabel("ѡ��D��");
		choiceDText = new JTextField(exam.getTp_choiced());
		scoreLabel = new JLabel("���������");
		scoreText = new JTextField(String.valueOf(exam.getTp_score()));
		answerLabel = new JLabel("����𰸣�");
		answerText = new JTextField(exam.getTp_answer());
		backButton = new JButton("����");
		updateButton = new JButton("�޸�");
		panel.add(idLabel);
		panel.add(idText);
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
				if (!answerText.getText().equals("") && !choiceAText.getText().equals("") && !choiceBText.getText().equals("") && !choiceCText.getText().equals("") && !choiceDText.getText().equals("") && !scoreText.getText().equals("") && !titleText.getText().equals("")) {
					if (RuleUtil.scoreRule(scoreText.getText())) {
						if (RuleUtil.answerRule(answerText.getText())) {
							exam.setTp_answer(answerText.getText());
							exam.setTp_choicea(choiceAText.getText());
							exam.setTp_choiceb(choiceBText.getText());
							exam.setTp_choicec(choiceCText.getText());
							exam.setTp_choiced(choiceDText.getText());
							exam.setTp_score(Double.parseDouble(scoreText.getText()));
							exam.setTp_title(titleText.getText());
							int n = impl.updateById(tp_id, exam);
							if (n != -1) {
								JOptionPane.showMessageDialog(UpdateExamination.this, "�޸ĳɹ���", null, JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(UpdateExamination.this, "�޸�ʧ�ܣ�", null, JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(UpdateExamination.this, "��Ӧ��ΪA��B��C��D��a��b��c��d��", null, JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(UpdateExamination.this, "������ʽ����", null, JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(UpdateExamination.this, "��Ϣ��������", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
