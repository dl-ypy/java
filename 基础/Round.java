/*
时间：2016年10月26日15:59:43
目的：四舍五入Math.round，向上取整Math.ceil，向下取整Math.floor
*/
public class Round{
	public static void main(String[] args){
		System.out.println("向上取整");
		System.out.println(Math.ceil(11.2));
		System.out.println(Math.ceil(11.9));
		System.out.println(Math.ceil(-11.2));
		System.out.println(Math.ceil(-11.9));
		
		System.out.println("向下取整");
		System.out.println(Math.floor(11.9));
		System.out.println(Math.floor(11.2));
		System.out.println(Math.floor(-11.9));
		System.out.println(Math.floor(-11.2));
		
		System.out.println("四舍五入");   //算法为Math.floor(x+0.5)
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(11.4));
		System.out.println(Math.round(-11.5));//这个特殊
		System.out.println(Math.round(-11.6));
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>java Round
向上取整
12.0
12.0
-11.0
-11.0
向下取整
11.0
11.0
-12.0
-12.0
四舍五入
12
11
-11
-12

G:\java\基础>
*/