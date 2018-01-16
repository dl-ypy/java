package com.ypy.db.state;

public class MMUnHappyState implements MMState {

	@Override
	public void smile() {
		System.out.println("不高兴的笑");
	}

	@Override
	public void say() {
		System.out.println("不高兴的说");
	}

	@Override
	public void cry() {
		System.out.println("不高兴的哭");
	}

}
