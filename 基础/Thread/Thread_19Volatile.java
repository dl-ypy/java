import java.util.concurrent.TimeUnit;
/**
 * date 2017年12月24日 20点17分
 * @author joker
 * volatile关键字,保证线程之间的可见性，不能保证原子性，所以不能代替synchronized
 * 本程序解析：
 *     初始的running为true，当T线程开始执行后，会从主内存读取running到线程对应的缓冲区，
 *     当T线程睡眠，主线程将running改为false，但是T线程缓冲区并不会（不一定）再次读取主内存中修改后的running,
 *     所以T线程不会停止；加上volatile后，主内存的running修改后，会通知T线程的缓冲区进行更改。
 * 注：也可用synchronized解决，但效率低。
 */
public class Thread_19Volatile{
	volatile boolean running = true;
	public static void main(String[] args) {
		Thread_19Volatile t = new Thread_19Volatile();
		new Thread(t::m, "t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.running = false;
	}
	
	void m() {
		System.out.println("m start");
		while (running) {
			
		}
		System.out.println("m end");
	}
}
/**
 * JDK1.8运行结果
 * 不加volatile的情况：
 * m start 
 * 加volatile的情况：
 * m start
 * m end
*/