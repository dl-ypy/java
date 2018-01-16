/**
 * date:2017年4月19日16:40:29 
 * target:内部类的继承。
 * @author ypy
 */
class WithInner {
	class Inner {
		protected void m() {
			System.out.println("被继承了！");
		}
	}
}

class A extends WithInner.Inner {//继承了内部类
	A(WithInner wi) {//构造方法必须这么写
		wi.super();
	}
}

public class NeiBuLei_5 {

	public static void main(String[] args) {
		WithInner wi = new WithInner();
		A a = new A(wi);
		a.m();
	}
}
/*
 *************** jdk1.8运行结果*************** 
被继承了！
 */
