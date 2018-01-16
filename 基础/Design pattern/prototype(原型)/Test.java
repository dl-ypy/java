/**
 * 原型模式
 * date:2017年11月17日20:36:04
 * @author ypy
 * 角色：客户角色、抽象原型角色、具体原型角色
 * 概念：
 *     原型模式属于对象的创建模式，通过给出一个原型对象来指明所有创建的对象的类型，
 *     然后用复制这个原型对象的办法创建出更多同类型的对象。
 * 优点：
 *     使用原型模式创建对象比直接new一个对象在性能上好得多，因为Object类的clone()方法是一个native方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
 *     使用原型模式的另一个好处是简化对象的创建，使得创建对象就像普通的复制黏贴一样简单。
 */
abstract class Prototype implements Cloneable {  //抽象原型角色，实现了Cloneable接口
	@Override
	protected Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}

class ConcretePrototype extends Prototype {   //具体原型角色
	public void show() {
		System.out.println("具体原型角色");
	}
} 

public class Test {   //客户角色，进行调用
	public static void main(String[] args) {
		ConcretePrototype cp = new ConcretePrototype();
		for (int i=0; i<10; i++) {
			ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
			clonecp.show();
		}
	}
}
