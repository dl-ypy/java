/**
 * date:2017年7月1日17:32:54
 * target:内部类中方法调用不同作用域的变量。
 * @author ypy
 */
public class NeiBuLei_6 {
	public static void main(String[] args) {
		//初始化静态内部类
		A.Inner inner = new A.Inner();
		inner.fun();
		
		//初始化非静态内部类
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
			System.out.println("内部类方法中的n:" + n);
			System.out.println("内部类中的n:" + this.n);
			System.out.println("外部类中的静态属性n:" + A.n);
		}
	}
	
	class Inner2 {
		public void fun() {
			System.out.println("外部类中的非静态属性m:" + A.this.m);
		}
		
	}
}
/*
***************JDK1.8运行结果****************
内部类方法中的n:1
内部类中的n:5
外部类中的静态属性n:3
外部类中的非静态属性m:100
*/
