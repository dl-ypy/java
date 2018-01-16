/*
时间：2016年10月16日09:49:06
目的：为什么要重写hashCode方法
			java自定义的类已经重写了hashCode方法，new出相同内容（不同内存空间）的哈希码是相同的，如String，Integer
			而自己定义的类没有重写hashCode方法，所以相同内容的哈希码也是不同的，如本程序中的A类
			在以哈希表为内部存储模式的容器中，要想比较两个值是否相同，必须通过哈希码找到对应的内存地址，然后在该地址对应的链表中进行比较
			所以要想去除重复的值，必须重写hashCode方法，进入同一个内存地址所对应的链表中，再通过重写equals方法在链表内进行比较
*/
import java.util.*;

class A{
	private int id;
	
	public A(int id){
		this.id = id;
	}
}

class B{
	private int id;
	
	public B(int id){
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		return new Integer(id).hashCode();
	}
}

public class Container_05hashCode{
	public static void main(String[] args){
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println("new String(\"ypy\").hashCode() = " + new String("ypy").hashCode());
		System.out.println("new String(\"ypy\").hashCode() = " + new String("ypy").hashCode());
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		
		Integer it1 = new Integer(1);
		Integer it2 = new Integer(1);
		System.out.println(it1 == it2);
		System.out.println(it1.equals(it2));
		System.out.println(it1.hashCode() == it2.hashCode());
	}
}
/*
***************JDK1.8运行结果***************
new A(1).hashCode() = 366712642
new A(1).hashCode() = 1829164700
new Integer(1).hashCode() = 1
new Integer(1).hashCode() = 1
new String("ypy").hashCode() = 119874
new String("ypy").hashCode() = 119874
new B(1).hashCode() = 1
new B(1).hashCode() = 1
false
true
true
*/