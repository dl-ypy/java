import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * date:2018年1月3日21点39分
 * @author joker
 * ReentrantLock在没有拿到锁时也可执行操作，更灵活。
 * 程序执行：m1执行完才会执行m2
 */
public class Thread_21ReentrantLock_2 {
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
		boolean locked = false;
		try {
			locked = lock.tryLock(5, TimeUnit.SECONDS);//等待5秒，看是否拿到锁
			if (locked) { //拿到锁
				System.out.println("拿到锁");
				lock.unlock(); //释放锁
			} else {
				System.out.println("没拿到锁");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (locked) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread_21ReentrantLock_2 t = new Thread_21ReentrantLock_2();
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
 * 没拿到锁
 * 5
 * 6
 * 7
 * 8
 * 9
 */
