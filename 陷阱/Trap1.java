package javaTest;

/**
 * data:2018��3��22��20��20��
 * @author joker
 * Java��������֮���˷����� *���ߵ�����Ĭ��Ϊint
 */
public class Trap1{
	public static void main(String[] args){
		long a = 24 * 60 * 60 * 1000 * 1000;  //��Ϊ*���ߵ�����Ĭ��Ϊint��������һ���Ѿ�Խ���int�͸���long��
		long b = 24 * 60 * 60 * 1000;
		System.out.println("��������"+a/b);
		
		long a1 = 24L * 60 * 60 * 1000 * 1000;  
		long b1 = 24L * 60 * 60 * 1000;
		System.out.println("��ȷ�����"+a1/b1);
	}
	
}

/**
 * JDK1.8���н��
 * ��������5
 * ��ȷ�����1000
*/