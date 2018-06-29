package com.ypy.arithmetic.recursion;
/**
 * @author joker
 * @data 2018年6月21日09点51分
 * @target 汉诺塔问题
 * 问题描述：
 *     大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
 *     大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 *     并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 * 算法描述：
 *     将原柱上的n-1个圆盘移动到辅助柱
 *     将第n个圆盘从原柱移动到目的柱
 *     将辅助柱的n-1个圆盘移动到目的柱
 *     递归执行...
 */
public class Hanoi {

	/**
	 * @param n          圆盘个数
	 * @param fromPeg    原柱
	 * @param toPeg      目的柱
	 * @param auxPeg     辅助柱
	 */
	public static void TowersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
		//终止条件
		if (n == 1) {
			System.out.println("从"+ fromPeg + "移动圆盘到" +toPeg);
			return;
		}
		//利用C柱作为辅助，将A柱上的n-1个圆盘移动到B柱
		TowersOfHanoi(n-1, fromPeg, auxPeg, toPeg);
		//将剩下的圆盘从A柱移动到C柱
		System.out.println("从"+ fromPeg + "移动圆盘到" +toPeg);
		//利用A柱作为辅助，将B柱上的n-1个圆盘移动到C柱
		TowersOfHanoi(n-1, auxPeg, toPeg, fromPeg);
	}
}

/**
 * 在jdk1.8运行结果
 * 从A移动圆盘到C
 * 从A移动圆盘到B
 * 从C移动圆盘到B
 * 从A移动圆盘到C
 * 从B移动圆盘到A
 * 从B移动圆盘到C
 * 从A移动圆盘到C 
*/