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
 * 工具类
 * 多个类可能都要调用的方法
 * @author ypy
 */
public class Tool {
	/**
	 * 判断用户是否存在
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
			//用户存在
			if (studentId.equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 往文件中添加学生
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
	 * 判断学号和密码是否匹配
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
			//用户存在
			if (studentId.equals(id)) {
				//判断学号和密码是否匹配
				if (id.equals(studentId) && password.equals(studentPassword)) {
					return true;
				}
			}
		}
		return false;
	}
}
