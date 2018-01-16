package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * date:2017��4��22��16:55:19
 * target:List֮LinkedList��ArrayList��
 * @author ypy
 * conclusion:
 *     List������ģ�����ӵ�˳�����򣩡�
 *	   List�ɴ��null���ҿɴ�Ŷ����
 *     ���ڴ洢�ռ���ArrayList��ʵ���˻�����������ݽṹ,����Ԫ�ر��������̷�����ڴ棬ռ�ÿռ��С��
 *     LinkedList������������ݽṹ�����˱������ݱ���֮�⣬����Ҫ����ÿ������Ԫ�ص�ǰ�̺ͺ��Ԫ�����á�ռ���ڴ�ռ�ϴ�
 *     �����������get��set��ArrayList����������LinkedList����ΪLinkedListҪ�ӱ�ͷ��ʼ������
 *     ������Ӻ�ɾ������add��remove��LinedList�Ƚ�ռ���ƣ���ΪArrayListҪ�ƶ����ݡ�
 *     new ArrayList()Ĭ��10���ռ䣬���Ҫ��Ӷ���10��Ԫ�أ���addʱ�ͻ�������䣬ÿ������Ϊԭ����1.5��
 *     new ArrayList(20)��ʾ����20���ռ䣬�����������䡣
 *     
 *	   ע��list.remove���⣺
 *	       List ɾ��Ԫ�ص��߼��ǽ�Ŀ��Ԫ��֮���Ԫ����ǰ��һ������λ��
 *	       ��ôӺ���ǰɾ������Ϊ��ǰ����ɾ��ʱ��ÿɾ��һ�����±궼��ǰ�ƣ���i��������--
 *             ���Ծͻ���Ԫ��ɾ������������ʹ��Iterator����it.remove()��
 *		   ������foreach�н���remove��
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
	
	//�õ�list����
	public static String getListName(List<Object> o) {
		if (o instanceof LinkedList) {
			return "LinkedList";
		} else if (o instanceof ArrayList) {
			return "ArrayList";
		} else {
			return "error";
		}
	}
	
	//���б�ָ��λ�ò���N��Ԫ�������ѵ�ʱ��
	public static void addTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			o.add(0,i);    //list������ģ��ʿ���ָ����λ��
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "����" + N + "�����������ѵ�ʱ�䣺" + (endTime-startTime) + "ms");
	}
	
	//ɾ���б�ָ��λ�õ�N��Ԫ�������ѵ�ʱ��
	public static void removeTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			o.remove(0);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "ɾ��" + N + "�����������ѵ�ʱ�䣺" + (endTime-startTime) + "ms");
	}
	
	//��ȡN��Ԫ�������ѵ�ʱ��
	public static void getTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			o.get(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "��ȡ" + N + "�����������ѵ�ʱ�䣺" + (endTime-startTime) + "ms");
	}
	
	//��list�����λ���޸�Ԫ�������ѵ�ʱ��
	public static void updateTest(List<Object> o) {
		System.out.println("----------------");
		long startTime = System.currentTimeMillis();
		for (int i=0; i<N; i++) {
			int j = (int) (Math.random()*N);
			o.set(j,"�޸�"+j);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(getListName(o) + "����޸�" + N + "�����������ѵ�ʱ�䣺" + (endTime-startTime) + "ms");
	}
}
/*
 * *************** jdk1.8���н��*************** 
----------------
LinkedList����50000�����������ѵ�ʱ�䣺10ms
----------------
ArrayList����50000�����������ѵ�ʱ�䣺327ms
----------------
LinkedList��ȡ50000�����������ѵ�ʱ�䣺2233ms
----------------
ArrayList��ȡ50000�����������ѵ�ʱ�䣺5ms
----------------
LinkedList����޸�50000�����������ѵ�ʱ�䣺2369ms
----------------
ArrayList����޸�50000�����������ѵ�ʱ�䣺36ms
----------------
LinkedListɾ��50000�����������ѵ�ʱ�䣺5ms
----------------
ArrayListɾ��50000�����������ѵ�ʱ�䣺328ms
 */
