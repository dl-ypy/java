/**
 * date:2017年5月24日11:13:39
 * target:clone方法进行浅层克隆。
 * @author ypy
 * conclusion:
 *     Java 中的所有自变量或参数传递都是通过传递句柄进行的。
 *     Object.clone()正式开始操作前，首先会检查一个类是否Cloneable，即是否具有克隆能力。
 *     然后Object.clone()会检查原先的对象有多大，再为新对象腾出足够多的内存，将所有二进制位从原来的对象复制到新对象。这叫作“按位复制”。
 *     “深层复制”需要为对象内每个引用类型都进行复制。
 */
class A implements Cloneable {//实现Cloneable接口表示可以被克隆
	int i;
	public A(int i) {
		this.i = i;
	}
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();//基础类中的clone方法是protected的，能在子类中调用
		} catch (CloneNotSupportedException e) {
			System.out.println("不能克隆！");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

public class Clone_1 {
	public static A g(A a) {//不克隆进行++
		a.i++;
		return a;
	}
	public static A f(A a) {//克隆后进行++，执行++的只是克隆后的对象
		a = (A) a.clone();
		a.i++;
		return a;
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		A a = new A(11);
		A b = g(a);
		
		if (a == b) {//a==b，并且都进行了++
			System.out.println("a==b");
		} else {
			System.out.println("a!=b");
		}
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		A a1 = new A(55);
		A b1 = f(a1);
		
		if (a1 == b1) {//a1!=b1，只对克隆后的对象进行了++
			System.out.println("a1==b1");
		} else {
			System.out.println("a1!=b1");
		}
		
		System.out.println("a1=" + a1);
		System.out.println("b1=" + b1);
	}
}
/*
 *************** jdk1.8运行结果*************** 
a==b
a=12
b=12
a1!=b1
a1=55
b1=56
 */
