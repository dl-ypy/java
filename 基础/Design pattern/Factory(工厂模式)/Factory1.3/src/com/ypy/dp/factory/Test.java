package com.ypy.dp.factory;
/*
 * 时间：2017年1月13日 09:46:26。
 * 目的：工厂模式三：抽象工厂。
 *     产生系列产品。
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
