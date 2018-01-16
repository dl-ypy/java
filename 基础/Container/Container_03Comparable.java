/*
时间：2016年10月14日09:17:53
目的：用Comparable接口实现对自定义类的排序
			注：ArrayList中的元素是可重复的
*/
import java.util.*;

class Student implements Comparable{//因为Collectios类不能对自定义的类进行排序（不知道自定义类的排序标准，即按什么标准排序）,所以要用Comparable
	private String name;
	private int id;
	
	public Student(int id, String name){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id + "  " + name;
	}
	
	@Override
	public int compareTo(Object o){//Comparable接口中的方法
		Student st = (Student)o;//Student继承了Object,这里要将父类对象强制转换为子类，才能使用子类特有的成员
		if (this.id == st.id)
			return 0;
		else if (this.id > st.id)
			return 1;
		else
			return -1;
	}
}

public class Container_03Comparable{
	public static void main(String[] args){
		List L = new ArrayList();
		L.add(new Student(1000, "mj"));
		L.add(new Student(1003, "ypy"));
		L.add(new Student(1002, "kb"));
		L.add(new Student(1002, "kb"));//有相同的两个元素，可重复
		
		Collections.sort(L);//sort方法会自动调用上面的comparableTo方法
		System.out.println(L);
	}
}
/*
***************程序运行***************
G:\java\基础>javac Container_03Comparable.java
注: Container_03Comparable.java使用了未经检查或不安全的操作。
注: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。

G:\java\基础>java Container_03Comparable
[1000  mj, 1002  kb, 1002  kb, 1003  ypy]

G:\java\基础>
*/