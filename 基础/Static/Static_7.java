package dao;
/**
 * date:2017��4��15��18:15:16
 * target:static�ĳ�ʼ���Լ�static�顣
 * @author ypy
 * conclusion:static���еĴ���ִֻ��һ�Ρ�
 * 			  ��ʼ������������һ������Ķ��󣬻��ߵ�һ�ε��ø����е�static���Ի򷽷�ʱ��
 * 				  ���ʼ�����������е�static���ԣ�������static�飬������Զ�������ʼ����
 */
 public class Static_7{
	static B b = new B();
	public static void main(String[] args) {
		B b2 = new B();
	}
}

class A {
	A() {
		System.out.println("aaaaa");
	}
}

class B {
	static A a;
	static {
		a = new A();
	}
}

/*
 ***************jdk1.8���н��*************** 
 aaaaa
 */
