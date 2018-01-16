import java.util.HashMap;
import java.util.Hashtable;

/**
 * date:2017年6月14日09:28:02
 * target:Hashtable与HashMap的区别。
 * @author ypy
 * conclusion：
 *     一.历史原因:Hashtable 是基于陈旧的 Dictionary类的，HashMap 是 Java 1.2引进的 Map接口的一个实现。
 *     二.同步性:Hashtable 是线程安全的，也就是说是同步的，而 HashMap 是线程序不安全的，不是同步的。
 *     三.值：只有 HashMap可以让你将空值作为一个表的条目的 key 或 value
 */
public class Container_12Hashtable_HashMap {
	public static void main(String[] args) {
		Hashtable<String, String> t = new Hashtable<>();
		HashMap<String, String> m = new HashMap<>();
		//t.put(null, null);   //不允许放入null
		m.put(null, null);
		System.out.println(m);
	}
}
/*
 *************** jdk1.8运行结果***************
 *{null=null}
 */
