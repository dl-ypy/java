/**
 * date:2017��7��10��10:58:11
 * target:ö�١�
 * @author ypy
 */
public class Enum {
	public static void main(String args[]) { 
		System.out.println(Color.blue.ordinal());//����Ԫ�صı��
		
		//ö������ʵ����comparable�ӿ�
		System.out.println(Color.red.compareTo(Color.blue));
		
		Color.red.fun();
	}
}

//ö������
enum Color {
	red,
	blue,
	yellow;
	
	public void fun() {
		System.out.println("ö�ٵķ���");
	}
}
/*
***************JDK1.8���н��****************
1
-1
ö�ٵķ���
*/
