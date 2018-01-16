package dao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * date:2017年6月6日08:28:11
 * target:自定义线程池。
 * @author ypy
 * conclusion：
 *     从实验结果可看出，6个任务是在3（核心线程数目）个线程上执行的。
 *     当线程池中的线程数小于核心线程数，就会创建新线程，直到等于核心线程数。
 *     当线程数大于corePoolSize，且阻塞队列未满，就会将多余的线程放入该队列，等有线程空闲出来后再依次执行。
 *     当线程数大于corePoolSize，且阻塞队列已满，而线程数小于最大线程数，则会创建新的线程来处理被添加的任务。
 *     当队列满了，而且正在运行的线程数量大于或等于maximumPoolSize，线程池会将任务传递给最后一个参数RejectedExecutionHandler来处理，
 *     比如打印报错日志、抛出异常、存储到Mysql/redis用于后续处理（饱和策略）等等。
 *     
 *     阻塞队列的类型：
 *         ArrayBlockingQueue：有边界队列，初始化时要指定其大小，且指定后不能改变。
 *         DelayQueue：元素必须实现 java.util.concurrent.Delayed接口，该接口只有一个方法就是long getDelay(TimeUnit unit)，
 *                    返回值就是队列元素被释放前的保持时间，如果返回0或者一个负值，就意味着该元素已经到期需要被释放，
 *                    此时DelayedQueue会通过其take()方法释放此对象，DelayQueue可应用于定时关闭连接、缓存对象，超时处理等各种场景。
 *         LinkedBlockingQueue：队列大小的配置是可选的，若指定大小，就是有边界的，否则，就是无边界的。（其实是采用了默认大小为Integer.MAX_VALUE的容量）
 *         PriorityBlockingQueue：无边界，允许插入null，所有插入PriorityBlockingQueue的对象必须实现 java.lang.Comparable接口，通过此接口指定排序规则。
 *         SynchronousQueue：仅容纳一个元素。
 *         注：使用的最多的应该是LinkedBlockingQueue，一般情况下要配置一下队列大小，设置成有界队列，否则JVM内存会被撑爆！
 */
class Thread1 implements Runnable {
	@Override
    public void run() {
        System.out.println("run()方法被自动调用！！！  " + Thread.currentThread().getName());
    }
}

public class XianCheng_18Pool_2 {
	public static void main(String[] args) {
		//创建阻塞队列
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		//创建线程池，核心线程数为3，最大线程数为5
		//线程没有执行任务时，最多保持50微妙会终止，然后线程数目维持在核心大小
		//bqueue是一个阻塞队列，用来存储等待执行的任务，如果当前对线程的需求超过了核心大小，才会放在这里
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, bqueue);
		//创建任务
		Runnable t1 = new Thread1();//只能是Runnable任务
		Runnable t2 = new Thread1();
		Runnable t3 = new Thread1();
		Runnable t4 = new Thread1();
		Runnable t5 = new Thread1();
		Runnable t6 = new Thread1();
		//执行任务
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		//关闭线程池
		pool.shutdown();
	}
}
/*
 *************** jdk1.8运行结果***************
run()方法被自动调用！！！  pool-1-thread-2
run()方法被自动调用！！！  pool-1-thread-3
run()方法被自动调用！！！  pool-1-thread-3
run()方法被自动调用！！！  pool-1-thread-3
run()方法被自动调用！！！  pool-1-thread-1
run()方法被自动调用！！！  pool-1-thread-2
 */
