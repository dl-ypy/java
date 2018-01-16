/**
 * date:2017年7月10日10:58:11
 * target:枚举。
 * @author ypy
 */
public class Enum {
	public static void main(String args[]) { 
		System.out.println(Color.blue.ordinal());//返回元素的编号
		
		//枚举天生实现了comparable接口
		System.out.println(Color.red.compareTo(Color.blue));
		
		Color.red.fun();
	}
}

//枚举类型
enum Color {
	red,
	blue,
	yellow;
	
	public void fun() {
		System.out.println("枚举的方法");
	}
}
/*
***************JDK1.8运行结果****************
1
-1
枚举的方法
*/
