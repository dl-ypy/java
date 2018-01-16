package dao;


/**
 * date:2017��6��9��09:21:38
 * target:����ģʽ��
 * @author ypy
 * conclusion��
 *     ����ģʽ�Ĺؼ�����Ϊ�˷�ֹ�ͻ�����Աͨ��������ʽ��������
 *     �ŵ㣺������Դ��ʹ�ã�ͨ���߳�ͬ����������Դ�Ĳ�������
 *     		����ʵ���Ĳ������Դﵽ��Լ��Դ��Ŀ��
 *     		�������ݵĹ����ڲ�����ֱ�ӹ����������£��ö������صĽ��̻��߳�֮��ʵ��ͨ��
 */
final class A {
	private int i;
	private  static A s = new A(50);
	public A(int i) {
		this.i = i;
	}
	public static A getInstance() {
		return s;
	}
	public void setValue(int i) {
		this.i = i;
	}
	public int getValue() {
		return i;
	}
} 

//����ʽ   ע����д�����������̰߳�ȫ����
//			  �磺CPUִ���߳�A��ʵ����һ��b��û��ʵ�����꣬CPU�ʹ��߳�A�л����߳�B�ˣ�
//			  	  �߳�B��ʱҲʵ�������b��Ȼ��b��ʵ�������������Σ��������ڴ��ַ��
//			  ���������̰߳�ȫ��ԭ�������������CAS����ʧ�����Եķ�ʽ��֤���²�����ԭ���Ժ�TLAB���ַ�ʽ������������
class B {
	private static B instance = new B();
	private B() {

	}
	public static B getInstance() {
		return instance;
	}
}

//����ʽ     �̲߳���ȫ�����ܻ�õ����ʵ��
class C {
	private static C instance = null;
	private C() {

	}
	public static C getInstance() {
		if (instance == null) {
			instance = new C();
		}
		return instance;
	}
}

//˫����  ������ģʽ������
class D {
	private static D instance = null;
	private D() {

	}
	public static D getInstance() {
		if (instance == null) {
			synchronized (D.class) {   //ֻ�ڵ�һ�δ�����ʱ�������������̫���Ӱ������
				if (instance == null) {

				}
			}
		}
	}
}

public class Singleton{
	public static void main(String[] args) {
		A s1 = A.getInstance();
		System.out.println(s1.getValue());
		
		//��ͨ��get��set�����Դ����Ķ���������ݵĲ���
		A s2 = A.getInstance();
		s2.setValue(10);
		System.out.println(s2.getValue());
		
		//Singleton s3 = (Singleton)s2.clone();  ��Ϊ����Ϊfinal�ģ����Բ���ͨ��clone���õ�һ����¡����
	}
}
/*
 *************** jdk1.8���н��***************
50
10
 */
