package com.ypy.db.bridge;
/*
 * 时间：2017年1月13日 18:45:12。
 * 目的：桥接模式
 *     在两个维度排列组合时使用，本例子中礼物的类别，如温暖的礼物、狂野的礼物，这是一个维度
 *                       具体的礼物，如鲜花、戒指是另一个维度
 *                       可以有温暖的鲜花，狂野的鲜花...
 */
public class Test {
	public static void main(String[] args) {
		Boy b = new Boy("张三");
		MM m = new MM("小花");
		b.pursue(m);
	}
}
