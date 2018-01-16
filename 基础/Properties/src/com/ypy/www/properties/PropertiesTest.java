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
 * date：2017年7月8日17:09:23
 * target:配置文件的操作
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
	
	//读取配置文件
	public static void read(String fileName) throws IOException {
		InputStream ips = new FileInputStream(fileName);
		Properties pro = new Properties();
		//加载文件
		pro.load(ips);
		ips.close();
		System.out.println(pro.getProperty("name"));
		System.out.println(pro.getProperty("age"));
	}
	
	//写入配置文件
	public static void write(String fileName) throws IOException {
		Map<String, String> map = new HashMap<>();
		map.put("name", "Wang");
		map.put("age", "25");
		map.put("weight", "500");
		
		Properties pro = new Properties();
		for (Entry<String,String> e : map.entrySet()) {
			pro.setProperty(e.getKey(), e.getValue());
		}
		//按格式写入文件
		PrintWriter pw = new PrintWriter(fileName);
		pro.list(pw);
		pw.close();
	}

        //修改配置文件
	public static void update(String fileName) throws IOException {
		InputStream ips = new FileInputStream(new File(fileName));
		Properties pro = new Properties();
		pro.load(ips);
			//修改配置文件内容
		pro.setProperty("name", "namecopy");
		FileOutputStream fops = new FileOutputStream(new File("snake.properties"));
		pro.store(fops, "update");
	}

}
/*
***************JDK1.8运行结果****************
Wang
25
*/