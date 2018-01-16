package com.ypy.proxy;

import java.util.Random;

public class Tank implements Moveable{

	@Override
	public void move() {
		System.out.println("Tank moving....");
		try {
			Thread.sleep(new Random().nextInt(10000));   //睡眠10秒以内的随机时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
