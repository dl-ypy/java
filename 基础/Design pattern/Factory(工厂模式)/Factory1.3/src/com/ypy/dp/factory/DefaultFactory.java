package com.ypy.dp.factory;
//默认系列产品
public class DefaultFactory extends AbstractFactory{

	@Override
	public Vehicle createVehicle() {
		return new Car();
	}

	@Override
	public Weapon createWeapon() {
		return new AK47();
	}

	@Override
	public Foot createFoot() {
		return new Apple();
	}
	
}
