package com.ypy.db.bridge;

public class WildGift extends Gift{
	
	public WildGift(GiftImpl impl) {
		this.impl = impl;
	} 
	
	@Override
	public String toString() {
		return "¿ñÒ°µÄ" + impl;
	}
}
