/*
    ʱ�䣺2016��11��23��09:12:06
    Ŀ�ģ��߳�ͬ��--����һ������ʱ�����������Ƿ����ִ�У�
*/
public class XianCheng_10 implements Runnable{ 
	int a = 100;
	
	public static void main(String[] args) throws Exception{
		XianCheng_10 x = new XianCheng_10();
		Thread t = new Thread(x);
		t.start();
		
		Thread.sleep(1000);//˯�ߣ�ȷ�����߳̿�ʼִ��
		x.m2();
	}
	
	public synchronized void m1() throws Exception{
		a = 1000;
		Thread.sleep(5000);
		System.out.println("a=" + a);
	}
	
	public void m2(){
		System.out.println(a);
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
a=1000
1000
*/
/*
***************����***************
��Ϊm2��������Ľ����1000�����ԣ������߳���������������ͬʱ��
���߳̿������з���������
*/