package com.ypy.proxy;
/*
 * 时间：2017年1月10日 18:13:42。
 * 目的：动态代理三 : 完善，可以对任意对象、任意接口方法，实现任意代理。
 */

public class Client {
	public static void main(String[] args) throws Exception {
		Moveable t = new Tank();
		
		InvocationHandler h = new TimeHandler(t);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
		
		m.move();
	}
}
