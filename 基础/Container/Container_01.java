/*
时间：2016年10月13日10:10:31
目的：为什么需要容器？
			因为数组难以扩充，而且元素必须是同一类型的
			所有容器中存放的都是对象，如果写孤立的值，就会内部转换成对象
*/
import java.util.*;

class A{
	public String toString(){
		return "重写了toString方法";
	}
}

public class Container_01{
	public static void main(String[] args){
		ArrayList al = new ArrayList();
		al.add(123);//整型的在内部用Integer实现了“自动装箱”，因此可以调用toString方法
		al.add("ypy");//字符串的本身就是一个对象，能调用toString方法
		al.add(88.88);
		al.add(new A());
		//System.out.println(al[2]);  容器不是数组
		System.out.println(al.get(2));//实现上一行数组功能的方式
		Object[] objArr = al.toArray();//可以将容器转换为数组
		System.out.println(objArr[3]);//转换为数组后再用数组的方式实现
		System.out.println(al);//输出时al里面各个对象都会调用各自的toString方法
	}
}
/*
***************程序运行***************
G:\java\基础>javac Container.java
注: Container.java使用了未经检查或不安全的操作。
注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。

G:\java\基础>java Container
88.88
重写了toString方法
[123, ypy, 88.88, 重写了toString方法]

G:\java\基础>
*/