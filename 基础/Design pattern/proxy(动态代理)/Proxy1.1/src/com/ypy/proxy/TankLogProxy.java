package com.ypy.proxy;
//运行日志的代理
public class TankLogProxy implements Moveable{
	Moveable t;
	
	public TankLogProxy(Moveable t) {
		this.t = t;
	}

	@Override
	public void move() {
		System.out.println("tank start....");
		t.move();
		System.out.println("tank end....");
	}

}
