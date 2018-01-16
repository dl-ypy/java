import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * date:2017年5月23日17:14:12
 * target:Class对象。
 * @author ypy
 */
interface HasBatteries {}
interface Waterproof {}
interface ShootsThings {}

class Toy {
	Toy() {}
	Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries,Waterproof, ShootsThings {
	FancyToy() { super(1); }
}

public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class c = null;
		try {
			c = Class.forName("dao.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		printInfo(c);
		
		Class[] faces = c.getInterfaces();//得到接口
		for (int i=0; i<faces.length; i++) {
			printInfo(faces[i]);
		}
		
		Class cy = c.getSuperclass();//得到基类
		Object o = null;
		o = cy.newInstance();
		printInfo(o.getClass());
	}
	
	static void printInfo(Class cc) {
		System.out.println("类名：" + cc.getName() + " 接口？[" + cc.isInterface() + "]");
	}
}
/*
 *************** jdk1.8运行结果*************** 
类名：dao.FancyToy 接口？[false]
类名：dao.HasBatteries 接口？[true]
类名：dao.Waterproof 接口？[true]
类名：dao.ShootsThings 接口？[true]
类名：dao.Toy 接口？[false]
 */
