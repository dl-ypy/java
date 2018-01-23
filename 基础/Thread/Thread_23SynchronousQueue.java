package javaTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * data:2018年1月23日19点48分
 * @author joker
 * 并发容器之SynchronousQueue  特殊的TransferQueue
 * 没有容量的TransferQueue
 */
public class Thread_23SynchronousQueue{
	static BlockingQueue<String> str = new SynchronousQueue<>();
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{ //启动消费者线程
			try {
				System.out.println(str.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		str.put("aaa"); //阻塞等待 消费者消费 没有消费者就会阻塞
		System.out.println(str.size());
	}
}

/**
 * JDK1.8运行结果
 * aaa
 * 0
*/