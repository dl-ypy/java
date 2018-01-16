package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * date:2017��6��5��12:30:03
 * target:�̳߳ء�
 * @author ypy
 * conclusion��
 *     Ϊʲôʹ���̳߳أ�
 *         ���߳���ÿstartʱ����������һ�����̣߳������������߳��Ѿ�����̶߳���ϵͳ�кܴ�Ŀ�����
 *         �̳߳غô���
 *         ������Դ���ģ�ͨ���ظ������Ѵ������߳̽����̴߳�����������ɵ����ģ�
 *         �����Ӧ�ٶȣ������񵽴�ʱ��������Բ���Ҫ�ȵ��̴߳�����������ִ�У�
 *         ����̵߳Ŀɹ����ԣ��߳���ϡȱ��Դ����������ƵĴ���������������ϵͳ��Դ�����ή��ϵͳ���ȶ��ԣ�ʹ���̳߳ؿ��Խ���ͳһ�ķ��䣬���źͼ�ء�
 *     �����ӿڣ�
 *         Executor��ֻ������һ������execute���÷���ִ��Runnable����
 *         ExecutorService���̳���Executor���ḻ��Executor�ӿڡ�
 *                         ExecutorService���������ڰ�������״̬�����С��رա���ֹ��
 *                         ��������������״̬����������shutdown��������ʱ�������ر�״̬��
 *                         ��ʱ��ζ��ExecutorService���ٽ����µ����񣬵�������ִ���Ѿ��ύ�˵����񣬵������Ѿ��ύ�˵�����ִ����󣬱㵽����ֹ״̬��
 *                         ���������shutdown����������ExecutorService��һֱ��������״̬�����Ͻ����µ�����ִ���µ����񣬷�������һ�㲻��Ҫ�ر���������һֱ���м��ɡ�
 *     ʹ���̳߳أ�
 *		   1�������̳߳�
 *			   (1).�����̶���Ŀ�̵߳��̳߳ء�
 *             (2).�����ɻ����̳߳ء�(����֮ѡ)
 *             (3).����һ�����̻߳���Executor��
 *             (4).����һ��֧�ֶ�ʱ�������Ե�����ִ�е��̳߳أ���������¿��������Timer�ࡣ
 *		   2����������
 *			   (1).Runnable����
 *			                 ����run�������޷���ֵ�������׳��쳣��
 *			   (2).Callable����
 *				       ����call���������ر�ʾ������ɵ�Future�����׳��쳣��
 *		   3��ִ������
 *		   4���ر��̳߳�
 */
class Thread1 implements Runnable {
	@Override
    public void run() {
        System.out.println("run()�������Զ����ã�����  " + Thread.currentThread().getName());
    }
}

class Thread2 implements Callable<String> {
	private int id;
	public Thread2(int id) {
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		System.out.println("call()�������Զ����ã�����  " + Thread.currentThread().getName()); 
		return "call()�������Զ����ã����񷵻صĽ���ǣ�" + id + "  " + Thread.currentThread().getName();
	}
}

public class XianCheng_18Pool {
	//�����̶���Ŀ�̵߳��̳߳�
	//����ʱ��㣬���ֻ���й̶���Ŀ�Ļ�̴߳��ڣ���ʱ������µ��߳�Ҫ������ֻ�ܷ�������Ķ����еȴ���ֱ����ǰ���߳���ĳ���߳���ֱֹ�ӱ��Ƴ�����
	//�����ڷ�����
	private static ExecutorService e = Executors.newFixedThreadPool(5);
	
	//����һ���ɻ����̳߳�
	//����execute��������ǰ������̣߳�����߳̿��ã���
	//��������߳�û�п��õģ��򴴽�һ������  �̲���ӵ����С���ֹ���ӻ������Ƴ���Щ���� 60 ����δ��ʹ�õ��̡߳�
	//�����������ڶ̵��첽����
	private static ExecutorService e1 = Executors.newCachedThreadPool();
	
	//����һ�������̡߳�
	//����ʱ�����ֻ����һ���߳�
	private static ExecutorService e2 = Executors.newSingleThreadExecutor();
	
	//����һ��֧�ֶ�ʱ�������Ե�����ִ�е��̳߳�
	//�����������߳̿��԰�schedule����delayִ�У�������ִ��
	private static ExecutorService e3 = Executors.newScheduledThreadPool(5);
	
	public static void main(String[] args) {
		List<Future<String>> resultList = new ArrayList<Future<String>>();
		//ִ��runnable����
		for (int i=0; i<5; i++) {
			e1.execute(new Thread1());//�ύ5������
		}
		
		//ִ��callable����
		for (int i=0; i<20; i++) {
			//ִ�����񲢽�����ֵ����future
			Future<String> future = e.submit(new Thread2(i));
			//������ִ�н���洢��List��
			resultList.add(future);
		}
		for (Future<String> fs : resultList) {
			while (!fs.isDone()) {//Future�������û����ɣ���һֱѭ���ȴ���ֱ��Future�������
				try {
					System.out.println(fs.get());//��ӡ�����̣߳�����ִ�еĽ�� 
												 //get�������ȴ�������ɣ�Ȼ���ȡ����
												 //���������ݻ�û׼����, ������߳̽�������
												 //��������Ҳ����һ�����ط��������������Ϊ���ܶ�û׼�������ݣ���������
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		e1.shutdown();//���ø÷����󣬽�����ExecutorServiceֹͣ�����κ��µ������ҵȴ��Ѿ��ύ������ִ����ɡ�
					  //�������Ѿ��ύ������ִ����Ϻ󽫻�ر�ExecutorService��
	}
}
/*
 *************** jdk1.8���н��***************
run()�������Զ����ã�����  pool-2-thread-2
run()�������Զ����ã�����  pool-2-thread-1
run()�������Զ����ã�����  pool-2-thread-4
run()�������Զ����ã�����  pool-2-thread-3
run()�������Զ����ã�����  pool-2-thread-5
call()�������Զ����ã�����  pool-1-thread-1
call()�������Զ����ã�����  pool-1-thread-3
call()�������Զ����ã�����  pool-1-thread-2
call()�������Զ����ã�����  pool-1-thread-2
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-4
call()�������Զ����ã�����  pool-1-thread-5
call()�������Զ����ã����񷵻صĽ���ǣ�4  pool-1-thread-5
 */
