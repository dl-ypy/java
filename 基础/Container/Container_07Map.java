import java.util.*;
import java.util.Map.Entry;

/**
 * date:2017年4月23日16:55:35
 * target:Map。
 * @author ypy
 * conclusion:
 *     Map中不能包含重复的key，每一个key最多对应一个value。
 *     HashMap,LinkedHashMap,TreeMap之间的区别与HashSet,LinkedHashSet,TreeSet之间的区别相似。
 *	       注：Map虽然功能强大（查找数据时不需要比较，根据算法直接计算出对应的存储地址）,
 *	       但是也有缺陷,算法不完美,分配空间问题，空间利用率低，还有哈希冲突等问题。
 *     作为Key的类型，必须重写hashCode和equales方法，因为Key值是唯一的，Key与Value的关系是一对多的关系。
 *     用TreeMap必须实现Comparable接口，因为是有序的。
 *     Map可存放null，且允许多个。
 *     Hashtable不允许null。
 */
class Student{
	private int key;
	private int age;
	private String name;
	
	public Student(int key, int age, String name){
		this.key = key;
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "[" + key + "," + name + "," + age + "]";
	}
}

public class Container_07Map{
	public static void main(String[] args){
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		System.out.println("HashMap存取基本数据类型：");
		m1.put(1, "b");
		m1.put(1, "b");
		m1.put(4, "e");
		m1.put(3, "a");
		System.out.println(m1);
		System.out.println("-------------------");
		
		System.out.println("HashMap存取非基本数据类型：");
		Map<Integer, Student> m = new HashMap<Integer, Student>();
		m.put(1001, new Student(1001, 20, "a"));//此处的1001也实现了自动装箱技术
		m.put(1002, new Student(1002, 22, "b"));
		m.put(1005, new Student(1002, 22, "b"));
		m.put(1003, new Student(1003, 23, "c"));
		System.out.println(m);
		System.out.println("-------------------");
		
		//遍历所有元素方法一：（获取key，尽管可以通过key获取到value，但要想获取key和value还是建议用第三种遍历方法，效率高）
		System.out.println("方法一：m容器中的所有元素是：");
		Set s = m.keySet();//获取当前容器中容器键的集合
		Iterator it = s.iterator();
		while (it.hasNext()){
			Integer key = (Integer)it.next();//得到集合中的每个键，并由原来的Object类型转换为Integer类型,因为在前面自动装箱时转换为Integer类型
			System.out.println(m.get(key));//得到键为key的内容并输出
		}
		System.out.println("-------------------");
		
		//遍历所有元素方法二：（获取value）
		System.out.println("方法二：m容器中的所有元素是：");
		Collection<Student> collection = m.values();//返回值是个值的Collection集合
		System.out.println(collection);
		System.out.println("-------------------");
		
		//遍历所有元素方法三：（获取key和value）
		System.out.println("方法三：m容器中的所有元素是：");
		//通过entrySet()方法将map集合中的映射关系取出（这个关系就是Map.Entry类型）
		Set<Entry<Integer, Student>> entrySet = m.entrySet();
		//将关系集合entrySet进行迭代，存放到迭代器中                
		Iterator<Entry<Integer, Student>> it1 = entrySet.iterator();

		while(it1.hasNext()) {
		     Entry<Integer, Student> me = it1.next();//获取Map.Entry关系对象me
		     Integer key = me.getKey();//通过关系对象获取key
		     Student value = me.getValue();//通过关系对象获取value
		     System.out.println("{" + key + "=" + value + "}");
		}
		System.out.println("-------------------");
		
		System.out.println("直接查找某个元素");
		System.out.println(m.get(1002));
		System.out.println(m.get(1000));//找不到的会返回空值
	}
}
 /* *************** jdk1.8运行结果*************** 
HashMap存取基本数据类型：
{1=b, 3=a, 4=e}
-------------------
HashMap存取非基本数据类型：
{1001=[1001,a,20], 1002=[1002,b,22], 1003=[1003,c,23], 1005=[1002,b,22]}
-------------------
方法一：m容器中的所有元素是：
[1001,a,20]
[1002,b,22]
[1003,c,23]
[1002,b,22]
-------------------
方法二：m容器中的所有元素是：
[[1001,a,20], [1002,b,22], [1003,c,23], [1002,b,22]]
-------------------
方法三：m容器中的所有元素是：
{1001=[1001,a,20]}
{1002=[1002,b,22]}
{1003=[1003,c,23]}
{1005=[1002,b,22]}
-------------------
直接查找某个元素
[1002,b,22]
null
 */
