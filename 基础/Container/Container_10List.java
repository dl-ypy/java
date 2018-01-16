package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * date:2017年4月22日16:55:19
 * target:List之LinkedList与ArrayList。
 * @author ypy
 * conclusion:
 *     List是有序的（按添加的顺序排序）。
 *	   List可存放null，且可存放多个。
 *     对于存储空间上ArrayList是实现了基于数组的数据结构,数据元素保存在连继分配的内存，占用空间较小，
 *     LinkedList基于链表的数据结构，除了保存数据本身之外，还需要保存每个数据元素的前继和后继元素引用。占用内存空间较大。
 *     对于随机访问get和set，ArrayList性能上优于LinkedList，因为LinkedList要从表头开始搜索。
 *     对于添加和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。
 *     new ArrayList()默认10个空间，如果要添加多于10个元素，在add时就会进行扩充，每次扩充为原来的1.5倍
 *     new ArrayList(20)表示设置20个空间，并不进行扩充。
 *     
 *	   注：list.remove问题：
 *	       List 删除元素的逻辑是将目标元素之后的元素往前移一个索引位置
 *	       最好从后往前删除，因为从前往后删除时，每删除一个，下标都会前移，而i并不进行--
 *             所以就会有元素删除不掉。或者使用Iterator进行it.remove()。
 *		   不能在foreach中进行remove。
 */
public class Container_10List {
	public static final int N = 50000;
	public static void main(String[] args) {
		List<Object> linkedlist = new LinkedList<>();
		List<Object> arraylist = new ArrayList<>();
		addTest(linkedlist);
		addTest(arraylist);
		getTest(linkedlist);
		getTest(arraylist);
		updateTest(linkedlist);
		updateTest(arraylist);
		removeTest(linkedlist);
		removeTest(arraylist);
	}
	
	//得到list名字
	public static String getListName(List<Object> o) {
		if (o instanceof LinkedList) {
			return "LinkedList";
		} else if (o instanceof ArrayList) {
			return "ArrayList";
		} else {
			return "error";
		}
	}
	
	//向列表指定位置插入N个元素所花费的时间
	public static void addTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			o.add(0,i);    //list是有序的，故可以指定其位置
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "插入" + N + "个数据所花费的时间：" + (endTime-startTime) + "ms");
	}
	
	//删除列表指定位置的N个元素所花费的时间
	public static void removeTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			o.remove(0);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "删除" + N + "个数据所花费的时间：" + (endTime-startTime) + "ms");
	}
	
	//读取N个元素所花费的时间
	public static void getTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			o.get(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "读取" + N + "个数据所花费的时间：" + (endTime-startTime) + "ms");
	}
	
	//从list的随机位置修改元素所花费的时间
	public static void updateTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			int j = (int) (Math.random()*N);
			o.set(j,"修改"+j);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "随机修改" + N + "个数据所花费的时间：" + (endTime-startTime) + "ms");
	}
}
/*
 * *************** jdk1.8运行结果*************** 
----------------
LinkedList插入50000个数据所花费的时间：10ms
----------------
ArrayList插入50000个数据所花费的时间：327ms
----------------
LinkedList读取50000个数据所花费的时间：2233ms
----------------
ArrayList读取50000个数据所花费的时间：5ms
----------------
LinkedList随机修改50000个数据所花费的时间：2369ms
----------------
ArrayList随机修改50000个数据所花费的时间：36ms
----------------
LinkedList删除50000个数据所花费的时间：5ms
----------------
ArrayList删除50000个数据所花费的时间：328ms
 */
