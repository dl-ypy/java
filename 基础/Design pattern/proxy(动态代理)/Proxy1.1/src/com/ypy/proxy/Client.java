package com.ypy.proxy;
/*
 * ʱ�䣺2017��1��9��10:16:39��
 * Ŀ�ģ���̬����һ:��ν��д���
 * �������������̹���඼ʵ��Moveable�ӿڣ�������Ĺ��췽������Moveable���͵Ĳ���
 *     �ڴ˲��Է�����ʵ����ʱ�����Խ���ͬ������Ķ��󴫵���һ��������Ĺ��췽���У������ͽ���������а���
 *     �仯�����Ϳ��Խ��в�ͬ�İ�����
 */

public class Client {
	public static void main(String[] args) {
		Tank t = new Tank();
		TankLogProxy tlp = new TankLogProxy(t);
		TankTimeProxy ttp = new TankTimeProxy(tlp);
		
		Moveable m = ttp;
		
		m.move();
	}
}
