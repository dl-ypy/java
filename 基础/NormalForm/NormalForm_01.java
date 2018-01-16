/**
 * date:2017年7月3日09:43:55
 * target:泛型。
 * conclusion:在定义类时，并不知道类中要创建什么类型的属性，这时使用泛型。
 * @author ypy
 */
public class NormalForm_01 {
	public static void main(String[] args) {
		Person<Dog, Meet> p = new Person<Dog, Meet>(new Dog[]{new Dog("阿浩1"),new Dog("阿浩2")}, new Meet());
		p.printInfo();
		p.fasterCare(new Cat[]{new Cat("猫1"),new Cat("猫2")});
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
		return "肉";
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

//T表示宠物类型，V表示喂食该宠物的食物
class Person<T, V> {
	private T[] t;
	private V v;
	
	public Person(T[] t, V v) {
		super();
		this.t = t;
		this.v = v;
	}
	
	//寄养使用一个泛型的方法，不在定义类的时候使用
	//因为寄养只是临时的，在类中定义太浪费
	public <M> void fasterCare (M[] m) {
		for (int i=0; i<m.length; i++) {
			System.out.println(m[i]);
		}
	}
	
	public void printInfo()  {
		for (int i=0; i<t.length; i++) {
			System.out.println(t[i] + "喂食:" + v);
		}
	}
}
/*
***************JDK1.8运行结果****************
Dog [name=阿浩1]喂食:肉
Dog [name=阿浩2]喂食:肉
Cat [name=猫1]
Cat [name=猫2]
*/
