package com.ypy.dp.factory;
/*
 * ʱ�䣺2017��1��13�� 09:46:26��
 * Ŀ�ģ�����ģʽ�������󹤳���
 *     ����ϵ�в�Ʒ��
 */
public class Test {

	public static void main(String[] args) {
		
		AbstractFactory af = new MagicFactory();
		Vehicle c = af.createVehicle();
		c.run();
		Weapon ak = af.createWeapon();
		ak.shoot();
		Foot a = af.createFoot();
		a.printName();
	}

}
