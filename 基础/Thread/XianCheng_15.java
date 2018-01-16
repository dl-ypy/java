/**
 * 目的：wait与notify方法在同步中的运用。
 * 时间：2017年3月26日22:47:43
 * 执行过程：先执行主线程，锁定资源对象a，执行synchronized块中的代码，
 * 		     执行到wait，停止执行，释放对资源的锁定，此时，子线程就开始执行
 * 		     执行到notify方法，归还资源，执行完synchronized块中的代码，释放对象锁（此时再执行哪个线程取决于cup）
 */
public class Liu
{
    public static void main(String[] args)
    {
	A a = new A();
	Thread t = new Thread(a);
	t.start();
	synchronized (a) {
		System.out.println(Thread.currentThread().getName() + "正在执行...");
		System.out.println("释放对像锁    wait...");
		try {
			a.wait();
			System.out.println("归还了对象锁！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    }
}

class A implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "正在执行...");
			System.out.println("即将归还对象锁...");
			notify();
			System.out.println("继续执行子程序！");
		}
	}
}
/***************JDK1.8运行结果***************
main正在执行...
释放对像锁    wait...
Thread-0正在执行...
即将归还对象锁...
继续执行子程序！
归还了对象锁！
*/
 