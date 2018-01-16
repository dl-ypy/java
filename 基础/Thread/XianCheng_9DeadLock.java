/*
    时间：2016年11月23日08:47:11
    目的：线程同步--死锁
*/
public class XianCheng_9DeadLock implements Runnable{
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object();  //这里使用static是为了使两个对象使用同共同的属性。
	
	public static void main(String[] args){
		XianCheng_9DeadLock td1 = new XianCheng_9DeadLock();
		XianCheng_9DeadLock td2 = new XianCheng_9DeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}
	
	public void run(){
		System.out.println("flag=" + flag);
		if (flag == 1){
			
			synchronized(o1){
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					 e.printStackTrace();
				}
			
				synchronized(o2){
					System.out.println("1");//要想执行此语句必须同时锁定o1和o2
																	//此时已经锁定了o1,需要锁定o2,但flag=0的线程锁定了o2
				}
			}
		}
		
		if (flag == 0){
			
			synchronized(o2){
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					 e.printStackTrace();
				}
			
				synchronized(o1){
					System.out.println("0");//要想执行此语句必须同时锁定o1和o2
																	//此时已经锁定了o2,需要锁定o1,但flag=1的线程锁定了o1
				}
			}
		}
	}
}
/*
***************JDK1.8运行结果***************
flag=1
flag=0
*/