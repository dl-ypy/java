import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * date:2017年4月22日09:06:38
 * target:Collection接口的常用方法。
 * @author ypy
 * conclusion:
 *     List和Set都实现了Collection接口。
 */
public class Container_09Collection {
	public static void main(String[] args) {
		Collection<Object> c = new ArrayList<>();
		System.out.println("是否成功添加元素A?" + c.add("A"));   //添加元素操作，如果成功，返回true
		c.add(2.222);
		c.add(new A());
		Collection<Object> c0 = new ArrayList<>();
		c0.add("c0集合的元素");
		Collection<Object> c1 = new ArrayList<>();
		c1.add(20);
		c1.addAll(c);   //可添加一个集合，即添加了集合中的所以元素
		c1.addAll(c0);
		System.out.println("是否包含元素A?" + c1.contains("A"));//判断是否包含某个元素
		System.out.println("是否包含集合c?" + c1.containsAll(c));//判断是否包含一个集合
		System.out.println("集合包含的元素个数为：" + c1.size());  //返回集合所包含元素的数量
		
		//打印元素
		Iterator<Object> it = c1.iterator();
		System.out.println("-----------------");
		System.out.println("删除前集合c1中包含元素：");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		Object[] a = c1.toArray();  //返回包含集合所以元素的数组
		System.out.println("-----------------");
		System.out.println("转换为数组：");
		for (int i=0; i<a.length; i++) {
			System.out.println("a[" + i + "]:" + a[i]);
		}
		
		System.out.println("-----------------");
		System.out.println("删除元素A后：");
		c1.remove("A");//删除集合所包含的某个元素
		Iterator<Object> it1 = c1.iterator();//用过一个iterator后，必须再创建另一个才能再用
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		System.out.println("-----------------");
		System.out.println("删除集合c后：");
		c1.removeAll(c);//删除集合所包含的某个集合
		Iterator<Object> it2 = c1.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println("-----------------");
		System.out.println("只保留c0集合的元素后：");
		c1.retainAll(c0);//只保留某个集合的元素
		Iterator<Object> it3 = c1.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		System.out.println("-----------------");
		System.out.println("清除所有元素后：");
		c1.clear();//清除所有元素
		Iterator<Object> it4 = c1.iterator();
		while (it4.hasNext()) {
			System.out.println(it4.next());
		}
		System.out.println(c1.isEmpty());//判断集合是否为空
	}
}

class A {
	@Override
	public String toString() {
		return "A类的toString方法";
	}
}
/*
 * *************** jdk1.8运行结果*************** 
是否成功添加元素A?true
是否包含元素A?true
是否包含集合c?true
集合包含的元素个数为：5
-----------------
删除前集合c1中包含元素：
20
A
2.222
A类的toString方法
c0集合的元素
-----------------
转换为数组：
a[0]:20
a[1]:A
a[2]:2.222
a[3]:A类的toString方法
a[4]:c0集合的元素
-----------------
删除元素A后：
20
2.222
A类的toString方法
c0集合的元素
-----------------
删除集合c后：
20
c0集合的元素
-----------------
只保留c0集合的元素后：
c0集合的元素
-----------------
清除所有元素后：
true
 */
