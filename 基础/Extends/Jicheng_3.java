/**
 * date:2017年4月16日16:10:39
 * target:继承时，父类对象的初始化。
 * @author ypy
 * conclusion:继承发生时，就在子类中封装了一个父类对象，为了正确初始化父类对象，
 * 			     只能在构造方法中对其初始化。
 * 			     如果父类的构造方法为默认的构造方法，子类中默认的构造方法就会自动的发出对父类构造方法的调用。
 * 			     如果父类的构造方法含有参数，子类中就必须自己写构造方法，而且用super调用父类的构造方法。
 */
public class Jicheng_3{
	public static void main(String[] args) {
		new B(5);
	}
}

class A {
	A(int i) {
		System.out.println("父类有参构造方法！");
	}
}

class B extends A {
	B(int i) {
		super(i);
		System.out.println("子类有参构造方法！");
	}
	
}
/*
 ***************jdk1.8运行结果*************** 
父类有参构造方法！
子类有参构造方法！
 */