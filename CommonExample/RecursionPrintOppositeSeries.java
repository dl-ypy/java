/**
 * date:2017��7��1��16:32:28
 * target:�ݹ��ӡ�����������������෴�����С�
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
***************JDK1.8���н��****************
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
