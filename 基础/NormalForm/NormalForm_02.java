import java.util.ArrayList;
import java.util.Iterator;

/**
 * date:2017年7月5日10:51:32
 * target:范式2。
 * @author ypy
 */
public class NormalForm_02 {
	public static void main(String[] args) {
		ArrayList<People> list = new ArrayList<>();
		list.add(new People("阿浩1", 20));
		list.add(new People("阿浩2", 20));
		print(list);
		System.out.println("********************************");
		
		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("阿浩1", 20));
		list2.add(new Student("阿浩2", 20));
		print(list2);
		System.out.println("********************************");
		
		ArrayList<Object> list3 = new ArrayList<>();
		list3.add(new Object());
		list3.add(new Object());
		print2(list3);
	}
	
	/**
	 * ? extends People表示范式的上限是People，也就是说范式类型只能是People类或其子类
	 * @param o
	 */
	public static void print(ArrayList<? extends People> o) {
		Iterator<? extends People> it = o.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * ? super People表示范式的下限是People，也就是说范式类型只能是People类或其父类
	 * @param o
	 */
	public static void print2(ArrayList<? super People> o) {
		Iterator<? super People> it = o.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class People {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public People() {
		super();
	}
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
}

class Student extends People {

	public Student() {
		super();
	}

	public Student(String name, int age) {
		super(name, age);
	}

	@Override
	public String toString() {
		return "Student [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
	
}
/*
***************JDK1.8运行结果****************
People [name=阿浩1, age=20]
People [name=阿浩2, age=20]
********************************
Student [getName()=阿浩1, getAge()=20]
Student [getName()=阿浩2, getAge()=20]
********************************
java.lang.Object@15db9742
java.lang.Object@6d06d69c
*/
