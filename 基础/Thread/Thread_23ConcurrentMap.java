package javaTest;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * data:2018年1月14日16点44分
 * @author joker
 * 并发容器->map/set
 * Hashtable：锁定的是整个对象，效率低
 * ConcurrentHashMap：分为16段锁定，不需要锁定整个对象，效率高
 * ConcurrentSkipListMap：会进行排序，效率较低
 */
public class Thread_23ConcurrentMap{
//	static Map<String, String> map = new ConcurrentHashMap<>();  //高并发不排序
//	static Map<String, String> map = new Hashtable<>();
	static Map<String, String> map = new ConcurrentSkipListMap<>();  //高并发且排序
	
	public static void main(String[] args) {
		Random r = new Random();
		Thread[] t = new Thread[100];  //创建100个线程
		CountDownLatch latch = new CountDownLatch(t.length); //创建100个门闩
		long startTime = System.currentTimeMillis();  //开始时间
		for (int i=0; i<t.length; i++) {  //执行100个线程
			new Thread(()->{
				for (int j=0; j<100000; j++) {  //每个线程都在map容器中放10000个随机的键值对
					map.put("a"+r.nextInt(100000), "a"+r.nextInt(100000));
				}
				latch.countDown(); //执行完一个线程，释放一个门闩
			}).start();;
		}
		
		try {
			latch.await();   //当所有门闩都释放后才执行主线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();  //结束时间
		
		System.out.println(endTime - startTime);
	}
}

/**
 * JDK1.8运行结果
 * ConcurrentHashMap：4691
 * Hashtable：6103
 * ConcurrentSkipListMap：9506
*/