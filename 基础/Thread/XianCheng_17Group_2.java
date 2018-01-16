import java.util.concurrent.TimeUnit;

/**
 * date:2017年6月4日09:08:49
 * target:线程组的控制。
 * @author ypy
 */
class Thread1 implements Runnable {
	@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始运行并且睡眠10s");
        try {
            TimeUnit.SECONDS.sleep(10);//对Thread.sleep方法的包装
        } catch (InterruptedException e) {
            System.out.printf("%s: Interrupted.\n", Thread.currentThread().getName());
            return;
        }
        System.out.println(Thread.currentThread().getName() + "结束！");
    }
	
}
public class XianCheng_17Group_2 {
	public static void main(String[] args) {
		//得到当前线程组
		ThreadGroup sys = Thread.currentThread().getThreadGroup();
		sys.list();
		
		sys.setMaxPriority(Thread.MAX_PRIORITY-1);//设置线程组的优先级
		Thread curr = Thread.currentThread();
		curr.setPriority(curr.getPriority()+1);//设置线程的优先级
		sys.list();
		
		System.out.println("-------------------");
		
		ThreadGroup group = new ThreadGroup("group");
		group.setMaxPriority(Thread.MAX_PRIORITY-5);//设置线程组的优先级，下面线程组中的子线程的优先级不会大于父线程组的优先级
		for (int i=0; i<5; i++) {
			Thread t = new Thread(group, new Thread1());
			t.start();
			try {
				TimeUnit.MILLISECONDS.sleep(500);//等待子线程都执行完，主程序睡眠0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		group.list();

		System.out.println("-------------------");
		group.setMaxPriority(Thread.MIN_PRIORITY);//创建完线程后，更改线程组的优先级，但不影响已有的线程优先级。
												  //线程组最大优先级的变化并不能对现有线程造成影响。
		group.list();
		
		System.out.println("-------------------");
		Thread t1 = new Thread(group, "thread1");
		t1.start();
		group.list();
		
		System.out.println("-------------------");
		ThreadGroup group2 = new ThreadGroup(group, "group2");
		group2.setMaxPriority(10);//新建的子线程组的优先级不会大于父线程组的优先级。
		Thread t2 = new Thread(group2, "thread2");
		t2.start();
		group.list();
	}
}
/*
 *************** jdk1.8运行结果***************
java.lang.ThreadGroup[name=main,maxpri=10]
    Thread[main,5,main]
java.lang.ThreadGroup[name=main,maxpri=9]
    Thread[main,6,main]
-------------------
Thread-0: 开始运行并且睡眠10s
Thread-1: 开始运行并且睡眠10s
Thread-2: 开始运行并且睡眠10s
Thread-3: 开始运行并且睡眠10s
Thread-4: 开始运行并且睡眠10s
java.lang.ThreadGroup[name=group,maxpri=5]
    Thread[Thread-0,5,group]
    Thread[Thread-1,5,group]
    Thread[Thread-2,5,group]
    Thread[Thread-3,5,group]
    Thread[Thread-4,5,group]
-------------------
java.lang.ThreadGroup[name=group,maxpri=1]
    Thread[Thread-0,5,group]
    Thread[Thread-1,5,group]
    Thread[Thread-2,5,group]
    Thread[Thread-3,5,group]
    Thread[Thread-4,5,group]
-------------------
java.lang.ThreadGroup[name=group,maxpri=1]
    Thread[Thread-0,5,group]
    Thread[Thread-1,5,group]
    Thread[Thread-2,5,group]
    Thread[Thread-3,5,group]
    Thread[Thread-4,5,group]
    Thread[thread1,1,group]
-------------------
java.lang.ThreadGroup[name=group,maxpri=1]
    Thread[Thread-0,5,group]
    Thread[Thread-1,5,group]
    Thread[Thread-2,5,group]
    Thread[Thread-3,5,group]
    Thread[Thread-4,5,group]
    Thread[thread1,1,group]
    java.lang.ThreadGroup[name=group2,maxpri=1]
        Thread[thread2,1,group2]
Thread-0结束！
Thread-1结束！
Thread-2结束！
Thread-3结束！
Thread-4结束！
 */
