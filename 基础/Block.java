/**
 * date:2017��7��3��15:23:59
 * target:ģ�顣
 * @author ypy
 */
public class Block{
	public static void main(String[] args) {
		A a = new A();
	}
}

class A {
	public A() {
		System.out.println("���췽��");
	}
	
	{
		System.out.println("�����");
	}
	
	static {
		System.out.println("��̬��");
	}
}
/*
***************JDK1.8���н��****************
��̬��
�����
���췽��
*/
