package com.ypy.db.bridge;

public class WarmGift extends Gift{
	public WarmGift(GiftImpl impl) {
		this.impl = impl;
	}
	
	@Override
	public String toString() {
		return "��ů��" + impl;
	}
}
