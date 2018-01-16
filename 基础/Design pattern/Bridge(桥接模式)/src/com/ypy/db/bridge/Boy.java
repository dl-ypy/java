package com.ypy.db.bridge;

public class Boy {
	private String name;

	public Boy(String name) {
		super();
		this.name = name;
	}

	public void pursue(MM mm) {
		Gift g = new WarmGift(new Ring());    //这里可以使两个维度任意组合
		give(g, mm);
	}
	
	public void give(Gift g, MM mm) {
		System.out.println(name + "送给" + mm.getName() + g);
	}
}
