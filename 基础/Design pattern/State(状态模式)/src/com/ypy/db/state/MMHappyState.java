package com.ypy.db.state;

public class MMHappyState implements MMState {

	@Override
	public void smile() {
		System.out.println("高兴的笑");
	}

	@Override
	public void say() {
		System.out.println("高兴的说");
	}

	@Override
	public void cry() {
		System.out.println("高兴的哭");
	}

}
