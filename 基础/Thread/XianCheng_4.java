/*
    ʱ�䣺2016��1��31��17:21:11
    Ŀ�ģ��̵߳Ŀ���֮˯�ߡ�
*/
public class XianCheng_4
{
    public static void main(String[] args)
    {
			A aa = new A();
			Thread tt = new Thread(aa);
			tt.start();
    }
}

class A implements Runnable
{
    public void run()
    {
	for (int i=0; i<10; i++)
	{
	    System.out.println(Thread.currentThread().getName() + i);

	    try  //������try  catch��������throws���쳣����Ϊ�Ǹ�д�Ľӿڵķ������ӿڷ���û�ж�����д�������ֻ����������д���
	    {
		Thread.sleep(1000);//˯��1�룬��������״̬��1���������״̬��
	    }
	    catch (Exception e)
	    {
	    }
	}
    }
}
/*
***************���***************
Thread-00
Thread-01
Thread-02
Thread-03
Thread-04
Thread-05
Thread-06
Thread-07
Thread-08
Thread-09
*/
