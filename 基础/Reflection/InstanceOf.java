import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * date:2017年5月23日16:31:24
 * target:instanceof的使用。
 * @author ypy
 */
class Pet {}
class Dog extends Pet {}
class Pug extends Dog {}
class Cat extends Pet {}
class Rodent extends Pet {}
class Gerbil extends Rodent {}
class Hamster extends Rodent {}

//计数类
class Counter { int i; }

public class InstanceOf {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Vector pets = new Vector();
		Class[] petTypes = {
				Pet.class,
				Dog.class,
				Pug.class,
				Cat.class,
				Rodent.class,
				Gerbil.class,
				Hamster.class,
		};
		
		for (int i=0; i<15; i++) {
			int rnd = (int) (1 + Math.random()*(petTypes.length-1));//random随机产生一个小于1的数，乘以(petTypes.length-1)后，产生一个小于(petTypes.length-1)的数，再加1，产生一个小于petTypes.length的数
			pets.addElement(petTypes[rnd].newInstance());//在petTypes数组中随机new出一个类的对象
		}
		
		Hashtable h = new Hashtable<>();
		for (int i=0; i<petTypes.length; i++) {
			h.put(petTypes[i].toString(), new Counter());//将petTypes数组中的每个元素的toString方法返回的字符串放入Hashtable，并给其一个Counter对象，用于计数
		}
		for (int i=0; i<pets.size(); i++) {
			Object o = pets.elementAt(i);
			//通过取出Hashtable中放置的toString方法返回的字符串判断该对象属于哪个类，并为其计数
			/*if (o instanceof Pet)
				((Counter)h.get("class dao.Pet")).i++;
			if(o instanceof Dog)
				((Counter)h.get("class dao.Dog")).i++;
			if(o instanceof Pug)
				((Counter)h.get("class dao.Pug")).i++;
			if(o instanceof Cat)
				((Counter)h.get("class dao.Cat")).i++;
			if(o instanceof Rodent)
				((Counter)h.get("class dao.Rodent")).i++;
			if(o instanceof Gerbil)
				((Counter)h.get("class dao.Gerbil")).i++;
			if(o instanceof Hamster)
				((Counter)h.get("class dao.Hamster")).i++;*/
			
			//动态的 instanceof
			for (int j = 0; j < petTypes.length; j++) {
				if (petTypes[j].isInstance(o)) {
					String key = petTypes[j].toString();
					((Counter)h.get(key)).i++;
				}
			}
		}
		
		for (int i=0; i<pets.size(); i++) {
			System.out.println(pets.elementAt(i).getClass().toString());
		}
		Enumeration keys = h.keys();
		while (keys.hasMoreElements()) {
			String nm = (String) keys.nextElement();
			Counter cnt = (Counter) h.get(nm);
			System.out.println(nm.substring(nm.lastIndexOf('.')+1) + "数量:" + cnt.i);//substring返回从第参数个字符开始到此字符串末尾的子字符串（从0开始）
																					 //lastIndexOf返回指定字符在此字符串中最后一次出现处的索引
		}
	}
}
/*
 *************** jdk1.8运行结果*************** 
class dao.Pug
class dao.Dog
class dao.Hamster
class dao.Hamster
class dao.Gerbil
class dao.Rodent
class dao.Pug
class dao.Pug
class dao.Dog
class dao.Pug
class dao.Pug
class dao.Pug
class dao.Rodent
class dao.Hamster
class dao.Hamster
Gerbil数量:1
Hamster数量:4
Rodent数量:7
Cat数量:0
Pet数量:15
Pug数量:6
Dog数量:8
 */
