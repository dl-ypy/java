package javaTest;

/**
 * data:2018年1月12日14点34分
 * @author joker
 * 适配器模式
 * 适配器模式分两种，类适配器和对象适配器。
 * 1、目标角色
 * 这是所期待得到的接口
 * 2、源角色
 * 现在需要适配的接口
 * 3、适配器角色
 * 模式的核心，适配器把源接口转换成目标接口
 */
public class Test{
	public static void main(String[] args) {
		//类适配器
		ClassAdapter a = new ClassAdapter();
		a.m1();
		a.m2();
		
		//对象适配器
		Adaptee adaptee = new Adaptee();
		ObjectAdapter o = new ObjectAdapter(adaptee);
		o.m1();
		o.m2();
	}
}

/*目标角色*/
interface Target {
	/*源角色有的方法*/
	void m1();
	/*源角色没有的方法*/
	void m2();
}

/*源角色*/
class Adaptee {
	public void m1() {
		System.out.println("m1方法");
	}
}

/*类适配器角色*/
class ClassAdapter extends Adaptee implements Target {
	@Override
	public void m2() {
		System.out.println("m2方法");
	}
}

/*对象适配器角色*/
class ObjectAdapter {
	private Adaptee adaptee;
	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	public void m1() {
		this.adaptee.m1();
	}
	
	public void m2() {
		System.out.println("m2方法");
	}
}
/**
 * JDK1.8运行结果
 * m1方法
 * m2方法
 * m1方法
 * m2方法 
*/