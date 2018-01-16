package com.ypy.dp.factory;

public class Car {
	
	private static Car car = new Car();   //保证每次new出来的都是同一辆车
	
	private Car(){}   //构造方法为私有，使得别人不能随便new一辆车
	
	public static Car getInstance() {    //通过此方法，才能new，因为此方法是产生car的，所以叫工厂模式，因为是静态的，所以叫静态工厂
		return car;
	}
	
	public void run() {
		System.out.println("汽车");
	}
}
