package com.ypy.db.state;
/*
 * 时间：2017年1月14日 10:08:21。
 * 目的：State模式
 *     不同的状态，不同的行为
 */
public class Test {
	public static void main(String[] args) {
		MM m = new MM("小花");
		m.say();
		m.cry();
		m.smile();
	}
}
