/*   
    时间：2016年1月30日08:32:04
    目的：创建线程二。
*/
class A implements Runnable//创建线程的第二种方法，比较好
{
    public void run()
    {
	while (true)
	{
	    System.out.println("AAAA");
	}
    }
}
public class XianCheng_2
{
    public static void main(String[] args)
    {
	A aa = new A();
	
	//aa.start();
	Thread t = new Thread(aa);// public Thread(Runnable ob);
	t.start();

	while (true)
	{
	    System.out.printf("BBBB");
	}
    }
}
/*
***************结果***************

*/
