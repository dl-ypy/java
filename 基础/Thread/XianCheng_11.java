/*
    ʱ�䣺2016��11��29��08:28:31
    Ŀ�ģ��߳�ͬ��--ִ�й���
*/
public class XianCheng_11 implements Runnable{ 
	int a = 100;
	
	public static void main(String[] args) throws Exception{
		XianCheng_11 x = new XianCheng_11();
		Thread t = new Thread(x);
		t.start();
		
		x.m2();
		System.out.println(x.a);
	}
	
	public synchronized void m1() throws Exception{
		a = 1000;
		Thread.sleep(5000);
		System.out.println("a=" + a);
	}
	
	public synchronized void m2() throws Exception{
		Thread.sleep(2500);
		a = 2000;
	}
	
	public void run(){
		try {
			m1();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
/*
***************JDK1.8���н��***************
��m2����synchronized:
2000
a=2000
��m2��synchronized:
1000
a=1000
*/
/*
***************ִ�й���***************
����synchronized��������������ͬʱִ�С�
���������ִ�������߳���ִ�����̣߳��������߳�˯�߹�һ�κ󣬽�����ֻҪ���̲߳�˯�ߣ���һ������ִ�����̡߳�
��m2����synchronized:
main -> t.start()�������߳� -> ���߳�ִ�У�x.m2(),sleep(2500),��ʱ����Ϊm2û���������ԣ����߳̿�ִ�У���a=1000,sleep(5000),��Ϊm2û����,���ԣ����߳̿ɼ���ִ��m2,��a=2000,���a -> ����ִ�����̣߳����a=2000��
��m2��synchronized:
main -> t.start()�������߳� -> ���̼߳���ִ�У�x.m2()��synchronized�Ե�ǰ���������ֻ��ִ���굱ǰ���������̲߳���ִ��ͬ��������m1,��a=2000,ִ����m2��������ִ�����߳� -> ���߳�ִ��m1��������a=1000,sleep(5000)��
ִ�����̣߳����1000����ִ�����߳����a=1000
*/