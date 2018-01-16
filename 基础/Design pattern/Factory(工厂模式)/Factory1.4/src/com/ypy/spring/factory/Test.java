package com.ypy.spring.factory;

import java.io.IOException;
import java.util.Properties;

/*
 * ʱ�䣺2017��1��13�� 10:42:34��
 * Ŀ�ģ�����ģʽ�ģ�spring�����BeanFactory��
 *     �����ļ���ȡ��
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
			Object o = Class.forName(VechileTypeName).newInstance();    //load���ڴ沢��ʵ����
			Moveable m = (Moveable)o;
			m.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
