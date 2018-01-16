/**
 * date:2017年5月25日10:21:44
 * target:clone深层克隆之克隆合成对象。
 * @author ypy
 */
//A类的成员变量都是基本数据类型
class A implements Cloneable {
	public int i;
	public A(int i) {
		this.i = i;
	}
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("A不能克隆！");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return "A " + i;
	}
}

//B类的成员变量都是基本数据类型
class B implements Cloneable {
	private long time;
	public B() {
		this.time = System.currentTimeMillis();
	}
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("B不能克隆！");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return "B " + time;
	}
}

//C类的成员变量是A、B类的对象
//为了对其进行深层复制，clone()必须同时克隆C内的句柄。
//为达到这个目标，super.clone()的结果必须造型成一个C对象（以便访问a和b句柄）。
class C implements Cloneable {
	public A a;
	private B b;
	public C(int i) {
		this.a = new A(i);
		this.b = new B();
	}
	
	@Override
	public Object clone() {
		C o = null;
		try {
			o = (C)super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("C不能克隆！");
		}
		o.a = (A) o.a.clone();
		o.b = (B) o.b.clone();
		return o;
	}
	
	@Override
	public String toString() {
		return a + "    " + b;
	}
}

public class Clone_2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		C c = new C(5);
		C c1 = (C) c.clone();
		c1.a.i++;
		System.out.println("原始数据：" + c);
		System.out.println("克隆数据：" + c1);
	}
}
/*
 *************** jdk1.8运行结果*************** 
原始数据：A 5    B 1495681712912
克隆数据：A 6    B 1495681712912
 */
