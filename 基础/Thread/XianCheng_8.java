/*
    时间：2016年11月21日08:33:36
    目的：线程同步--synchronized
    注：简单的数据同步操作（只对单独的一个操作有效，如对两个单独的两个操作内部是有效的，但在两个操作之间是无效的）可用java封装的AtomicXXX代替，如AtomicInteger，
        此类具有原子性，但不是用synchronized实现的，而是系统底层实现的，所以效率高。
*/
public class XianCheng_8 implements Runnable{
	Timer timer = new Timer();
	public static void main(String[] args){
		XianCheng_8 x = new XianCheng_8();
		Thread t1 = new Thread(x);
		Thread t2 = new Thread(x);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	} 
	public void run(){
		timer.add(Thread.currentThread().getName());
		timer.add2(Thread.currentThread().getName());
	}
}

class Timer{
	private static int num = 0;
	private static int num1 = 0;
	//如果不加synchronized，当第一个线程sleep时，第二个线程就会执行，num++就会再执行一次，所以变成2
	public void add(String name){
		num++;
		try{
			Thread.sleep(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name+",你是第"+num+"个使用Timer的add方法的线程");
	}
	//加上synchronized，在执行该方法的过程中，当前对象被锁定
	//即使一个线程sleep，也不会执行另一个线程，必须一个线程执行完，才执行另一个线程
	// 也可用synchronized(this  如果这里锁定的方法tatic的，相当于synchronized(类名.class)
	// synchronized获得的锁是重入的，即在同一线程下，同一把锁是可以重复申请使用的
	// 遇到异常时，默认情况锁会被释放，需要加上try...catch
	public synchronized void add2(String name){
		num1++;
		try{
			Thread.sleep(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name+",你是第"+num1+"个使用Timer的add2方法的线程");
	}
}
/*
***************结果***************
t1,你是第2个使用Timer的add方法的线程
t2,你是第2个使用Timer的add方法的线程
t1,你是第1个使用Timer的add2方法的线程
t2,你是第2个使用Timer的add2方法的线程
*/