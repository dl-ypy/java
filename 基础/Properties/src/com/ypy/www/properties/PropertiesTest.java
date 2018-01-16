package com.ypy.www.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
/**
 * date��2017��7��8��17:09:23
 * target:�����ļ��Ĳ���
 * @author ypy
 */
public class PropertiesTest {

	public static void main(String[] args) {
		try {
			read("test.properties");
			write("test.properties");
			update("test.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡ�����ļ�
	public static void read(String fileName) throws IOException {
		InputStream ips = new FileInputStream(fileName);
		Properties pro = new Properties();
		//�����ļ�
		pro.load(ips);
		ips.close();
		System.out.println(pro.getProperty("name"));
		System.out.println(pro.getProperty("age"));
	}
	
	//д�������ļ�
	public static void write(String fileName) throws IOException {
		Map<String, String> map = new HashMap<>();
		map.put("name", "Wang");
		map.put("age", "25");
		map.put("weight", "500");
		
		Properties pro = new Properties();
		for (Entry<String,String> e : map.entrySet()) {
			pro.setProperty(e.getKey(), e.getValue());
		}
		//����ʽд���ļ�
		PrintWriter pw = new PrintWriter(fileName);
		pro.list(pw);
		pw.close();
	}

        //�޸������ļ�
	public static void update(String fileName) throws IOException {
		InputStream ips = new FileInputStream(new File(fileName));
		Properties pro = new Properties();
		pro.load(ips);
			//�޸������ļ�����
		pro.setProperty("name", "namecopy");
		FileOutputStream fops = new FileOutputStream(new File("snake.properties"));
		pro.store(fops, "update");
	}

}
/*
***************JDK1.8���н��****************
Wang
25
*/