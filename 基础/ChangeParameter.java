/**
 * date:2017年6月22日15:48:34
 * targer:可变参
 * @author ypy
 */
public class ChangeParameter {
	public static void main(String[] args){
		System.out.println(add(1,2,3,4,5,6,7,8,9,10));
	}
	
	//相当于一个n的数组
	//可变参必须位于参数表的最后
	public static int add(int...n)	{
		int sum = 0;
		for (int i=0; i<n.length; i++) {
			sum += n[i];
		}
		return sum;
	}
}
/*
****************JDK1.8运行结果***************
*55
 */
