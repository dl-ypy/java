import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * date:2017��7��10��11:08:25
 * target:ͨ����������࣬���������������ԣ��޸����ԣ����÷�����
 * conclusion����װ�ԶԷ�������ô��������Ѿ����з�װ������£�ͨ��������������޸ġ�
 * @author ypy
 */
public class Test {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		try {
			//��һ�ּ����෽��
			//Class c = Pet.class;
			//�ڶ��ּ����෽��
			//Class c = new Pet("a", 22).getClass();
			
			//�����ּ����෽��������   ������ȫ����Ҫ��������
			Class c = Class.forName("Pet");
			//�õ����췽��������Ϊ�вι��췽�����������͵�class
			Constructor con = c.getConstructor(String.class, int.class);
			//��������
			Pet p = (Pet) con.newInstance("����", 15);
			System.out.println(p);
			
			//�޸�����
			//�õ���Ҫ�޸ĵ����ԣ�����Ϊ������
			Field name = c.getDeclaredField("name");
			//����Ȩ��
			name.setAccessible(true);
			//�޸����ԣ���һ������ΪҪ�޸ĵĶ��󣬵ڶ�������ΪҪ�޸ĵ�ֵ
			name.set(p, "����2");
			System.out.println(p);
			
			//���÷���
			//��������  �������͵�class
			Method m = c.getDeclaredMethod("eat", String.class);
			m.invoke(p, "����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}

class Pet {
	private String name;
	private int age;
	public Pet() {
		super();
	}
	public Pet(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + "]";
	}
	
	public void eat(String food) {
		System.out.println("��" + food);
	}
}
/*
***************JDK1.8���н��****************
Pet [name=����, age=15]
Pet [name=����2, age=15]
�Թ���
*/
