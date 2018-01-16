/*
时间：2016年10月21日09:27:47
目的：泛型的使用
      使用泛型后，编译时不会有警告
*/
import java.util.*;

class Student implements Comparable<Student>{//这里就是泛型，限制了类型，增强安全性
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
	public int compareTo(Student st){//使用泛型后，此处的参数类型必须是前面所限制的类型，此处是Student类型
		
		if (this.id == st.id)
			return 0;
		else if (this.id > st.id)
			return 1;
		else
			return -1;
	}
}

public class Container_08GP{
	public static void main(String[] args){
		List<Student> L = new ArrayList<Student>();//泛型
		L.add(new Student(1000, "mj"));
		L.add(new Student(1003, "ypy"));
		L.add(new Student(1002, "kb"));
		L.add(new Student(1002, "kb"));
		
		Collections.sort(L);
		System.out.println(L);
	}
}
/*
***************JDK1.8运行结果***************
G:\java\基础>javac Container_08GP.java

G:\java\基础>java Container_08GP
[1000  mj, 1002  kb, 1002  kb, 1003  ypy]

G:\java\基础>
*/