/*
    时间：2016年11月23日09:12:06
    目的：线程同步--锁定一个方法时，其他方法是否可以执行？
*/
public class XianCheng_10 implements Runnable{ 
	int a = 100;
	
	public static void main(String[] args) throws Exception{
		XianCheng_10 x = new XianCheng_10();
		Thread t = new Thread(x);
		t.start();
		
		Thread.sleep(1000);//睡眠，确保子线程开始执行
		x.m2();
	}
	
	public synchronized void m1() throws Exception{
		a = 1000;
		Thread.sleep(5000);
		System.out.println("a=" + a);
	}
	
	public void m2(){
		System.out.println(a);
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
a=1000
1000
*/
/*
***************结论***************
因为m2方法输出的结果是1000，所以，在子线程运行锁定方法的同时，
主线程可以运行非锁定方法
*/