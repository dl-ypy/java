import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
/**
 * date:2017年7月10日17:38:08
 * target：反射读取配置文件返回对象。
 * @author ypy
 */
public class ReflectReadProperties {
	public static void main(String[] args) throws IOException {
		try {
			loadProperties("student.properties");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void loadProperties(String fileName) throws Exception {
		InputStream ips = new FileInputStream(new File(fileName));
		Properties pro = new Properties();
		pro.load(ips);
		List<Object> arrayList = new ArrayList<>();
		//将加载到的所有内容放入set集合中
		Set<String> proSet = pro.stringPropertyNames();
		Iterator<String> it = proSet.iterator();
		//遍历该内容
		while(it.hasNext()) {
			String objString = it.next();
			arrayList.add(getInstance(pro.getProperty(objString)));
		}
		System.out.println(arrayList);
	}

	@SuppressWarnings("rawtypes")
	private static Object getInstance(String keyString) throws Exception {
		String str = keyString.substring(1,keyString.length()-1);
		String[] keyStrings = str.split(",");
		Class c = null;
		Object o = null;
		for (String e : keyStrings) {
			String key = e.substring(0,e.indexOf("="));
			String value = e.substring(e.indexOf("=")+1);
			//判断是否是class，是则创建对象
			if ("class".equals(key)) {
				c = Class.forName(value);
				o = c.newInstance();
				continue;
			}
			Field fKey = c.getDeclaredField(key);
			fKey.setAccessible(true);
			//判断属性的类型是否是int
			if ("int".equals(fKey.getType().toString())) {
				fKey.set(o, Integer.parseInt(value));
				continue;
			}
			fKey.set(o, value);
			//调用set方法设置属性
			/*Method m = c.getDeclaredMethod("set"+key.substring(0,1).toUpperCase()+key.substring(1,key.length()), String.class);
			m.invoke(o, value);*/
		}
		return o;
	}
}

abstract class MyStudent {
	private String name;
	private int age;
	public MyStudent() {
		super();
	}
	public MyStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyStudent [name=" + name + ", age=" + age + "]";
	}
}

class PStudent extends MyStudent{
	private String name;
	private int age;
	public PStudent() {
		super();
	}
	public PStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "PStudent [name=" + name + ", age=" + age + "]";
	}
}

class MStudent extends MyStudent {
	private String name;
	private int age;
	public MStudent() {
		super();
	}
	public MStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "MStudent [name=" + name + ", age=" + age + "]";
	}
}

class CStudent extends MyStudent {
	private String name;
	private int age;
	public CStudent() {
		super();
	}
	public CStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "CStudent [name=" + name + ", age=" + age + "]";
	}
}
/*
***************JDK1.8运行结果****************
[CStudent [name=d, age=4], MStudent [name=c, age=3], PStudent [name=b, age=2]]
*/
