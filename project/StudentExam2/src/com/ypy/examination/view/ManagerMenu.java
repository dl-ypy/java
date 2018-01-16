package com.ypy.examination.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.ypy.examination.model.Examination;
import com.ypy.examination.model.Score;
import com.ypy.examination.model.User;
import com.ypy.examination.service.impl.ExaminationServiceImpl;
import com.ypy.examination.service.impl.ScoreServiceImpl;
import com.ypy.examination.service.impl.UserServiceImpl;

public class ManagerMenu extends JFrame{
	private Login login;
	private int user_id;
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel welcomeLable;
	private JTable tableUser;
	private JTable tableExamination;
	private JTable tableScore;
	private JButton selectUserButton;
	private JButton selectExaminationButton;
	private JButton selectScoreButton;
	private JButton logoutButton;
	private JButton addUserButton;
	private JButton updateUserButton;
	private JButton deleteUserButton;
	private JButton addExaminationButton;
	private JButton updateExaminationButton;
	private JButton deleteExaminationButton;
	private JButton updateScoreButton;
	private JButton deleteScoreButton;
	private JScrollPane jScrollPaneUser;
	private JScrollPane jScrollPaneScore;
	private JScrollPane jScrollPaneExamination;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ManagerMenu(int user_id, Login login) {
		this.user_id = user_id;
		this.login = login;
		init();
	}

	private void init() {
		setTitle("����Ա�˵�");
		setBounds(300, 50, 900, 700);
		panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		welcomeLable = new JLabel("��ӭ�������Ա�˵�",JLabel.CENTER);
		welcomeLable.setFont(new Font("�����п�", Font.BOLD, 50));
		selectUserButton = new JButton("��ѯѧ����Ϣ");
		selectExaminationButton = new JButton("��ѯ�Ծ���Ϣ");
		selectScoreButton = new JButton("��ѯ�ɼ���Ϣ");
		logoutButton = new JButton("ע��");
		addUserButton = new JButton("����û�");
		updateUserButton = new JButton("�޸��û�");
		deleteUserButton = new JButton("ɾ���û�");
		addExaminationButton = new JButton("�����Ŀ");
		updateExaminationButton = new JButton("�޸���Ŀ");
		deleteExaminationButton = new JButton("ɾ����Ŀ");
		updateScoreButton = new JButton("�޸ĳɼ�");
		deleteScoreButton = new JButton("ɾ���ɼ�");
		panel3.setLayout(new FlowLayout());
		panel2.setLayout(new GridLayout(5, 1, 5, 5));
		panel.setLayout(new BorderLayout());
		panel2.add(selectUserButton);
		panel2.add(selectExaminationButton);
		panel2.add(selectScoreButton);
		panel2.add(logoutButton);
		panel.add("North", welcomeLable);
		panel.add("West", panel2);
		panel.setBackground(Color.red);
		setContentPane(panel);
		myEvent();
	}
	
	public void myEvent() {
		//��ѯѧ����Ϣ��ť
		selectUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserServiceImpl impl = new UserServiceImpl();
				String[] tableHead = {"ѧ�����","ѧ���˺�","ѧ�����","ѧ������","ѧ������","ѧ���Ա�","ѧ�����֤","ѧ���绰","ѧ��ѧԺ","ѧ���꼶","ѧ���༶"};
				List<User> list = impl.selectAll();
				Object[][] tableBodys = new Object[list.size()][];
				for (int i = 0; i < list.size(); i++) {
					User user = list.get(i);
					String user_type_str = "";
					if (user.getUser_type() == 1) {
						user_type_str = "����Ա";
					} else {
						user_type_str = "��ͨ�û�";
					}
					tableBodys[i] = new Object[]{user.getUser_id(),user.getUser_account(),user_type_str,user.getUser_name(),user.getUser_age(),user.getUser_sex(),user.getUser_idcard(),user.getUser_phone(),user.getUser_institure(),user.getUser_grade(),user.getUser_class()};
				}
				//ȷ�����ѡ�����ɱ༭
				tableUser = new JTable(0, 11){
				    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int rowIndex, int ColIndex){
			             return false;
			         }
			    };
			    //���ñ���С
			    tableUser.setPreferredScrollableViewportSize(new Dimension(750,450));
				DefaultTableModel tableModel = (DefaultTableModel) tableUser.getModel();
				tableModel.addRow(tableHead);
				for (int i = 0; i < tableBodys.length; i++) {
					tableModel.addRow(tableBodys[i]);
				}
				//ȷ������û���������
				controlIsExist();
				//���ù�����
				jScrollPaneUser = new JScrollPane(tableUser);
				panel3.add(jScrollPaneUser);
				panel3.add(addUserButton);
				panel3.add(updateUserButton);
				panel3.add(deleteUserButton);
				panel.add("Center",panel3);
				setVisible(true);
			}
		});
		
		//��ѯ���ⰴť
		selectExaminationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExaminationServiceImpl examinationServiceImpl = new ExaminationServiceImpl();
				List<Examination> list = examinationServiceImpl.selectAll();
				String[] tableHead = {"������","������Ŀ","ѡ��A","ѡ��B","ѡ��C","ѡ��D","�������","�����","�ϴ���ʦ���"};
				Object[][] tableBodys = new Object[list.size()][9];
				for(int i=0; i<tableBodys.length; i++) {
					Examination examination = list.get(i);
					tableBodys[i] = new Object[]{examination.getTp_id(),examination.getTp_title(),examination.getTp_choicea(),examination.getTp_choiceb(),examination.getTp_choicec(),examination.getTp_choiced(),examination.getTp_score(),examination.getTp_answer(),examination.getUser_id()};
				}
				tableExamination = new JTable(0, 9){
				    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int rowIndex, int ColIndex){
			             return false;
			         }
			    };
			    controlIsExist();
				tableExamination.setPreferredScrollableViewportSize(new Dimension(750,450));
				DefaultTableModel tableModel = (DefaultTableModel) tableExamination.getModel();
				tableModel.addRow(tableHead);
				for (int i = 0; i < tableBodys.length; i++) {
					tableModel.addRow(tableBodys[i]);
				}
				jScrollPaneExamination = new JScrollPane(tableExamination);
				jScrollPaneExamination.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				jScrollPaneExamination.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				panel3.add(jScrollPaneExamination);
				panel3.add(addExaminationButton);
				panel3.add(updateExaminationButton);
				panel3.add(deleteExaminationButton);
				panel.add("Center",panel3);
				setVisible(true);
			}
		});
		
		//��ѯ�ɼ���ť
		selectScoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreServiceImpl scoreServiceImpl = new ScoreServiceImpl();
				List<Score> list = scoreServiceImpl.selectAll();
				String[] tableHead = {"�ɼ����","ѧ�����","�γ�","ƽʱ�ɼ�","���гɼ�","��ĩ�ɼ�","���ճɼ�"};
				Object[][] tableBodys = new Object[list.size()][7];
				for(int i=0; i<tableBodys.length; i++) {
					Score score = list.get(i);
					tableBodys[i] = new Object[]{score.getScore_id(),score.getUser_id(),score.getCourse(),score.getNormal_score(),score.getMid_score(),score.getEnd_score(),score.getTotal_score()};
				}
				tableScore = new JTable(0, 7){
				    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int rowIndex, int ColIndex){
			             return false;
			         }
			    };
			    controlIsExist();
				tableScore.setPreferredScrollableViewportSize(new Dimension(750,450));
				DefaultTableModel tableModel = (DefaultTableModel) tableScore.getModel();
				tableModel.addRow(tableHead);
				for (int i = 0; i < tableBodys.length; i++) {
					tableModel.addRow(tableBodys[i]);
				}
				jScrollPaneScore = new JScrollPane(tableScore);
				jScrollPaneScore.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				jScrollPaneScore.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				panel3.add(jScrollPaneScore);
				panel3.add(updateScoreButton);
				panel3.add(deleteScoreButton);
				panel.add("Center",panel3);
				setVisible(true);
			}
		});
		
		//����û���ť
		addUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddUser addUser = new AddUser();
				addUser.setVisible(true);
			}
		});
		
		//�޸��û���ť
		updateUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEvent(tableUser, 1);
			}
		});
		
		//ɾ���û���ť
		deleteUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEvent(tableUser, 1);
			}
		});
		
		//������ⰴť
		addExaminationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddExamination addExamination = new AddExamination(user_id);
				addExamination.setVisible(true);
			}
		});
		
		//�޸����ⰴť
		updateExaminationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEvent(tableExamination, 2);
			}
		});
		
		//ɾ������
		deleteExaminationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEvent(tableExamination, 2);
			}
		});
		
		//�޸ĳɼ���ť
		updateScoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateEvent(tableScore, 3);
			}
		});
		
		//ɾ���ɼ�
		deleteScoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEvent(tableScore, 3);
			}
		});
		
		//ע����ť
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerMenu.this.setVisible(false);
				login.setVisible(true);
			}
		});
	}
	
	//�жϿؼ��Ƿ����
	public void controlIsExist() {
		if (jScrollPaneScore != null) {
			panel3.remove(jScrollPaneScore);
			panel3.remove(updateScoreButton);
			panel3.remove(deleteScoreButton);
		}
	    if (jScrollPaneExamination != null) {
			panel3.remove(jScrollPaneExamination);
			panel3.remove(addExaminationButton);
			panel3.remove(updateExaminationButton);
			panel3.remove(deleteExaminationButton);
		}
		if (jScrollPaneUser != null) {
			panel3.remove(jScrollPaneUser);
			panel3.remove(addUserButton);
			panel3.remove(updateUserButton);
			panel3.remove(deleteUserButton);
		}
		//ɾ����ˢ�½���
		repaint();
	}
	
	//�޸��¼�
	public void updateEvent(JTable table, int m) {
		//ѡ�����
		int row = table.getSelectedRow();
		//ѡ�����
		int column = table.getSelectedColumn();
		//ȷ��ѡ����Ǳ��
		if (column == 0) {
			//��ȡ���
			int id = (int) table.getValueAt(row, column);
			//ͨ�������mѡ�񴴽��Ķ���
			switch (m) {
			case 1:
				UpdateUser updateUser = new UpdateUser(id);
				updateUser.setVisible(true);
				break;
			case 2:
				UpdateExamination examination = new UpdateExamination(id);
				examination.setVisible(true);
				break;
			case 3:
				UpdateScore score = new UpdateScore(id);
				score.setVisible(true);
				break;
			default:
				break;
			}
		} else {
			JOptionPane.showMessageDialog(ManagerMenu.this, "��ѡ���ţ�", null, JOptionPane.WARNING_MESSAGE);
		}
	}
	
	//ɾ���¼�
	public void deleteEvent(JTable table, int m) {
		int row = table.getSelectedRow();
		int column = table.getSelectedColumn();
		if (column == 0) {
			int id = (int) table.getValueAt(row, column);
			int n = -1;
			switch (m) {
			case 1:
				UserServiceImpl impl = new UserServiceImpl();
				n = impl.deleteById(id);
				break;
			case 2:
				ExaminationServiceImpl examinationServiceImpl = new ExaminationServiceImpl();
				n = examinationServiceImpl.deleteById(id);
				break;
			case 3:
				ScoreServiceImpl scoreServiceImpl = new ScoreServiceImpl();
				n = scoreServiceImpl.deleteById(id);
				break;
			default:
				break;
			}
			
			if (n != -1) {
				JOptionPane.showMessageDialog(ManagerMenu.this, "ɾ���ɹ���", null, JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(ManagerMenu.this, "ɾ��ʧ�ܣ�", null, JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(ManagerMenu.this, "��ѡ���ţ�", null, JOptionPane.WARNING_MESSAGE);
		}
	}
}
