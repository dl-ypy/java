package com.ypy.dp.factory;
//ħ������ϵ�в�Ʒ
public class MagicFactory extends AbstractFactory{

	@Override
	public Vehicle createVehicle() {
		return new Broom();
	}

	@Override
	public Weapon createWeapon() {
		return new MagicStick();
	}

	@Override
	public Foot createFoot() {
		return new MushRoom();
	}
	
}
