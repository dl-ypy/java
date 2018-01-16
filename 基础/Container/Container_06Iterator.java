/*
时间：2016年10月17日08:37:12
目的：Iterator接口的使用
*/
import java.util.*;

public class Container_06Iterator{
	
	//必须是静态方法，因为在下面的main方法中要调用，而main方法是静态的，静态方法不能调用非静态方法
	public static void showCollection(Collection c){//能够输出任何类型
		Iterator it = c.iterator();
		while (it.hasNext()){//hasNext()方法是判断有没有下一个，刚开始的时候游标位于第一个元素的前面
			System.out.println(it.next());//执行next()方法，返回游标右边的那个元素，游标向后移一位
		}
	}
	
	public static void main(String[] args){
		ArrayList al = new ArrayList();
		al.add("one");
		al.add(22);
		al.add(new Point(1, 1));
		System.out.println("al容器的内容是：");
		showCollection(al);
	}
}

class Point{
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>java Container_06Iterator
al容器的内容是：
one
22
(1,1)

G:\java\基础>
*/