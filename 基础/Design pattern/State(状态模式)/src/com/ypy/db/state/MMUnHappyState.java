package com.ypy.db.state;

public class MMUnHappyState implements MMState {

	@Override
	public void smile() {
		System.out.println("�����˵�Ц");
	}

	@Override
	public void say() {
		System.out.println("�����˵�˵");
	}

	@Override
	public void cry() {
		System.out.println("�����˵Ŀ�");
	}

}
