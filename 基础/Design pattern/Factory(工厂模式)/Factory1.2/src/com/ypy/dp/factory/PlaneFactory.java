package com.ypy.dp.factory;

public class PlaneFactory implements VehicleFactory{
	public Moveable create() {
		return new Plane();
	}
}
