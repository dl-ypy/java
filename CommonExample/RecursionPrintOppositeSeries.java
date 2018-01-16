/**
 * date:2017年7月1日16:32:28
 * target:递归打印出上下两部分正好相反的数列。
 * @author ypy
 */
public class RecursionPrintOppositeSeries {
	public static void main(String[] args) {
		Num(500);
	}
	
	public static void Num(int n) {
		System.out.println(n);
		if (n < 5000) {
			Num(n*2);
		}
		System.out.println(n);
	}
}



/*
***************JDK1.8运行结果****************
500
1000
2000
4000
8000
8000
4000
2000
1000
500
*/
