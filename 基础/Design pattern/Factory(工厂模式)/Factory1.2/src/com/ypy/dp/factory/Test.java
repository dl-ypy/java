package com.ypy.dp.factory;
/*
 * ʱ�䣺2017��1��13�� 08:35:49��
 * Ŀ�ģ�����ģʽ�����򵥹�����
 *     ���ⶨ�ƽ�ͨ���ߵ����ͺ��������̡�
 */
public class Test {

	public static void main(String[] args) {
		VehicleFactory v = new PlaneFactory();
		Moveable m = v.create();
		m.run();
	}

}
