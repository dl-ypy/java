/*
    时间：2016年3月1日20:56:19
    目的：买票程序。
*/
class A implements Runnable
{
    public static int tickets = 100;
    String str = new String("哈哈");

    public void run()
    {
	while (true)
	{
	    synchronized (str)// 多线程互斥
	    {
		if (tickets > 0)
		{
		    System.out.printf("%s线程正在卖出第%d张票\n", Thread.currentThread().getName(), tickets);
		    --tickets;
		}
		else
		{
		    break;
		}
	    }
	}
    }
}

public class XianCheng_6
{
    public static void main(String[] args)
    {
	A aa = new A();
	Thread t1 = new Thread(aa);
	t1.start();

	Thread t2 = new Thread(aa);
	t2.start();
    }
}
/*
***************结果***************
Thread-0线程正在卖出第100张票
Thread-0线程正在卖出第99张票
Thread-0线程正在卖出第98张票
Thread-0线程正在卖出第97张票
Thread-1线程正在卖出第96张票
Thread-1线程正在卖出第95张票
Thread-1线程正在卖出第94张票
Thread-1线程正在卖出第93张票
Thread-1线程正在卖出第92张票
Thread-1线程正在卖出第91张票
Thread-1线程正在卖出第90张票
Thread-1线程正在卖出第89张票
Thread-1线程正在卖出第88张票
Thread-1线程正在卖出第87张票
Thread-1线程正在卖出第86张票
Thread-1线程正在卖出第85张票
Thread-1线程正在卖出第84张票
Thread-0线程正在卖出第83张票
Thread-0线程正在卖出第82张票
Thread-0线程正在卖出第81张票
Thread-0线程正在卖出第80张票
Thread-0线程正在卖出第79张票
Thread-0线程正在卖出第78张票
Thread-0线程正在卖出第77张票
Thread-0线程正在卖出第76张票
Thread-0线程正在卖出第75张票
Thread-0线程正在卖出第74张票
Thread-0线程正在卖出第73张票
Thread-0线程正在卖出第72张票
Thread-1线程正在卖出第71张票
Thread-1线程正在卖出第70张票
Thread-1线程正在卖出第69张票
Thread-1线程正在卖出第68张票
Thread-1线程正在卖出第67张票
Thread-1线程正在卖出第66张票
Thread-1线程正在卖出第65张票
Thread-1线程正在卖出第64张票
Thread-1线程正在卖出第63张票
Thread-0线程正在卖出第62张票
Thread-0线程正在卖出第61张票
Thread-0线程正在卖出第60张票
Thread-0线程正在卖出第59张票
Thread-0线程正在卖出第58张票
Thread-1线程正在卖出第57张票
Thread-1线程正在卖出第56张票
Thread-1线程正在卖出第55张票
Thread-1线程正在卖出第54张票
Thread-1线程正在卖出第53张票
Thread-1线程正在卖出第52张票
Thread-0线程正在卖出第51张票
Thread-0线程正在卖出第50张票
Thread-0线程正在卖出第49张票
Thread-1线程正在卖出第48张票
Thread-0线程正在卖出第47张票
Thread-0线程正在卖出第46张票
Thread-0线程正在卖出第45张票
Thread-0线程正在卖出第44张票
Thread-0线程正在卖出第43张票
Thread-0线程正在卖出第42张票
Thread-0线程正在卖出第41张票
Thread-1线程正在卖出第40张票
Thread-1线程正在卖出第39张票
Thread-1线程正在卖出第38张票
Thread-1线程正在卖出第37张票
Thread-1线程正在卖出第36张票
Thread-1线程正在卖出第35张票
Thread-1线程正在卖出第34张票
Thread-1线程正在卖出第33张票
Thread-1线程正在卖出第32张票
Thread-1线程正在卖出第31张票
Thread-1线程正在卖出第30张票
Thread-1线程正在卖出第29张票
Thread-1线程正在卖出第28张票
Thread-1线程正在卖出第27张票
Thread-1线程正在卖出第26张票
Thread-1线程正在卖出第25张票
Thread-1线程正在卖出第24张票
Thread-1线程正在卖出第23张票
Thread-1线程正在卖出第22张票
Thread-1线程正在卖出第21张票
Thread-1线程正在卖出第20张票
Thread-1线程正在卖出第19张票
Thread-1线程正在卖出第18张票
Thread-1线程正在卖出第17张票
Thread-1线程正在卖出第16张票
Thread-1线程正在卖出第15张票
Thread-1线程正在卖出第14张票
Thread-1线程正在卖出第13张票
Thread-1线程正在卖出第12张票
Thread-1线程正在卖出第11张票
Thread-1线程正在卖出第10张票
Thread-1线程正在卖出第9张票
Thread-1线程正在卖出第8张票
Thread-0线程正在卖出第7张票
Thread-0线程正在卖出第6张票
Thread-0线程正在卖出第5张票
Thread-0线程正在卖出第4张票
Thread-0线程正在卖出第3张票
Thread-0线程正在卖出第2张票
Thread-0线程正在卖出第1张票
*/
