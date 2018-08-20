/*
    时间：2016年11月29日08:28:31
    目的：线程同步--执行过程
*/
public class XianCheng_11 implements Runnable{ 
	int a = 100;
	
	public static void main(String[] args) throws Exception{
		XianCheng_11 x = new XianCheng_11();
		Thread t = new Thread(x);
		t.start();
		
		x.m2();
		System.out.println(x.a);
	}
	
	public synchronized void m1() throws Exception{
		a = 1000;
		Thread.sleep(5000);
		System.out.println("a=" + a);
	}
	
	public synchronized void m2() throws Exception{
		Thread.sleep(2500);
		a = 2000;
	}
	
	public void run(){
		try {
			m1();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
/*
***************JDK1.8运行结果***************
若m2不加synchronized:
2000
a=2000
若m2加synchronized:
1000
a=1000
*/
/*
***************执行过程***************
都加synchronized的两个方法不会同时执行。
正常情况是执行完主线程再执行子线程，但当主线程睡眠过一次后，接下来只要子线程不睡眠，就一定会先执行子线程。
若m2不加synchronized:
main -> t.start()开启子线程 -> 主线程执行，x.m2(),sleep(2500),此时，因为m2没上锁，所以，子线程可执行，设a=1000,sleep(5000),因为m2没上锁,所以，主线程可继续执行m2,设a=2000,输出a -> 继续执行子线程，输出a=2000。
若m2加synchronized:
main -> t.start()开启子线程 -> 主线程继续执行，x.m2()，synchronized对当前对象加锁，只有执行完当前方法，子线程才能执行同样加锁的m1,设a=2000,执行完m2方法后，再执行子线程 -> 子线程执行m1方法，设a=1000,sleep(5000)，
执行主线程，输出1000，再执行子线程输出a=1000
*/