package com.ypy.proxy;
//������־�Ĵ���
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
