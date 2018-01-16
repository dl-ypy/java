import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * date:2017��5��23��17:14:12
 * target:Class����
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
		
		Class[] faces = c.getInterfaces();//�õ��ӿ�
		for (int i=0; i<faces.length; i++) {
			printInfo(faces[i]);
		}
		
		Class cy = c.getSuperclass();//�õ�����
		Object o = null;
		o = cy.newInstance();
		printInfo(o.getClass());
	}
	
	static void printInfo(Class cc) {
		System.out.println("������" + cc.getName() + " �ӿڣ�[" + cc.isInterface() + "]");
	}
}
/*
 *************** jdk1.8���н��*************** 
������dao.FancyToy �ӿڣ�[false]
������dao.HasBatteries �ӿڣ�[true]
������dao.Waterproof �ӿڣ�[true]
������dao.ShootsThings �ӿڣ�[true]
������dao.Toy �ӿڣ�[false]
 */
