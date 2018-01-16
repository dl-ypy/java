import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * data:2018年1月16日21点12分
 * @author joker
 * 并发容器->list
 * Vector：线程安全
 * CopyOnWriteArrayList：线程安全，写时效率低，读时效率高，适合写少读多的环境
 */
public class CurrentList{
//	static List<String> list = new Vector<>();
	static List<String> list = new CopyOnWriteArrayList<>(); 
	
	public static void main(String[] args) {
		Thread[] t = new Thread[100];  //创建100个线程
		CountDownLatch latch = new CountDownLatch(t.length); //创建100个门闩
		long startTime = System.currentTimeMillis();  //开始时间
		for (int i=0; i<t.length; i++) {  //执行100个线程
			new Thread(()->{
				for (int j=0; j<1000; j++) {
					list.add("a");
				}
				latch.countDown(); //执行完一个线程，释放一个门闩
			}).start();
			
		}
		
		try {
			latch.await();   //当所有门闩都释放后才执行主线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();  //结束时间
		
		System.out.println(endTime - startTime);
		System.out.println(list.size());
	}
}

/**
 * JDK1.8运行结果
 * Vector：
 * 333
 * 100000
 * 
 * CopyOnWriteArrayList：
 * 8595
 * 100000
*/