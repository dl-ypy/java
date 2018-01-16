/**
 * date:2017年6月3日09:26:34
 * target:线程组。
 * @author ypy
 * conclusion：
 *     所有线程都隶属于一个线程组。那可以是一个默认线程组，亦可是一个创建线程时明确指定的组。
 *     每个应用都至少有一个线程从属于系统线程组。若创建多个线程而不指定一个组，它们就会自动归属于系统线程组。
 *     线程组也必须从属于其他线程组。必须在构建器里指定新线程组从属于哪个线程组。
 *     若在创建一个线程组的时候没有指定它的归属，则同样会自动成为系统线程组的一名属下。
 *     由于“安全”或者“保密”方面的理由才使用线程组的。
 *     一个线程不能修改位于自己所在组或者下属组之外的任何线程。
 */
class TestThread1 extends Thread {
	private int i;
	public TestThread1(ThreadGroup g, String name) {
		super(g, name);
	}
	
	public void f() {
		i++;
		System.out.println(getName() + ":f()");
	}
	@Override
	public void run() {
	}
}

class TestThread2 extends TestThread1 {
	private int i;
	public TestThread2(ThreadGroup g, String name) {
		super(g, name);
		start();
	}
	
	@Override
	public void run() {
		ThreadGroup g = getThreadGroup().getParent().getParent();//因为这里的线程组是z，所以上推两个parent就能得到y和x的信息。
		g.list();//打印出与一个线程组有关的所有信息
		Thread[] gALL = new Thread[g.activeCount()];//activeCount()返回此线程组和将此线程组作为其祖先的其他线程组中活动线程的估计数。
													//因为返回的只是活动的线程，而TestThread1没有start，是不活动的，所以只返回一个线程。
                                //当两个线程都是活的的时，系统会随机选择一个运行的，所以有可能也只会显示一个线程。
                                //要想将线程组中的线程都显示出来，必须对每个线程睡眠一定的时间，使得其他线程有机会运行。
		g.enumerate(gALL);//将指向所有这些线程的句柄置入数组 gAll里。
		for (int i=0; i<gALL.length; i++) {
			gALL[i].setPriority(Thread.MIN_PRIORITY); //设置优先级为最低的1
			((TestThread1)gALL[i]).f();
		}
		g.list();
	}
}

public class XiangCheng_17Group_1 {
	public static void main(String[] args) {
		//创建线程组
		ThreadGroup x = new ThreadGroup("x");//没有第一个参数，所以会自动进入系统线程组,x为线程组的名字。
		ThreadGroup y = new ThreadGroup(x, "y");
		ThreadGroup z = new ThreadGroup(y, "z");
		
		TestThread1 t1 = new TestThread1(x, "one");
		TestThread2 t2 = new TestThread2(z, "two");
	}
}
/*
 *************** jdk1.8运行结果***************
java.lang.ThreadGroup[name=x,maxpri=10]
    java.lang.ThreadGroup[name=y,maxpri=10]
        java.lang.ThreadGroup[name=z,maxpri=10]
            Thread[two,5,z]
two:f()
java.lang.ThreadGroup[name=x,maxpri=10]
    java.lang.ThreadGroup[name=y,maxpri=10]
        java.lang.ThreadGroup[name=z,maxpri=10]
            Thread[two,1,z]
 */
