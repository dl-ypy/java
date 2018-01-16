package com.ypy.db.command;
/*
 * 时间：2017年1月14日 09:29:28。
 * 目的：Command模式
 */
public class Test {
	public static void main(String[] args) {
		Boy b = new Boy("张三");
		MM m = new MM("小花");
		m.order(b);
	}
}
