package com.ypy.dp.factory;

public class Car {
	
	private static Car car = new Car();   //��֤ÿ��new�����Ķ���ͬһ����
	
	private Car(){}   //���췽��Ϊ˽�У�ʹ�ñ��˲������newһ����
	
	public static Car getInstance() {    //ͨ���˷���������new����Ϊ�˷����ǲ���car�ģ����Խй���ģʽ����Ϊ�Ǿ�̬�ģ����Խо�̬����
		return car;
	}
	
	public void run() {
		System.out.println("����");
	}
}
