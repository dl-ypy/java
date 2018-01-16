/**
 * date:2017年6月1日10:03:08
 * target:switch可以判断的数据类型。
 * @author ypy
 * conclusion:
 *     传递给switch和case的应该是个整数表达式，即int，所以byte,short,char以及其封装类可以。
 *     新版本支持String原理：在编译器层次会将字符串类型转换为与整数类型兼容的格式。
 *     case字句的值是不能重复的，如字符串：“男”和“\u7537”也不可以，且此值必须是常量，如果是变量要加final。
 *     也支持enum枚举类型。
 */
public class Switch {
	public static void main(String[] args) {
		float f = 1.3f; //no
		double d = 2.0;  //no
		int i = 5;   //yes
		boolean b = false;   //no
		byte by = 3;    //yes
		short s = 2;    //yes
		long l = 5;     //no
		char c = 'u';   //yes
		String str = "yy";   //java7及以后版本yes
		
		switch (str) {
		case "yy":
			System.out.println("yes!");
			break;
		default:
			System.out.println("no!");
		}
	}
}
/*
 *************** jdk1.8运行结果***************
yes!
 */
