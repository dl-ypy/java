/*   
    ʱ�䣺2016��1��30��08:32:04
    Ŀ�ģ������̶߳���
*/
class A implements Runnable//�����̵߳ĵڶ��ַ������ȽϺ�
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
***************���***************

*/
