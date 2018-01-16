package com.ypy.db.bridge;
//礼物类
//两个礼物类别类继承此类，方便new的时候只通过Gift就可以new出
public class Gift {
	protected GiftImpl impl;      //使得Gift和GiftImpl为聚合关系
}
