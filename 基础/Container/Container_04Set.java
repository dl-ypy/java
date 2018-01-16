import java.util.*;

/**
 * date:2017年4月23日09:29:00
 * target:Set。
 * @author ypy
 * conclusion:
 * 	   Set的最大特性：元素是不能重复的。
 *     HashSet:
 * 	       HashSet的元素存放顺序和添加进去时候的顺序没有任何关系。
 *         HashSet类按照哈希算法来存取集合中的对象，存取速度比较快。
 *         HashSet允许包含值为null的元素，但最多只能有一个null元素，存放多个不会报错。
 *         HashSet不是线程同步的。
 *         使用场景：无序的、无重复的数据集合。
 *         注：自己写的类必须重写equals和hashCode方法，才能实现不可重复。
 *     LinkedHashSet:（HashSet的子类）
 *         LinkedHashSet保持元素的添加顺序。
 *         使用场景：维护次序的HashSet。
 *     TreeSet:
 *         不允许存放null。
 *         TreeSet是对Set中的元素进行排序存放（TreeSet类实现了SortedSet接口，能够对集合中的对象进行排序）。
 *         使用场景：保持元素大小次序的集合，元素需要实现Comparable接口。 
 *         注：自己写的类必须重写compareTo方法才能实现有序（如果不重写compareTo就会抛出异常）。
 *
 *     Set中存储的数据的类型都必须重写hashCode和equales方法，因为Set中的元素是不能重复的。
 */
class Teacher {
	private String name;
	private int id;
	
	public Teacher(int id, String name){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id + "  " + name;
	}
	
	public boolean equals(Object o){
		Teacher st = (Teacher)o;
		return st.id==this.id && st.name==this.name;
	}
	
	public int hashCode(){
		return new String(id+name).hashCode();//由Container_05hashCode.java中的知识得知，String(相同内容).hashCode()的哈希码是相同的
	}
}

class Student implements Comparable<Object>{
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
	
	//TreeSet必须重写compareTo方法
	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;  
		//注：这里比较时要将id和name都比较，否则只比较id时，在TreeSet判断重复时就只将id相同的判断为重复
		if ((this.id+this.name).hashCode() == (s.id+s.name).hashCode()) {
			return 0;
		} else if ((this.id+this.name).hashCode() > (s.id+s.name).hashCode()) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class Container_04Set{
	public static void main(String[] args){
		Set<Object> s1 = new HashSet<>();
		System.out.println("HashSet存取基本数据类型：");
		s1.add("a");   //java内置类型已经重写了equals和hashCode方法
		s1.add("b");
		s1.add("a");
		System.out.println(s1);
		System.out.println("----------------");
		
		Set<Teacher> S = new HashSet<Teacher>();
		System.out.println("HashSet存取非基本数据类型：");
		S.add(new Teacher(1000, "a"));
		S.add(new Teacher(1003, "ypy"));
		S.add(new Teacher(1002, "kb"));//有多个重复元素
		S.add(new Teacher(1002, "kb"));
		S.add(new Teacher(1002, "kb"));
		S.add(new Teacher(1002, "iiii"));
		S.add(null);       //HashSet允许存放空值
		
		System.out.println(S);
		System.out.println("----------------");
		
		
		System.out.println("LinkedHashSet存取基本数据类型：");
		Set<Object> linkedhashset = new LinkedHashSet<>();
		linkedhashset.add(5);
		linkedhashset.add(6);
		linkedhashset.add(6);
		linkedhashset.add("aaa");
		linkedhashset.add(1);
		linkedhashset.add(null);  //LinkedHashSet允许存放空值
		System.out.println(linkedhashset);
		System.out.println("----------------");
		
		System.out.println("LinkedHashSet存取非基本数据类型：");
		Set<Object> linkedhashset1 = new LinkedHashSet<>();
		linkedhashset1.add(new Teacher(2,"w"));
		linkedhashset1.add(new Teacher(2,"w"));
		linkedhashset1.add(new Teacher(1,"m"));
		System.out.println(linkedhashset1);
		System.out.println("----------------");
		
		
		System.out.println("TreeSet存取基本数据类型：");
		Set<Object> treeset = new TreeSet<>();
		treeset.add(5);
		treeset.add(2);
		treeset.add(2);
		treeset.add(3);
		System.out.println(treeset);
		System.out.println("----------------");
		
		Set<Object> treeset1 = new TreeSet<>();
		System.out.println("TreeSet存取非基本数据类型：");
		treeset1.add(new Student(5,"aa"));
		treeset1.add(new Student(3,"s"));
		treeset1.add(new Student(2,"a"));
		treeset1.add(new Student(2,"b"));
		treeset1.add(new Student(2,"b"));
		System.out.println(treeset1);
	}
}
/*
 * *************** jdk1.8运行结果*************** 
HashSet存取基本数据类型：
[a, b]
----------------
HashSet存取非基本数据类型：
[1002  kb, null, 1003  ypy, 1000  a, 1002  iiii]
----------------
LinkedHashSet存取基本数据类型：
[5, 6, aaa, 1, null]
----------------
LinkedHashSet存取非基本数据类型：
[2  w, 1  m]
----------------
TreeSet存取基本数据类型：
[2, 3, 5]
----------------
TreeSet存取非基本数据类型：
[2  a, 2  b, 3  s, 5  aa]
 */
