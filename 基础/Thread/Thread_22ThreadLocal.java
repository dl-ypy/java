import java.util.concurrent.TimeUnit;
/**
 * data:2018年1月9日21点39分
 * @author joker
 * ThreadLocal：每个线程私有的，使用空间换时间，synchronized是使用时间换空间
 * 程序执行：操作同一个A类对象，线程1为其设值，但线程2中a对象为空。
 */
public class Thread_22ThreadLocal{
	static ThreadLocal<A> a = new ThreadLocal<A>();
	
	public static void main(String[] args) {
		new Thread(()->{
			a.set(new A());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()->{
			System.out.println(a.get());
		}).start();
	}
}

class A {
}
/**
 * JDK1.8运行结果
 * null 
*/