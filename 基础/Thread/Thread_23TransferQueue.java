package javaTest;

import java.util.concurrent.LinkedTransferQueue;

/**
 * data:2018年1月22日20点29分
 * @author joker
 * 并发容器之TransferQueue
 * 在生产者消费者实例中，此容器的作用为：先启动消费者线程，再启动生产者线程，生产者线程会直接找是否有启动的消费者线程，而不会放入队列中。
 * 效率更高
 */
public class Thread_23TransferQueue{
	
	public static void main(String[] args) {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
		new Thread(()->{  //消费者线程在transfer前启动的情况，正常
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		try {
			strs.transfer("aaa");   //表示生产者线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*new Thread(()->{  //消费者线程在transfer后启动的情况，阻塞
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/
	}
}

/**
 * JDK1.8运行结果
 * aaa
*/