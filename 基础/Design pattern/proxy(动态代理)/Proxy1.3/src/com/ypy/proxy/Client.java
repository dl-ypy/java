package com.ypy.proxy;
/*
 * ʱ�䣺2017��1��10�� 18:13:42��
 * Ŀ�ģ���̬������ : ���ƣ����Զ������������ӿڷ�����ʵ���������
 */

public class Client {
	public static void main(String[] args) throws Exception {
		Moveable t = new Tank();
		
		InvocationHandler h = new TimeHandler(t);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
		
		m.move();
	}
}
