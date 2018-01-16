/*
    时间：2016年1月31日17:21:11
    目的：线程的控制之睡眠。
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

	    try  //必须用try  catch，不能用throws抛异常，因为是复写的接口的方法，接口方法没有对其进行处理，所以只能在这里进行处理。
	    {
		Thread.sleep(1000);//睡眠1秒，进入阻塞状态，1秒后进入就绪状态。
	    }
	    catch (Exception e)
	    {
	    }
	}
    }
}
/*
***************结果***************
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
