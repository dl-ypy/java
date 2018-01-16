import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * date:2017年4月24日09:42:45
 * target:Collections的使用。
 * @author ypy
 * conclusion:
 *     Collections是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
 */
public class Container_02Collections{
	public static void main(String[] args){
		System.out.println("Collection只读：");
		Collection<Object> c = new ArrayList<>();
		add(c);
		c = Collections.unmodifiableCollection(c);  //可读，但不可修改
		//c.add(2);  不能往里添加
		print(c);
		System.out.println("-----------------");
		
		System.out.println("List只读：");
		List<Object> l = new ArrayList<>();
		add(l);
		l = Collections.unmodifiableList(l);
		//l.add(2);
		print(l);
		System.out.println("-----------------");
		
		System.out.println("Set只读：");
		Set<Object> s = new HashSet<>();
		add(s);
		s = Collections.unmodifiableSet(s);
		//s.add(2);
		print(s);
		System.out.println("-----------------");
		
		System.out.println("Map只读：");
		Map<Object,Object> m = new HashMap<>();
		m.put(1, "ss");
		m.put(2, "a");
		m = Collections.unmodifiableMap(m);
		//m.put(3, "e");
		System.out.println(m);
		System.out.println("-----------------");
		
		
		//控制集合的同步
		Collection<Object> c1 = Collections.synchronizedCollection(new ArrayList<>());
		List<Object> l1 = Collections.synchronizedList(new ArrayList<>());
		Set<Object> s1 = Collections.synchronizedSet(new HashSet<>());
		Map<Object,Object> m1 = Collections.synchronizedMap(new HashMap<>());
		
		
		//控制集合顺序
		List<Integer> list = new ArrayList<>();
		System.out.println("初始顺序：");
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.shuffle(list);//打乱顺序
		System.out.println("打乱顺序后：");
		System.out.println(list);
		System.out.println("重新排序后：");
		Collections.sort(list); //默认为升序排列
		System.out.println(list);
		System.out.println("二分法查找：");
		System.out.println("元素4的位置：" + Collections.binarySearch(list, 4));//只有在升序排列的前提下才能二分法查找
		System.out.println("顺序倒置：");
		Collections.reverse(list);//将顺序倒置
		System.out.println(list);
		
		
		//还有...很多方法
	}
	
	public static void add(Collection<Object> c) {
		c.add(1);
		c.add("ff");
		c.add(null);
		c.add(false);
	}
	
	public static void print(Collection<Object> c) {
		Iterator<Object> it = c.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
 /* *************** jdk1.8运行结果*************** 
Collection只读：
1
ff
null
false
-----------------
List只读：
1
ff
null
false
-----------------
Set只读：
ff
null
1
false
-----------------
Map只读：
{1=ss, 2=a}
-----------------
初始顺序：
[1, 5, 3, 4]
打乱顺序后：
[1, 4, 3, 5]
重新排序后：
[1, 3, 4, 5]
二分法查找：
元素4的位置：2
顺序倒置：
[5, 4, 3, 1]
 */
