package com.ypy.dp.factory;
//Ĭ��ϵ�в�Ʒ
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
