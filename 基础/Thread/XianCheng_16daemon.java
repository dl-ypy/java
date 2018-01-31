/**
 * date:2017年6月1日20:58:08
 * target:daemon（守护）线程。
 * @author ypy
 * conclusion：
 *     java的线程分为两类: 用户线程和daemon线程。
 *     daemon线程是为我们创建的用户线程提供服务的线程,比如说jvm的GC等等。
 *     守护线程创建的过程中需要先调用setDaemon方法进行设置,然后再启动线程.否则会报出IllegalThreadStateException异常。
 *     当用户线程运行结束的时候,daemon线程将会自动退出(测试时可用System.in.read()阻塞用户线程来测试守护线程的输出信息)。
 *     daemon线程创建的子线程任然是daemon线程。
 *     不是所有的应用都可以分配给Daemon线程来进行服务，比如读写操作或者计算逻辑。因为在Daemon Thread还没来的及进行操作时，虚拟机可能已经退出了。
 *     实际应用：举个例子，web服务器中的Servlet，容器启动时后台初始化一个服务线程，即调度线程，负责处理http请求，然后每个请求过来调度线程从线程池中取出一个工作者线程来处理该请求，从而实现并发控制的目的。
 */
class Daemon implements Runnable {
	@Override
	public void run() {
		A a = new A();
		Thread t = new Thread(a);
		t.start();
		System.out.println("a是否为daemon线程？" + t.isDaemon());
		System.out.println("Daemon");
	}
}

class A extends Thread {
	@Override
	public void run() {
		System.out.println("A");
	}
}

public class XianCheng_16daemon {
	public static void main(String[] args) {
		Daemon d = new Daemon();
		A a = new A();
		Thread t = new Thread(d);
		t.setDaemon(true);//必须在start方法前设置，不能在start方法后设置。
		                  //原因：不能把一个正在运行的常规线程设置为守护线程。
		t.start();
		System.out.println("d是否为daemon线程?" + t.isDaemon());
	}
}
/*
 *************** jdk1.8运行结果***************
d是否为daemon线程?true
a是否为daemon线程？true
A
Daemon
 */
