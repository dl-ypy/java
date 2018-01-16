/**
 * date:2017年7月3日15:23:59
 * target:模块。
 * @author ypy
 */
public class Block{
	public static void main(String[] args) {
		A a = new A();
	}
}

class A {
	public A() {
		System.out.println("构造方法");
	}
	
	{
		System.out.println("构造块");
	}
	
	static {
		System.out.println("静态块");
	}
}
/*
***************JDK1.8运行结果****************
静态块
构造块
构造方法
*/
