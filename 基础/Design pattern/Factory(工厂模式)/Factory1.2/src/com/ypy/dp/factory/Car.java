package com.ypy.dp.factory;

public class Car implements Moveable{
	
	private static Car car = new Car();   
	
	public Car(){}   
	
	public static Car getInstance() {    
		return car;
	}
	
	public void run() {
		System.out.println("Æû³µ");
	}
}
