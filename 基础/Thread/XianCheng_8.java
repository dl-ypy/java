/*
    ʱ�䣺2016��11��21��08:33:36
    Ŀ�ģ��߳�ͬ��--synchronized
    ע���򵥵�����ͬ��������ֻ�Ե�����һ��������Ч������������������������ڲ�����Ч�ģ�������������֮������Ч�ģ�����java��װ��AtomicXXX���棬��AtomicInteger��
        �������ԭ���ԣ���������synchronizedʵ�ֵģ�����ϵͳ�ײ�ʵ�ֵģ�����Ч�ʸߡ�
*/
public class XianCheng_8 implements Runnable{
	Timer timer = new Timer();
	public static void main(String[] args){
		XianCheng_8 x = new XianCheng_8();
		Thread t1 = new Thread(x);
		Thread t2 = new Thread(x);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	} 
	public void run(){
		timer.add(Thread.currentThread().getName());
		timer.add2(Thread.currentThread().getName());
	}
}

class Timer{
	private static int num = 0;
	private static int num1 = 0;
	//�������synchronized������һ���߳�sleepʱ���ڶ����߳̾ͻ�ִ�У�num++�ͻ���ִ��һ�Σ����Ա��2
	public void add(String name){
		num++;
		try{
			Thread.sleep(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name+",���ǵ�"+num+"��ʹ��Timer��add�������߳�");
	}
	//����synchronized����ִ�и÷����Ĺ����У���ǰ��������
	//��ʹһ���߳�sleep��Ҳ����ִ����һ���̣߳�����һ���߳�ִ���꣬��ִ����һ���߳�
	// Ҳ����synchronized(this  ������������ķ���tatic�ģ��൱��synchronized(����.class)
	// synchronized��õ���������ģ�����ͬһ�߳��£�ͬһ�����ǿ����ظ�����ʹ�õ�
	// �����쳣ʱ��Ĭ��������ᱻ�ͷţ���Ҫ����try...catch
	public synchronized void add2(String name){
		num1++;
		try{
			Thread.sleep(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name+",���ǵ�"+num1+"��ʹ��Timer��add2�������߳�");
	}
}
/*
***************���***************
t1,���ǵ�2��ʹ��Timer��add�������߳�
t2,���ǵ�2��ʹ��Timer��add�������߳�
t1,���ǵ�1��ʹ��Timer��add2�������߳�
t2,���ǵ�2��ʹ��Timer��add2�������߳�
*/