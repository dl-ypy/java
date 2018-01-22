package javaTest;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * data:2018年1月18日19点51分
 * @author joker
 * 并发容器之BlockingQueue
 */
public class Thread_23BlockingQueue{
	static BlockingQueue<String> strs = new LinkedBlockingQueue<>();
	static Random r = new Random();
	
	public static void main(String[] args) {
		new Thread(()->{  //生产线程
			for (int i=0; i<50; i++) {
				try {
					strs.put("a"+(i+1));  //如果满了，就会等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("生产："+strs.size()+"个");
		}).start();
		
		for (int i=0; i<5; i++) {//  启动5个消费线程，消费空，就会等待
			new Thread(()->{  
				for (;;) {
					try {
						System.out.println("线程"+Thread.currentThread().getName() + "消费" + strs.take());
						TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));  //随机睡眠，不超过1秒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
/**
 * JDK1.8运行结果
生产：50个
线程Thread-4消费a2
线程Thread-3消费a4
线程Thread-5消费a3
线程Thread-1消费a1
线程Thread-2消费a5
线程Thread-5消费a6
线程Thread-1消费a7
线程Thread-3消费a8
线程Thread-4消费a9
线程Thread-1消费a10
线程Thread-2消费a11
线程Thread-2消费a12
线程Thread-2消费a13
线程Thread-2消费a14
线程Thread-3消费a15
线程Thread-1消费a16
线程Thread-2消费a17
线程Thread-5消费a18
线程Thread-1消费a19
线程Thread-4消费a20
线程Thread-2消费a21
线程Thread-3消费a22
线程Thread-5消费a23
线程Thread-2消费a24
线程Thread-4消费a25
线程Thread-3消费a26
线程Thread-1消费a27
线程Thread-1消费a28
线程Thread-5消费a29
线程Thread-4消费a30
线程Thread-2消费a31
线程Thread-5消费a32
线程Thread-2消费a33
线程Thread-4消费a34
线程Thread-3消费a35
线程Thread-3消费a36
线程Thread-3消费a37
线程Thread-1消费a38
线程Thread-5消费a39
线程Thread-1消费a41
线程Thread-2消费a40
线程Thread-4消费a42
线程Thread-3消费a43
线程Thread-3消费a44
线程Thread-5消费a45
线程Thread-2消费a46
线程Thread-1消费a47
线程Thread-4消费a48
线程Thread-2消费a49
线程Thread-5消费a50
*/