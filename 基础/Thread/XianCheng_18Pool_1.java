package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * date:2017年6月5日12:30:03
 * target:线程池。
 * @author ypy
 * conclusion：
 *     为什么使用线程池？
 *         多线程中每start时都创建启动一个新线程，创建、销毁线程已经活动的线程都对系统有很大的开销。
 *         线程池好处：
 *         降低资源消耗：通过重复利用已创建的线程降低线程创建和销毁造成的消耗；
 *         提高响应速度：当任务到达时，任务可以不需要等到线程创建就能立即执行；
 *         提高线程的可管理性：线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 *     两个接口：
 *         Executor：只定义了一个方法execute，该方法执行Runnable任务。
 *         ExecutorService：继承自Executor，丰富了Executor接口。
 *                         ExecutorService的生命周期包括三种状态：运行、关闭、终止。
 *                         创建后便进入运行状态，当调用了shutdown（）方法时，便进入关闭状态，
 *                         此时意味着ExecutorService不再接受新的任务，但它还在执行已经提交了的任务，当所有已经提交了的任务执行完后，便到达终止状态。
 *                         如果不调用shutdown（）方法，ExecutorService会一直处在运行状态，不断接收新的任务，执行新的任务，服务器端一般不需要关闭它，保持一直运行即可。
 *     使用线程池：
 *		   1、创建线程池
 *			   (1).创建固定数目线程的线程池。
 *             (2).创建可缓存线程池。(合理之选)
 *             (3).创建一个单线程化的Executor。
 *             (4).创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
 *		   2、创建任务
 *			   (1).Runnable任务
 *			                 定义run方法，无返回值，不能抛出异常。
 *			   (2).Callable任务
 *				       定义call方法，返回表示任务完成的Future，能抛出异常。
 *		   3、执行任务
 *		   4、关闭线程池
 */
class Thread1 implements Runnable {
	@Override
    public void run() {
        System.out.println("run()方法被自动调用！！！  " + Thread.currentThread().getName());
    }
}

class Thread2 implements Callable<String> {
	private int id;
	public Thread2(int id) {
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		System.out.println("call()方法被自动调用！！！  " + Thread.currentThread().getName()); 
		return "call()方法被自动调用，任务返回的结果是：" + id + "  " + Thread.currentThread().getName();
	}
}

public class XianCheng_18Pool {
	//创建固定数目线程的线程池
	//任意时间点，最多只能有固定数目的活动线程存在，此时如果有新的线程要建立，只能放在另外的队列中等待，直到当前的线程中某个线程终止直接被移出池子
	//多用于服务器
	private static ExecutorService e = Executors.newFixedThreadPool(5);
	
	//创建一个可缓存线程池
	//调用execute将重用以前构造的线程（如果线程可用）。
	//如果现有线程没有可用的，则创建一个新线  程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
	//多用于生存期短的异步任务
	private static ExecutorService e1 = Executors.newCachedThreadPool();
	
	//创建一个单例线程。
	//任意时间池中只能有一个线程
	private static ExecutorService e2 = Executors.newSingleThreadExecutor();
	
	//创建一个支持定时及周期性的任务执行的线程池
	//这个池子里的线程可以按schedule依次delay执行，或周期执行
	private static ExecutorService e3 = Executors.newScheduledThreadPool(5);
	
	public static void main(String[] args) {
		List<Future<String>> resultList = new ArrayList<Future<String>>();
		//执行runnable任务
		for (int i=0; i<5; i++) {
			e1.execute(new Thread1());//提交5个任务
		}
		
		//执行callable任务
		for (int i=0; i<20; i++) {
			//执行任务并将返回值赋给future
			Future<String> future = e.submit(new Thread2(i));
			//将任务执行结果存储到List中
			resultList.add(future);
		}
		for (Future<String> fs : resultList) {
			while (!fs.isDone()) {//Future返回如果没有完成，则一直循环等待，直到Future返回完成
				try {
					System.out.println(fs.get());//打印各个线程（任务）执行的结果 
												 //get方法，等待计算完成，然后获取其结果
												 //如果结果数据还没准备好, 则调用线程将被阻塞
												 //所以这里也可能一个返回方法都不输出，因为可能都没准备好数据，都阻塞了
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		e1.shutdown();//调用该方法后，将导致ExecutorService停止接受任何新的任务且等待已经提交的任务执行完成。
					  //当所有已经提交的任务执行完毕后将会关闭ExecutorService。
	}
}
/*
 *************** jdk1.8运行结果***************
run()方法被自动调用！！！  pool-2-thread-2
run()方法被自动调用！！！  pool-2-thread-1
run()方法被自动调用！！！  pool-2-thread-4
run()方法被自动调用！！！  pool-2-thread-3
run()方法被自动调用！！！  pool-2-thread-5
call()方法被自动调用！！！  pool-1-thread-1
call()方法被自动调用！！！  pool-1-thread-3
call()方法被自动调用！！！  pool-1-thread-2
call()方法被自动调用！！！  pool-1-thread-2
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-4
call()方法被自动调用！！！  pool-1-thread-5
call()方法被自动调用，任务返回的结果是：4  pool-1-thread-5
 */
