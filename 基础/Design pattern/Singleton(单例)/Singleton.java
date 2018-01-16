package dao;


/**
 * date:2017年6月9日09:21:38
 * target:单例模式。
 * @author ypy
 * conclusion：
 *     单例模式的关键就是为了防止客户程序员通过其他方式创建对象。
 *     优点：控制资源的使用，通过线程同步来控制资源的并发访问
 *     		控制实例的产生，以达到节约资源的目的
 *     		控制数据的共享，在不建立直接关联的条件下，让多个不相关的进程或线程之间实现通信
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

//饿汉式   注：此写法不会引发线程安全问题
//			  如：CPU执行线程A，实例化一个b，没有实例化完，CPU就从线程A切换到线程B了，
//			  	  线程B此时也实例化这个b，然后b被实例化出来了两次，有两份内存地址。
//			  不会引发线程安全的原因：虚拟机采用了CAS配上失败重试的方式保证更新操作的原子性和TLAB两种方式来解决这个问题
class B {
	private static B instance = new B();
	private B() {

	}
	public static B getInstance() {
		return instance;
	}
}

//懒汉式     线程不安全，可能会得到多个实例
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

//双检索  即懒汉模式加上锁
class D {
	private static D instance = null;
	private D() {

	}
	public static D getInstance() {
		if (instance == null) {
			synchronized (D.class) {   //只在第一次创建的时候加上锁，不会太多的影响性能
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
		
		//可通过get、set方法对创建的对象进行数据的操作
		A s2 = A.getInstance();
		s2.setValue(10);
		System.out.println(s2.getValue());
		
		//Singleton s3 = (Singleton)s2.clone();  因为设置为final的，所以不能通过clone来得到一个克隆对象
	}
}
/*
 *************** jdk1.8运行结果***************
50
10
 */
