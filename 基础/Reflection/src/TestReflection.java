import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
	//反射就是可以动态加载，好处是在配置文件中可以只写类的名字就行
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//String str = "T";//在知道类名字的前提下，只改这里的名字就能加载类
		Properties p = new Properties();//可以加载配置文件中的类
    	        p.load(Liu.class.getResourceAsStream("/test.properties"));
    		String str = p.getProperty("class");
		Class c = Class.forName(str);//动态加载类
		Object o = c.newInstance();//动态new对象
		Method[] methods = c.getMethods();//得到类中方法的数组
		
		System.out.println("---------------------------");
		for (Method m:methods){
			System.out.println(m.getName());//得到类方法的名字
		}
		System.out.println("---------------------------");
		
		for (Method m:methods){
			if (m.getName().equals("mm")){
				m.invoke(o);//invoke调用类的方法，第一个参数是所属对象，第二个参数为该方法的参数，这里该方法没有参数，所以不传
			}
			if (m.getName().equals("m1")){
				m.invoke(o, 1, 2);//这里类的方法有参数，就需要传参数
				for (Class paramType : m.getParameterTypes()){//得到方法参数的类型
					System.out.println(paramType.getName());
				}
			}
			if (m.getName().equals("getS")){
				Class returnType = m.getReturnType();//得到方法返回值的类型
				System.out.println(returnType.getName());
			}
		}
	}

}

class T{
	private int i;
	
	static{
		System.out.println("T loaded!");
	}
	
	public T(){
		System.out.println("T constructed!");
	}
	
	public void mm(){
		System.out.println("mm loaded");
	}
	
	public void m1(int i, int j){
		this.i = i+j;
		System.out.println(this.i);
	}
	
	public String getS(){
		String s = null;
		return s;
	}
}
/*
***************JDK1.8运行结果***************
T loaded!
T constructed!
---------------------------
mm
m1
getS
wait
wait
wait
equals
toString
hashCode
getClass
notify
notifyAll
---------------------------
mm loaded
3
int
int
java.lang.String
*/















