package javaTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * data:2018年1月22日21点05分
 * @author joker
 * 并发容器之DelayQueue
 * 按设计时间的前后顺序执行
 */
public class Thread_23DelayQueue{
	static BlockingQueue<MyTask> task = new DelayQueue<>();
	static class MyTask implements Delayed {  //put的元素必须要实现Delayed接口
		long runningTime;
		MyTask (long rt) {
			this.runningTime = rt;
		}
		
		@Override
		public int compareTo(Delayed o) {
			if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
				return -1;
			} else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
				return 1;
			}
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(runningTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}
		
		@Override
		public String toString() {
			return ""+runningTime;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		long now = System.currentTimeMillis();
		MyTask t1 = new MyTask(now + 1000);  //当前时间1秒后执行
		MyTask t2 = new MyTask(now + 2000);  //当前时间2秒后执行
		MyTask t3 = new MyTask(now + 1500);  //当前时间1.5秒后执行
		MyTask t4 = new MyTask(now + 2500);  //当前时间2.5秒后执行
		MyTask t5 = new MyTask(now + 500);  //当前时间0.5秒后执行
		
		task.put(t1);
		task.put(t2);
		task.put(t3);
		task.put(t4);
		task.put(t5);
		
		System.out.println(task);
		
		for (int i=0; i<5; i++) {
			System.out.println(task.take());
		}
	}
}

/**
 * JDK1.8运行结果
 * [1516626429844, 1516626430344, 1516626430844, 1516626431844, 1516626431344]
 * 1516626429844
 * 1516626430344
 * 1516626430844
 * 1516626431344
 * 1516626431844
*/