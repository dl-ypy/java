/**
 * date:2017��6��11��10:33:32
 * target:super.getClass()������
 * @author ypy
 */
class A {
	public void m1() {
		System.out.println(super.getClass().getName());//�ȼ���getClass().getName()
													   //��ΪObject���е�getClass()����Ϊfinal�����಻�ܸ���
													   //���������е��õ�getClass()������ʵ���ǵ��õĸ����е�getClass()����
	}
	public void m2() {
		System.out.println(getClass().getSuperclass().getName());//�˷������ܷ��ظ���
	}
}
public class Super_getClass {
	public static void main(String[] args) {
		A a = new A();
		a.m1();
		a.m2();
	}
}
/*
 *************** jdk1.8���н��***************
dao.A
java.lang.Object
 */
