package com.ypy.examination.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.ypy.examination.model.Score;
import com.ypy.examination.service.impl.ScoreServiceImpl;

public class MyScore extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private JPanel panel;
	private JTable table;
	private JButton backButton;
	private JScrollPane jScrollPane;
	ScoreServiceImpl impl = new ScoreServiceImpl();
	Score score = new Score();
	
	public MyScore(int user_id) {
		this.user_id = user_id;
		init();
	}
	
	public void init() {
		setTitle("�ҵĳɼ�");
		setBounds(500, 30, 800, 560);
		panel = new JPanel();
		backButton = new JButton("����");
		backButton.setBounds(450, 500, 40, 20);
		String[] tableHead = new String[]{"�ɼ����","ѧ�����","�γ�����","ƽʱ�ɼ�","���гɼ�","��ĩ�ɼ�","���ճɼ�"};
		List<Score> list = impl.selectByUserid(user_id);
		Object[][] tableBodys = new Object[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			Score score = list.get(i);
			tableBodys[i] = new Object[]{score.getScore_id(),score.getUser_id(),score.getCourse(),score.getNormal_score(),score.getMid_score(),score.getTotal_score(),score.getTotal_score()};
		}
		table = new JTable(0,7){
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int ColIndex){
	             return false;
	         }
	    };
	    table.setPreferredScrollableViewportSize(new Dimension(750,450));
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.addRow(tableHead);
		for (int i = 0; i < tableBodys.length; i++) {
			tableModel.addRow(tableBodys[i]);
		}
		jScrollPane = new JScrollPane(table);
		panel.add(jScrollPane);
		panel.add(backButton);
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
	}

}
