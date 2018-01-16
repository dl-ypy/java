/*
    时间：2016年1月31日09:01:32
    目的：线程常用方法。
*/
class A extends Thread
{
    public void run()
    {
	//System.out.println("AAAA");
	System.out.printf("%s在执行！\n", Thread.currentThread().getName());
    }
}

public class XianCheng_3
{
    public static void main(String[] args)
    {
	A aa1 = new A();
	aa1.start();

	A aa2 = new A();
	aa2.start();

	A aa3 = new A();
	aa3.start();
	//System.out.println("BBBB");
	System.out.printf("%s在执行！\n", Thread.currentThread().getName());
	//         获取正在运行线程的名字。
	//         执行顺序不定
    }
}
/*
***************结果***************
main在执行！
Thread-2在执行！
Thread-1在执行！
Thread-0在执行！
*/
