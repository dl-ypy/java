package com.ypy.proxy;
//运动时间的代理
public class TankTimeProxy implements Moveable{
	Moveable t;
	
	public TankTimeProxy(Moveable t) {
		this.t = t;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();   //开始时间
		t.move();
		long end = System.currentTimeMillis();     //结束时间
		System.out.println("time" + (end-start));
	}

}
