/**
 * date:2017��7��3��09:43:55
 * target:���͡�
 * conclusion:�ڶ�����ʱ������֪������Ҫ����ʲô���͵����ԣ���ʱʹ�÷��͡�
 * @author ypy
 */
public class NormalForm_01 {
	public static void main(String[] args) {
		Person<Dog, Meet> p = new Person<Dog, Meet>(new Dog[]{new Dog("����1"),new Dog("����2")}, new Meet());
		p.printInfo();
		p.fasterCare(new Cat[]{new Cat("è1"),new Cat("è2")});
	}
}

class Dog {
	private String name;

	public Dog(String name) {
		super();
		this.name = name;
	}

	public Dog() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
}

class Meet {

	@Override
	public String toString() {
		return "��";
	}
	
}

class Cat {
	private String name;

	public Cat(String name) {
		super();
		this.name = name;
	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
}

//T��ʾ�������ͣ�V��ʾιʳ�ó����ʳ��
class Person<T, V> {
	private T[] t;
	private V v;
	
	public Person(T[] t, V v) {
		super();
		this.t = t;
		this.v = v;
	}
	
	//����ʹ��һ�����͵ķ��������ڶ������ʱ��ʹ��
	//��Ϊ����ֻ����ʱ�ģ������ж���̫�˷�
	public <M> void fasterCare (M[] m) {
		for (int i=0; i<m.length; i++) {
			System.out.println(m[i]);
		}
	}
	
	public void printInfo()  {
		for (int i=0; i<t.length; i++) {
			System.out.println(t[i] + "ιʳ:" + v);
		}
	}
}
/*
***************JDK1.8���н��****************
Dog [name=����1]ιʳ:��
Dog [name=����2]ιʳ:��
Cat [name=è1]
Cat [name=è2]
*/
