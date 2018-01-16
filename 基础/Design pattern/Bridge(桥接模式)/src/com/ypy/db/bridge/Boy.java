package com.ypy.db.bridge;

public class Boy {
	private String name;

	public Boy(String name) {
		super();
		this.name = name;
	}

	public void pursue(MM mm) {
		Gift g = new WarmGift(new Ring());    //�������ʹ����ά���������
		give(g, mm);
	}
	
	public void give(Gift g, MM mm) {
		System.out.println(name + "�͸�" + mm.getName() + g);
	}
}
