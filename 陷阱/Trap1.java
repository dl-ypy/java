package javaTest;

/**
 * data:2018年3月22日20点20分
 * @author joker
 * Java常见陷阱之：乘法运算 *两边的类型默认为int
 */
public class Trap1{
	public static void main(String[] args){
		long a = 24 * 60 * 60 * 1000 * 1000;  //因为*两边的类型默认为int，所以是一个已经越界的int型付给long型
		long b = 24 * 60 * 60 * 1000;
		System.out.println("错误结果："+a/b);
		
		long a1 = 24L * 60 * 60 * 1000 * 1000;  
		long b1 = 24L * 60 * 60 * 1000;
		System.out.println("正确结果："+a1/b1);
	}
	
}

/**
 * JDK1.8运行结果
 * 错误结果：5
 * 正确结果：1000
*/