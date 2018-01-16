package com.ypy.dp.factory;
/*
 * 时间：2017年1月13日 08:35:49。
 * 目的：工厂模式一：静态单例工厂。
 */
public class Test {

	public static void main(String[] args) {
		Car c = Car.getInstance();
		c.run();
	}

}
