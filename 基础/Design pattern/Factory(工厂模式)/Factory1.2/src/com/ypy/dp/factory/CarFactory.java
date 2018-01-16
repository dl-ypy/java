package com.ypy.dp.factory;

public class CarFactory implements VehicleFactory{
	public Moveable create() {
		return new Car();
	}
}
