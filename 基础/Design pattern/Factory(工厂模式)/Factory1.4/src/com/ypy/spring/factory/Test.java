package com.ypy.spring.factory;

import java.io.IOException;
import java.util.Properties;

/*
 * 时间：2017年1月13日 10:42:34。
 * 目的：工厂模式四：spring里面的BeanFactory。
 *     配置文件读取。
 */
public class Test {

	public static void main(String[] args) {
		Properties props = new Properties();
		try {
			props.load(Test.class.getClassLoader().getResourceAsStream("com/ypy/spring/factory/spring.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String VechileTypeName = props.getProperty("VehicleType");
		try {
			Object o = Class.forName(VechileTypeName).newInstance();    //load到内存并且实例化
			Moveable m = (Moveable)o;
			m.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
