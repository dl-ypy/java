package com.ypy.www.exam.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * ������
 * �������ܶ�Ҫ���õķ���
 * @author ypy
 */
public class Tool {
	/**
	 * �ж��û��Ƿ����
	 * @param studentId
	 * @return
	 * @throws IOException
	 */
	public static boolean isExistById(String studentId) throws IOException {
		Properties pro = new Properties();
		FileInputStream fileIn = new FileInputStream(new File("student.properties"));
		pro.load(fileIn);
		Set<String> proSet = pro.stringPropertyNames();
		Iterator<String> it = proSet.iterator();
		while (it.hasNext()) {
			String str = it.next();
			String[] arr = pro.getProperty(str).split(",");
			String id = arr[0].substring(arr[0].indexOf("=")+1);
			//�û�����
			if (studentId.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ���ļ������ѧ��
	 * @param studentId
	 * @param studentName
	 * @param studentPassword
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static void addStudent(JTextField studentId, JTextField studentName, JPasswordField studentPassword) throws IOException {
		Properties pro = new Properties();
		FileOutputStream fileOut = new FileOutputStream(new File("student.properties"), true);
		pro.setProperty("student"+studentId.getText(), "[id="+studentId.getText()+",name="+studentName.getText()+",password="+studentPassword.getText()+"]");
		pro.store(fileOut, null);
	}
	
	/**
	 * �ж�ѧ�ź������Ƿ�ƥ��
	 * @param studentId
	 * @param studentPassword
	 * @return
	 * @throws IOException
	 */
	public static boolean isMate(String studentId, String studentPassword) throws IOException {
		Properties pro = new Properties();
		FileInputStream fileIn = new FileInputStream(new File("student.properties"));
		pro.load(fileIn);
		Set<String> proSet = pro.stringPropertyNames();
		Iterator<String> it = proSet.iterator();
		while (it.hasNext()) {
			String str = it.next();
			String[] arr = pro.getProperty(str).split(",");
			String id = arr[0].substring(arr[0].indexOf("=")+1);
			String password = arr[2].substring(arr[2].indexOf("=")+1, arr[2].length()-1);
			//�û�����
			if (studentId.equals(id)) {
				//�ж�ѧ�ź������Ƿ�ƥ��
				if (id.equals(studentId) && password.equals(studentPassword)) {
					return true;
				}
			}
		}
		return false;
	}
}
