package javaTest;

/**
 * data:2018��3��22��20��39��
 * @author joker
 * Java��������֮��Unicodeת���ַ�
 */
public class Trap2{
	public static void main(String[] args){
		System.out.println("a\u0022.length()+\u0022b".length());  //\u0022��"��Unicodeת���ַ�
		System.out.println("a".length()+"b".length());   //��˵ȼ�
	}
	
}

/**
 * JDK1.8���н��
 * 2
 * 2
*/