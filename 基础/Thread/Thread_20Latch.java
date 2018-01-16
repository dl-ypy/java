package javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * date:2018年1月2日22点08分
 * @author joker
 * 
 * 写一个容器，两个线程，线程1添加10个元素到容器中，当添加到第五个时，线程2给出提示，并结束。
 * 
 * 给list添加volatile后，可以实现，但线程2的死循环浪费cpu
 * 
 * 使用waiy与notify能够实现，但过程教繁琐，必须有同步锁，并且使用两次wait与notify（因为notify后并不会释放锁）
 * 
 * 这里使用latch(门闩)
 * CountDownLatch不涉及锁定，当count的值为0时，当前线程继续运行
 */
public class Thread_20Latch {
	List list = new ArrayList();
	
	public static void main(String[] args) {
		Thread_20Latch t = new Thread_20Latch();
		CountDownLatch latch = new CountDownLatch(1);  //门闩
		
		new Thread(()->{
			System.out.println("t2启动");
			if (t.list.size() != 5) {
				try {
					latch.await();  //不等于5就让t2一直等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("t2结束");
		}).start();
		
		new Thread(()->{
			System.out.println("t1启动");
			for (int i=0; i<10; i++) {
				t.list.add(new Object());
				System.out.println("add "+i);
				
				if (t.list.size() == 5) {
					//打开门闩，让t2执行
					latch.countDown();
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

/**
 * JDK1.8运行结果
 * t2启动
 * t1启动
 * add 0
 * add 1
 * add 2
 * add 3
 * add 4
 * t2结束
 * add 5
 * add 6
 * add 7
 * add 8
 * add 9
 */
