import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * date:2017年7月10日11:08:25
 * target:通过反射加载类，创建对象，设置属性，修改属性，调用方法。
 * conclusion：封装性对反射毫无用处，在类已经进行封装的情况下，通过反射可以任意修改。
 * @author ypy
 */
public class Test {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		try {
			//第一种加载类方法
			//Class c = Pet.class;
			//第二种加载类方法
			//Class c = new Pet("a", 22).getClass();
			
			//第三种加载类方法，常用   必须是全名，要包括包名
			Class c = Class.forName("Pet");
			//得到构造方法，参数为有参构造方法中属性类型的class
			Constructor con = c.getConstructor(String.class, int.class);
			//创建对象
			Pet p = (Pet) con.newInstance("阿浩", 15);
			System.out.println(p);
			
			//修改属性
			//得到想要修改的属性，参数为属性名
			Field name = c.getDeclaredField("name");
			//设置权限
			name.setAccessible(true);
			//修改属性，第一个参数为要修改的对象，第二个参数为要修改的值
			name.set(p, "阿浩2");
			System.out.println(p);
			
			//调用方法
			//方法名，  参数类型的class
			Method m = c.getDeclaredMethod("eat", String.class);
			m.invoke(p, "狗粮");
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
		System.out.println("吃" + food);
	}
}
/*
***************JDK1.8运行结果****************
Pet [name=阿浩, age=15]
Pet [name=阿浩2, age=15]
吃狗粮
*/
