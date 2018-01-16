package com.ypy.proxy;
//�˶�ʱ��Ĵ���
public class TankTimeProxy implements Moveable{
	Moveable t;
	
	public TankTimeProxy(Moveable t) {
		this.t = t;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();   //��ʼʱ��
		t.move();
		long end = System.currentTimeMillis();     //����ʱ��
		System.out.println("time" + (end-start));
	}

}
