package dao;
/**
 * date:2017年4月15日18:15:16
 * target:static的初始化以及static块。
 * @author ypy
 * conclusion:static块中的代码只执行一次。
 * 			  初始化：当创建第一个该类的对象，或者第一次调用该类中的static属性或方法时，
 * 				  会初始化该类中所有的static属性，方法或static块，否则永远都不会初始化。
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
 ***************jdk1.8运行结果*************** 
 aaaaa
 */
