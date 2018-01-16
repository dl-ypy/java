import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * date:2018年1月3日21点39分
 * @author joker
 * ReentrantLock可以中断线程。
 * 程序执行：m1一直在运行，释放不了锁，m2拿不到锁一直在等待，使用ReentrantLock可让m2停止等待。
 */
public class Thread_21ReentrantLock_3 {
	Lock lock = new ReentrantLock();
	void m1() {
		try {
			lock.lockInterruptibly();  //锁定对象
			System.out.println("m1");
			TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); //无限睡眠
		} catch (InterruptedException e) {
			System.out.println("m1中断");
			e.printStackTrace();
		} finally {
			lock.unlock();  //手动释放锁
		}
	}
	
	void m2() {
		try {
			lock.lockInterruptibly();
			System.out.println("m2");
		} catch (InterruptedException e) {
			System.out.println("m2中断");
		} finally {
			if (lock.tryLock()) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread_21ReentrantLock_3 t = new Thread_21ReentrantLock_3();
		Thread t1 = new Thread(t::m1);
		Thread t2 = new Thread(t::m2);
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.interrupt();  //打断线程2的等待
	}
}

/**
 * JDK1.8运行结果
 * m1
 * m2中断
 */
