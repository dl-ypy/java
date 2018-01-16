import Parcel.M;

/**
 * date:2017年4月18日17:22:34 
 * target:内部类初解。
 * @author ypy
 * knowledge:
 *     内部类生成的.class文件的名称：外部类$内部类.class
 * conclusion:
 *     为什么使用内部类？
 *         1.内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。
		   2.在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。
		   3.创建内部类对象的时刻并不依赖于外围类对象的创建。
		   4.内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。
		   5.内部类提供了更好的封装，除了该外围类，其他类都不能访问
		   6.控制框架。
 */
class Parcel {
	private int i = 100;
	private static int m = 200;
	//非静态内部类
	//非静态类中不能有静态成员，但可以访问外部类的静态成员
	protected class Destination {//protected允许在同一包下的其他类进行访问，private则只允许该内部类的外部类进行访问
		private String label;
		//public static int n = 5;
		Destination(String label) {
			this.label = label;
			//非静态内部类隐含有一个外部类的指针this,（this表示对外部类的引用）可以直接访问外部类的成员，包括私有。
			System.out.println("Destination construction!" + i);
		}

		String readLabel() {
			return label;
		}
	}
	
	//静态内部类
	//常用于代码的测试
	//静态内部类不能访问外部类的非静态成员，因为静态内部类在外部类加载时就会初始化
	public static class M {
		private static int n = 200;
		public void print() {
			System.out.println(n+m);//静态内部类不再包含外部类的this指针，并且在外部类装载时初始化,只允许使用外部类的静态属性
		}
		
		public static void sPrint() {
			System.out.println(n+m);
		}
	}

	//初始化内部类Destination
	public Destination instance(String s) {
		return new Destination(s);
	}

	//在类内部初始化内部类
	public void ship(String dest) {
		Destination d = instance(dest);
		System.out.println("目标标题：" + d.readLabel());
	}
}

public class NeiBuLei_1{
	public static void main(String[] args) {
		Parcel p = new Parcel();
		p.ship("Tanzania");
		//在类外部初始化内部类
		//外部类要访问内部类的成员，必须创建对象。
		//非静态内部类的实例一定要绑定在外部类的实例中。即在创建内部类之前要先在外部类 中要利用new关键字来创建这个内部类的对象。
		Parcel q = new Parcel();
		Parcel.Destination d = q.instance("Borneo");
		System.out.println("目标标题：" + d.readLabel());
		//静态内部类的实例不需要绑定在外部类的实例中，即在创建静态类内部类对象时，不需要其外部类的对象。
		M m = new M();
		m.print();
		Parcel.M.sPrint();
	}
}
/*
 *************** jdk1.8运行结果*************** 
Destination construction!100
目标标题：Tanzania
Destination construction!100
目标标题：Borneo
400
400
 */
