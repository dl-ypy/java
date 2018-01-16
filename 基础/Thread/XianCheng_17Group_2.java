import java.util.concurrent.TimeUnit;

/**
 * date:2017��6��4��09:08:49
 * target:�߳���Ŀ��ơ�
 * @author ypy
 */
class Thread1 implements Runnable {
	@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": ��ʼ���в���˯��10s");
        try {
            TimeUnit.SECONDS.sleep(10);//��Thread.sleep�����İ�װ
        } catch (InterruptedException e) {
            System.out.printf("%s: Interrupted.\n", Thread.currentThread().getName());
            return;
        }
        System.out.println(Thread.currentThread().getName() + "������");
    }
	
}
public class XianCheng_17Group_2 {
	public static void main(String[] args) {
		//�õ���ǰ�߳���
		ThreadGroup sys = Thread.currentThread().getThreadGroup();
		sys.list();
		
		sys.setMaxPriority(Thread.MAX_PRIORITY-1);//�����߳�������ȼ�
		Thread curr = Thread.currentThread();
		curr.setPriority(curr.getPriority()+1);//�����̵߳����ȼ�
		sys.list();
		
		System.out.println("-------------------");
		
		ThreadGroup group = new ThreadGroup("group");
		group.setMaxPriority(Thread.MAX_PRIORITY-5);//�����߳�������ȼ��������߳����е����̵߳����ȼ�������ڸ��߳�������ȼ�
		for (int i=0; i<5; i++) {
			Thread t = new Thread(group, new Thread1());
			t.start();
			try {
				TimeUnit.MILLISECONDS.sleep(500);//�ȴ����̶߳�ִ���꣬������˯��0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		group.list();

		System.out.println("-------------------");
		group.setMaxPriority(Thread.MIN_PRIORITY);//�������̺߳󣬸����߳�������ȼ�������Ӱ�����е��߳����ȼ���
												  //�߳���������ȼ��ı仯�����ܶ������߳����Ӱ�졣
		group.list();
		
		System.out.println("-------------------");
		Thread t1 = new Thread(group, "thread1");
		t1.start();
		group.list();
		
		System.out.println("-------------------");
		ThreadGroup group2 = new ThreadGroup(group, "group2");
		group2.setMaxPriority(10);//�½������߳�������ȼ�������ڸ��߳�������ȼ���
		Thread t2 = new Thread(group2, "thread2");
		t2.start();
		group.list();
	}
}
/*
 *************** jdk1.8���н��***************
java.lang.ThreadGroup[name=main,maxpri=10]
    Thread[main,5,main]
java.lang.ThreadGroup[name=main,maxpri=9]
    Thread[main,6,main]
-------------------
Thread-0: ��ʼ���в���˯��10s
Thread-1: ��ʼ���в���˯��10s
Thread-2: ��ʼ���в���˯��10s
Thread-3: ��ʼ���в���˯��10s
Thread-4: ��ʼ���в���˯��10s
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
Thread-0������
Thread-1������
Thread-2������
Thread-3������
Thread-4������
 */
