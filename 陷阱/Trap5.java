package javaTest;

/**
 * data:2018��3��28��20��00��
 * @author joker
 * Java��������֮��finallyһ����ִ�У�
 */
public class Trap5{
	public static void main(String[] args){
		try {
			System.out.println("111");
			System.exit(0);   //�����˳���Ͳ���ִ��fianlly
		} finally {
			System.out.println("222");
		}
	}
}

/**
 * JDK1.8���н��
 * 111
*/