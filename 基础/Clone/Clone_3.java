import java.util.Enumeration;
import java.util.Vector;

/**
 * date:2017年5月25日11:14:06
 * target:clone深层克隆之用 Vector进行深层复制。
 * @author ypy
 * conclusion:
 *     对克隆后的对象进行一些操作，使得克隆前后的数值不同。
 */
class A implements Cloneable {
	int i;
	public A(int i) {
		this.i = i;
	}
	
	public void increment() {
		this.i++;
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
		return Integer.toString(i);
	}
}

//B继承了A，并添加一个新成员j，并且不需要再次覆盖 clone()以确保j得到复制。
//将A的clone()当作B的clone()调用时，它会调用Object.clone()，判断出当前操作的是B，并复制B内的所有二进制位。
//只要没有新增需要克隆的句柄，对Object.clone()的一个调用就能完成所有必要的复制——无论clone()是在层次结构多深的一级定义的。
class B extends A {
	public int j;
	public B(int i, int j) {
		super(i);
		this.j = j;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i+j);
	}
}

public class Clone_3 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		A a = new A(10);
		A a1 = (A) a.clone();
		a1.increment();//对克隆对象的i进行++
		System.out.println("a=" + a + ",a1=" + a1);
		
		B b = new B(7, 555);
		B b1 = (B) b.clone();
		b1.j++;//对b克隆后的对象的j进行++
		System.out.println("b=" + b + ",b1=" + b1);
		
		b = (B) b.clone();
		
		Vector v = new Vector<>();
		for (int i=0; i<10; i++) {
			v.addElement(new A(i));
		}
		System.out.println("v:" + v);
		
		Vector v1 = (Vector) v.clone();//克隆Vector
		//克隆Vector中的每个元素，否则后面执行i++的句柄就会别名为原始句柄
		for (int i=0; i<v.size(); i++) {
			v1.setElementAt(((A)v1.elementAt(i)).clone(), i);
		}
		
		for (Enumeration e=v1.elements(); e.hasMoreElements(); ) {//对克隆的进行i++
			((A)e.nextElement()).increment();
		}
		System.out.println("v1:" + v1);
	}
}
/*
 *************** jdk1.8运行结果*************** 
a=10,a1=11
b=562,b1=563
v:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
v1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
