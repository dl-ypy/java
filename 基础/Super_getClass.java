/**
 * date:2017年6月11日10:33:32
 * target:super.getClass()方法。
 * @author ypy
 */
class A {
	public void m1() {
		System.out.println(super.getClass().getName());//等价于getClass().getName()
													   //因为Object类中的getClass()定义为final，子类不能覆盖
													   //所以子类中调用的getClass()方法其实就是调用的父类中的getClass()方法
	}
	public void m2() {
		System.out.println(getClass().getSuperclass().getName());//此方法才能返回父类
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
 *************** jdk1.8运行结果***************
dao.A
java.lang.Object
 */
