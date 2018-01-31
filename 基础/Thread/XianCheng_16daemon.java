/**
 * date:2017��6��1��20:58:08
 * target:daemon���ػ����̡߳�
 * @author ypy
 * conclusion��
 *     java���̷߳�Ϊ����: �û��̺߳�daemon�̡߳�
 *     daemon�߳���Ϊ���Ǵ������û��߳��ṩ������߳�,����˵jvm��GC�ȵȡ�
 *     �ػ��̴߳����Ĺ�������Ҫ�ȵ���setDaemon������������,Ȼ���������߳�.����ᱨ��IllegalThreadStateException�쳣��
 *     ���û��߳����н�����ʱ��,daemon�߳̽����Զ��˳�(����ʱ����System.in.read()�����û��߳��������ػ��̵߳������Ϣ)��
 *     daemon�̴߳��������߳���Ȼ��daemon�̡߳�
 *     �������е�Ӧ�ö����Է����Daemon�߳������з��񣬱����д�������߼����߼�����Ϊ��Daemon Thread��û���ļ����в���ʱ������������Ѿ��˳��ˡ�
 *     ʵ��Ӧ�ã��ٸ����ӣ�web�������е�Servlet����������ʱ��̨��ʼ��һ�������̣߳��������̣߳�������http����Ȼ��ÿ��������������̴߳��̳߳���ȡ��һ���������߳�����������󣬴Ӷ�ʵ�ֲ������Ƶ�Ŀ�ġ�
 */
class Daemon implements Runnable {
	@Override
	public void run() {
		A a = new A();
		Thread t = new Thread(a);
		t.start();
		System.out.println("a�Ƿ�Ϊdaemon�̣߳�" + t.isDaemon());
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
		t.setDaemon(true);//������start����ǰ���ã�������start���������á�
		                  //ԭ�򣺲��ܰ�һ���������еĳ����߳�����Ϊ�ػ��̡߳�
		t.start();
		System.out.println("d�Ƿ�Ϊdaemon�߳�?" + t.isDaemon());
	}
}
/*
 *************** jdk1.8���н��***************
d�Ƿ�Ϊdaemon�߳�?true
a�Ƿ�Ϊdaemon�̣߳�true
A
Daemon
 */
