/*
    时间：2016年1月29日09:14:40
    目的：创建线程。
*/
class A extends Thread//  Thread是线程，创建线程的第一种方式，继承比较死，继承这个类后就不能再继承其他类
{
    public void run()//run方法结束线程就结束
    {
	for (int i=0; i<100; i++)
	{
	    System.out.println("AAAA");
	}
    }
}
public class XianCheng_1
{
    public static void main(String[] args)
    {
	A aa = new A();
	//aa.run();  //这是单线程，先执行完子线程再执行主线程，即先输出AAAA，输完100次才输出BBBB
	aa.start();//会调用run方法，但是是多线程,AAAA和BBBB交替输出
	           //但一个对象只能调用一次
		   //属于就绪状态
	for (int i=0; i<100; i++)
	{
	    System.out.println("BBBB");
	}
    }
}
/*
***************结果***************

*/
