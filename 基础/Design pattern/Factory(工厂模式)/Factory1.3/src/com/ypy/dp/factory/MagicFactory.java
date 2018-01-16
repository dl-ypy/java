package com.ypy.dp.factory;
//魔法世界系列产品
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
