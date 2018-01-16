import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * date:2017��5��23��16:31:24
 * target:instanceof��ʹ�á�
 * @author ypy
 */
class Pet {}
class Dog extends Pet {}
class Pug extends Dog {}
class Cat extends Pet {}
class Rodent extends Pet {}
class Gerbil extends Rodent {}
class Hamster extends Rodent {}

//������
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
			int rnd = (int) (1 + Math.random()*(petTypes.length-1));//random�������һ��С��1����������(petTypes.length-1)�󣬲���һ��С��(petTypes.length-1)�������ټ�1������һ��С��petTypes.length����
			pets.addElement(petTypes[rnd].newInstance());//��petTypes���������new��һ����Ķ���
		}
		
		Hashtable h = new Hashtable<>();
		for (int i=0; i<petTypes.length; i++) {
			h.put(petTypes[i].toString(), new Counter());//��petTypes�����е�ÿ��Ԫ�ص�toString�������ص��ַ�������Hashtable��������һ��Counter�������ڼ���
		}
		for (int i=0; i<pets.size(); i++) {
			Object o = pets.elementAt(i);
			//ͨ��ȡ��Hashtable�з��õ�toString�������ص��ַ����жϸö��������ĸ��࣬��Ϊ�����
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
			
			//��̬�� instanceof
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
			System.out.println(nm.substring(nm.lastIndexOf('.')+1) + "����:" + cnt.i);//substring���شӵڲ������ַ���ʼ�����ַ���ĩβ�����ַ�������0��ʼ��
																					 //lastIndexOf����ָ���ַ��ڴ��ַ��������һ�γ��ִ�������
		}
	}
}
/*
 *************** jdk1.8���н��*************** 
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
Gerbil����:1
Hamster����:4
Rodent����:7
Cat����:0
Pet����:15
Pug����:6
Dog����:8
 */
