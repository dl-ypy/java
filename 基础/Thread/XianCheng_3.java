/*
    ʱ�䣺2016��1��31��09:01:32
    Ŀ�ģ��̳߳��÷�����
*/
class A extends Thread
{
    public void run()
    {
	//System.out.println("AAAA");
	System.out.printf("%s��ִ�У�\n", Thread.currentThread().getName());
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
	System.out.printf("%s��ִ�У�\n", Thread.currentThread().getName());
	//         ��ȡ���������̵߳����֡�
	//         ִ��˳�򲻶�
    }
}
/*
***************���***************
main��ִ�У�
Thread-2��ִ�У�
Thread-1��ִ�У�
Thread-0��ִ�У�
*/
