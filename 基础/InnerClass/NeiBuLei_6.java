/**
 * date:2017��7��1��17:32:54
 * target:�ڲ����з������ò�ͬ������ı�����
 * @author ypy
 */
public class NeiBuLei_6 {
	public static void main(String[] args) {
		//��ʼ����̬�ڲ���
		A.Inner inner = new A.Inner();
		inner.fun();
		
		//��ʼ���Ǿ�̬�ڲ���
		A.Inner2 inner2 = new A().new Inner2();
		inner2.fun();
	}
}

class A {
	private static int n = 3;
	private int m = 100;
	
	static class Inner {
		int n = 5;
		public void fun() {
			int n = 1;
			System.out.println("�ڲ��෽���е�n:" + n);
			System.out.println("�ڲ����е�n:" + this.n);
			System.out.println("�ⲿ���еľ�̬����n:" + A.n);
		}
	}
	
	class Inner2 {
		public void fun() {
			System.out.println("�ⲿ���еķǾ�̬����m:" + A.this.m);
		}
		
	}
}
/*
***************JDK1.8���н��****************
�ڲ��෽���е�n:1
�ڲ����е�n:5
�ⲿ���еľ�̬����n:3
�ⲿ���еķǾ�̬����m:100
*/
