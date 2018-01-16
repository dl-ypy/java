/**
 * date:2017年6月30日11:04:25
 * target:单例模式
 * @author ypy
 */
public class SingleTon {
	public static void main(String[] args) {
		SingleTon1 s = SingleTon1.getInstance();
		System.out.println(s);
		SingleTon1 s1 = SingleTon1.getInstance();
		System.out.println(s1);
		SingleTon2 s2 = SingleTon2.getInstance();
		System.out.println(s2);
		SingleTon2 s3 = SingleTon2.getInstance();
		System.out.println(s3);
	}
}

//饿汉模式  类加载时就创建对象  不能在构造方法中传递参数
class SingleTon1 {
	private static final SingleTon1 instance = new SingleTon1();
	
	private SingleTon1() {
		
	}
	
	public static SingleTon1 getInstance() {
		return instance;
	}
}

//懒汉模式  只在外部对象第一次请求实例的时候才去创建。
class SingleTon2 {
	private SingleTon2() {
		
	}
	
	private static SingleTon2 instance = null;
	
	public static SingleTon2 getInstance() {  //可加synchronized，加上就为线程安全的，但效率低
		if (instance == null) {
			instance = new SingleTon2();
		}
		return instance;
	}
}


/*
***************JDK1.8运行结果****************
SingleTon1@15db9742
SingleTon1@15db9742
SingleTon2@6d06d69c
SingleTon2@6d06d69c
*/
