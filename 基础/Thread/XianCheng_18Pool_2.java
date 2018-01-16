package dao;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * date:2017��6��6��08:28:11
 * target:�Զ����̳߳ء�
 * @author ypy
 * conclusion��
 *     ��ʵ�����ɿ�����6����������3�������߳���Ŀ�����߳���ִ�еġ�
 *     ���̳߳��е��߳���С�ں����߳������ͻᴴ�����̣߳�ֱ�����ں����߳�����
 *     ���߳�������corePoolSize������������δ�����ͻὫ������̷߳���ö��У������߳̿��г�����������ִ�С�
 *     ���߳�������corePoolSize���������������������߳���С������߳�������ᴴ���µ��߳���������ӵ�����
 *     ���������ˣ������������е��߳��������ڻ����maximumPoolSize���̳߳ػὫ���񴫵ݸ����һ������RejectedExecutionHandler������
 *     �����ӡ������־���׳��쳣���洢��Mysql/redis���ں����������Ͳ��ԣ��ȵȡ�
 *     
 *     �������е����ͣ�
 *         ArrayBlockingQueue���б߽���У���ʼ��ʱҪָ�����С����ָ�����ܸı䡣
 *         DelayQueue��Ԫ�ر���ʵ�� java.util.concurrent.Delayed�ӿڣ��ýӿ�ֻ��һ����������long getDelay(TimeUnit unit)��
 *                    ����ֵ���Ƕ���Ԫ�ر��ͷ�ǰ�ı���ʱ�䣬�������0����һ����ֵ������ζ�Ÿ�Ԫ���Ѿ�������Ҫ���ͷţ�
 *                    ��ʱDelayedQueue��ͨ����take()�����ͷŴ˶���DelayQueue��Ӧ���ڶ�ʱ�ر����ӡ�������󣬳�ʱ����ȸ��ֳ�����
 *         LinkedBlockingQueue�����д�С�������ǿ�ѡ�ģ���ָ����С�������б߽�ģ����򣬾����ޱ߽�ġ�����ʵ�ǲ�����Ĭ�ϴ�СΪInteger.MAX_VALUE��������
 *         PriorityBlockingQueue���ޱ߽磬�������null�����в���PriorityBlockingQueue�Ķ������ʵ�� java.lang.Comparable�ӿڣ�ͨ���˽ӿ�ָ���������
 *         SynchronousQueue��������һ��Ԫ�ء�
 *         ע��ʹ�õ�����Ӧ����LinkedBlockingQueue��һ�������Ҫ����һ�¶��д�С�����ó��н���У�����JVM�ڴ�ᱻ�ű���
 */
class Thread1 implements Runnable {
	@Override
    public void run() {
        System.out.println("run()�������Զ����ã�����  " + Thread.currentThread().getName());
    }
}

public class XianCheng_18Pool_2 {
	public static void main(String[] args) {
		//������������
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		//�����̳߳أ������߳���Ϊ3������߳���Ϊ5
		//�߳�û��ִ������ʱ����ౣ��50΢�����ֹ��Ȼ���߳���Ŀά���ں��Ĵ�С
		//bqueue��һ���������У������洢�ȴ�ִ�е����������ǰ���̵߳����󳬹��˺��Ĵ�С���Ż��������
		ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, bqueue);
		//��������
		Runnable t1 = new Thread1();//ֻ����Runnable����
		Runnable t2 = new Thread1();
		Runnable t3 = new Thread1();
		Runnable t4 = new Thread1();
		Runnable t5 = new Thread1();
		Runnable t6 = new Thread1();
		//ִ������
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		//�ر��̳߳�
		pool.shutdown();
	}
}
/*
 *************** jdk1.8���н��***************
run()�������Զ����ã�����  pool-1-thread-2
run()�������Զ����ã�����  pool-1-thread-3
run()�������Զ����ã�����  pool-1-thread-3
run()�������Զ����ã�����  pool-1-thread-3
run()�������Զ����ã�����  pool-1-thread-1
run()�������Զ����ã�����  pool-1-thread-2
 */
