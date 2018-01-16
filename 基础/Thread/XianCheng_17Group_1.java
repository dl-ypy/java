/**
 * date:2017��6��3��09:26:34
 * target:�߳��顣
 * @author ypy
 * conclusion��
 *     �����̶߳�������һ���߳��顣�ǿ�����һ��Ĭ���߳��飬�����һ�������߳�ʱ��ȷָ�����顣
 *     ÿ��Ӧ�ö�������һ���̴߳�����ϵͳ�߳��顣����������̶߳���ָ��һ���飬���Ǿͻ��Զ�������ϵͳ�߳��顣
 *     �߳���Ҳ��������������߳��顣�����ڹ�������ָ�����߳���������ĸ��߳��顣
 *     ���ڴ���һ���߳����ʱ��û��ָ�����Ĺ�������ͬ�����Զ���Ϊϵͳ�߳����һ�����¡�
 *     ���ڡ���ȫ�����ߡ����ܡ���������ɲ�ʹ���߳���ġ�
 *     һ���̲߳����޸�λ���Լ����������������֮����κ��̡߳�
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
		ThreadGroup g = getThreadGroup().getParent().getParent();//��Ϊ������߳�����z��������������parent���ܵõ�y��x����Ϣ��
		g.list();//��ӡ����һ���߳����йص�������Ϣ
		Thread[] gALL = new Thread[g.activeCount()];//activeCount()���ش��߳���ͽ����߳�����Ϊ�����ȵ������߳����л�̵߳Ĺ�������
													//��Ϊ���ص�ֻ�ǻ���̣߳���TestThread1û��start���ǲ���ģ�����ֻ����һ���̡߳�
                                //�������̶߳��ǻ�ĵ�ʱ��ϵͳ�����ѡ��һ�����еģ������п���Ҳֻ����ʾһ���̡߳�
                                //Ҫ�뽫�߳����е��̶߳���ʾ�����������ÿ���߳�˯��һ����ʱ�䣬ʹ�������߳��л������С�
		g.enumerate(gALL);//��ָ��������Щ�̵߳ľ���������� gAll�
		for (int i=0; i<gALL.length; i++) {
			gALL[i].setPriority(Thread.MIN_PRIORITY); //�������ȼ�Ϊ��͵�1
			((TestThread1)gALL[i]).f();
		}
		g.list();
	}
}

public class XiangCheng_17Group_1 {
	public static void main(String[] args) {
		//�����߳���
		ThreadGroup x = new ThreadGroup("x");//û�е�һ�����������Ի��Զ�����ϵͳ�߳���,xΪ�߳�������֡�
		ThreadGroup y = new ThreadGroup(x, "y");
		ThreadGroup z = new ThreadGroup(y, "z");
		
		TestThread1 t1 = new TestThread1(x, "one");
		TestThread2 t2 = new TestThread2(z, "two");
	}
}
/*
 *************** jdk1.8���н��***************
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
