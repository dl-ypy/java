package com.ypy.dp.factory;
/*
 * 时间：2017年1月13日 08:35:49。
 * 目的：工厂模式二：简单工厂。
 *     任意定制交通工具的类型和生产过程。
 */
public class Test {

	public static void main(String[] args) {
		VehicleFactory v = new PlaneFactory();
		Moveable m = v.create();
		m.run();
	}

}
