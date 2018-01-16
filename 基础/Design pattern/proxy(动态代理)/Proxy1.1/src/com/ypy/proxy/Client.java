package com.ypy.proxy;
/*
 * 时间：2017年1月9日10:16:39。
 * 目的：动态代理一:如何进行代理。
 * 方法：代理类和坦克类都实现Moveable接口，代理类的构造方法都传Moveable类型的参数
 *     在此测试方法中实例化时，可以将不同代理类的对象传到另一个代理类的构造方法中，这样就将代理类进行包裹
 *     变化参数就可以进行不同的包裹。
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
