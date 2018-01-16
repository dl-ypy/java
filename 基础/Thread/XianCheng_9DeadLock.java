/*
    ʱ�䣺2016��11��23��08:47:11
    Ŀ�ģ��߳�ͬ��--����
*/
public class XianCheng_9DeadLock implements Runnable{
	public int flag = 1;
	static Object o1 = new Object(), o2 = new Object();  //����ʹ��static��Ϊ��ʹ��������ʹ��ͬ��ͬ�����ԡ�
	
	public static void main(String[] args){
		XianCheng_9DeadLock td1 = new XianCheng_9DeadLock();
		XianCheng_9DeadLock td2 = new XianCheng_9DeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t2.start();
	}
	
	public void run(){
		System.out.println("flag=" + flag);
		if (flag == 1){
			
			synchronized(o1){
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					 e.printStackTrace();
				}
			
				synchronized(o2){
					System.out.println("1");//Ҫ��ִ�д�������ͬʱ����o1��o2
																	//��ʱ�Ѿ�������o1,��Ҫ����o2,��flag=0���߳�������o2
				}
			}
		}
		
		if (flag == 0){
			
			synchronized(o2){
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					 e.printStackTrace();
				}
			
				synchronized(o1){
					System.out.println("0");//Ҫ��ִ�д�������ͬʱ����o1��o2
																	//��ʱ�Ѿ�������o2,��Ҫ����o1,��flag=1���߳�������o1
				}
			}
		}
	}
}
/*
***************JDK1.8���н��***************
flag=1
flag=0
*/