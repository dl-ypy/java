/**
 * date:2017��5��25��10:21:44
 * target:clone����¡֮��¡�ϳɶ���
 * @author ypy
 */
//A��ĳ�Ա�������ǻ�����������
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
			System.out.println("A���ܿ�¡��");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return "A " + i;
	}
}

//B��ĳ�Ա�������ǻ�����������
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
			System.out.println("B���ܿ�¡��");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return "B " + time;
	}
}

//C��ĳ�Ա������A��B��Ķ���
//Ϊ�˶��������㸴�ƣ�clone()����ͬʱ��¡C�ڵľ����
//Ϊ�ﵽ���Ŀ�꣬super.clone()�Ľ���������ͳ�һ��C�����Ա����a��b�������
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
			System.out.println("C���ܿ�¡��");
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
		System.out.println("ԭʼ���ݣ�" + c);
		System.out.println("��¡���ݣ�" + c1);
	}
}
/*
 *************** jdk1.8���н��*************** 
ԭʼ���ݣ�A 5    B 1495681712912
��¡���ݣ�A 6    B 1495681712912
 */
