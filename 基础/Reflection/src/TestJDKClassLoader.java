//JDK内置ClassLoader
public class TestJDKClassLoader {

	public static void main(String[] args) {
		System.out.println(String.class.getClassLoader());//核心类
		System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());//自己定义的类
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());//系统类
		
		System.out.println("--------------------");
		
		//打印出parents   注意：不是继承！！！！！！
		//加载过程，首先找上一级的ClassLoader是否加载，如果加载了，就不再重复加载
		ClassLoader c = TestJDKClassLoader.class.getClassLoader();
		while (null != c){
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}

}
/*
***************JDK1.8运行结果***************
null
sun.misc.Launcher$AppClassLoader
sun.misc.Launcher$AppClassLoader
--------------------
sun.misc.Launcher$AppClassLoader
sun.misc.Launcher$ExtClassLoader
*/