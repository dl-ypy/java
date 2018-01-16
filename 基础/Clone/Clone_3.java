import java.util.Enumeration;
import java.util.Vector;

/**
 * date:2017��5��25��11:14:06
 * target:clone����¡֮�� Vector������㸴�ơ�
 * @author ypy
 * conclusion:
 *     �Կ�¡��Ķ������һЩ������ʹ�ÿ�¡ǰ�����ֵ��ͬ��
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
			System.out.println("A���ܿ�¡��");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

//B�̳���A�������һ���³�Աj�����Ҳ���Ҫ�ٴθ��� clone()��ȷ��j�õ����ơ�
//��A��clone()����B��clone()����ʱ���������Object.clone()���жϳ���ǰ��������B��������B�ڵ����ж�����λ��
//ֻҪû��������Ҫ��¡�ľ������Object.clone()��һ�����þ���������б�Ҫ�ĸ��ơ�������clone()���ڲ�νṹ�����һ������ġ�
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
		a1.increment();//�Կ�¡�����i����++
		System.out.println("a=" + a + ",a1=" + a1);
		
		B b = new B(7, 555);
		B b1 = (B) b.clone();
		b1.j++;//��b��¡��Ķ����j����++
		System.out.println("b=" + b + ",b1=" + b1);
		
		b = (B) b.clone();
		
		Vector v = new Vector<>();
		for (int i=0; i<10; i++) {
			v.addElement(new A(i));
		}
		System.out.println("v:" + v);
		
		Vector v1 = (Vector) v.clone();//��¡Vector
		//��¡Vector�е�ÿ��Ԫ�أ��������ִ��i++�ľ���ͻ����Ϊԭʼ���
		for (int i=0; i<v.size(); i++) {
			v1.setElementAt(((A)v1.elementAt(i)).clone(), i);
		}
		
		for (Enumeration e=v1.elements(); e.hasMoreElements(); ) {//�Կ�¡�Ľ���i++
			((A)e.nextElement()).increment();
		}
		System.out.println("v1:" + v1);
	}
}
/*
 *************** jdk1.8���н��*************** 
a=10,a1=11
b=562,b1=563
v:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
v1:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
