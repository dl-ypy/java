import java.util.Arrays;

/**
 * 编写一个截取字符串的函数，输入为一个字符串和字 、编写一个截取字符串的函数，
 * 输入为一个字符串和字 节数，输出为按字节截取的字符串，但要保证汉字不被截取半个，
 * 如“我 我 ABC” ，4 ，应该截取“我 AB”，输入“我 ABC汉 DEF” ，6 ，应该输出“我 ABC” ，而不是“我 ABC+汉的半个 ”。 
 * @author ypy
 */
public class CutoffStrByBytes {
	public static void main(String[] args) {
		String str = "我abc哈哈";
		int num = trimGBK(str.getBytes(), 6);
		System.out.println(str.substring(0, num));//返回索引为0-num（不包括第num个）的子字符串
	}
	
	/**
	 * 按字节数截取字符串
	 * @param buf 要截取字符串的byte数组
	 * @param n 要截取的字节数
	 * @return 要截取到第几个字符
	 */
	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		for(int i=0; i<n; i++) {
			//GBK编码汉字的两个字节都为负数
			//判断是否为汉字的第一个字节
			//判断条件：此字节为负数且前一次判断将"是否为汉字首字节"设为否，说明上一次不是首字节，而这次肯定是首字节
			if (buf[i]<0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;//判断为汉字首字节后，将"是否为汉字首字节"的标志设为是
			} else {//否则，是汉字尾字节或者不是汉字，都将计数器++，都表示一个字符
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
	
}
/*
***************JDK1.8运行结果****************
*我abc
*/