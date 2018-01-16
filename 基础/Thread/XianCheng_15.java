/**
 * Ŀ�ģ�wait��notify������ͬ���е����á�
 * ʱ�䣺2017��3��26��22:47:43
 * ִ�й��̣���ִ�����̣߳�������Դ����a��ִ��synchronized���еĴ��룬
 * 		     ִ�е�wait��ִֹͣ�У��ͷŶ���Դ����������ʱ�����߳̾Ϳ�ʼִ��
 * 		     ִ�е�notify�������黹��Դ��ִ����synchronized���еĴ��룬�ͷŶ���������ʱ��ִ���ĸ��߳�ȡ����cup��
 */
public class Liu
{
    public static void main(String[] args)
    {
	A a = new A();
	Thread t = new Thread(a);
	t.start();
	synchronized (a) {
		System.out.println(Thread.currentThread().getName() + "����ִ��...");
		System.out.println("�ͷŶ�����    wait...");
		try {
			a.wait();
			System.out.println("�黹�˶�������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    }
}

class A implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + "����ִ��...");
			System.out.println("�����黹������...");
			notify();
			System.out.println("����ִ���ӳ���");
		}
	}
}
/***************JDK1.8���н��***************
main����ִ��...
�ͷŶ�����    wait...
Thread-0����ִ��...
�����黹������...
����ִ���ӳ���
�黹�˶�������
*/
 