package javaTest;

/**
 * data:2018年3月22日20点39分
 * @author joker
 * Java常见陷阱之：Unicode转义字符
 */
public class Trap2{
	public static void main(String[] args){
		System.out.println("a\u0022.length()+\u0022b".length());  //\u0022是"的Unicode转义字符
		System.out.println("a".length()+"b".length());   //与此等价
	}
	
}

/**
 * JDK1.8运行结果
 * 2
 * 2
*/