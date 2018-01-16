import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * date:2018年1月3日21点15分
 * @author joker
 * ReentrantLock可以替代synchronized,但ReentrantLock需要手动释放锁。
 * 程序执行：m1执行完才会执行m2
 */
public class Thread_21ReentrantLock_1 {
	Lock lock = new ReentrantLock();
	void m1() {
		lock.lock();  //锁定对象
		try {
			for (int i=0; i<10; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();  //手动释放锁
		}
	}
	
	void m2() {
		lock.lock();
		System.out.println("m2...");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		Thread_21ReentrantLock_1 t = new Thread_21ReentrantLock_1();
		new Thread(t::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(t::m2).start();
	}
}

/**
 * JDK1.8运行结果
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * m2...
 */
