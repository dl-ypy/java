/*
    ʱ�䣺2016��1��29��09:14:40
    Ŀ�ģ������̡߳�
*/
class A extends Thread//  Thread���̣߳������̵߳ĵ�һ�ַ�ʽ���̳бȽ������̳�������Ͳ����ټ̳�������
{
    public void run()//run���������߳̾ͽ���
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
	//aa.run();  //���ǵ��̣߳���ִ�������߳���ִ�����̣߳��������AAAA������100�β����BBBB
	aa.start();//�����run�����������Ƕ��߳�,AAAA��BBBB�������
	           //��һ������ֻ�ܵ���һ��
		   //���ھ���״̬
	for (int i=0; i<100; i++)
	{
	    System.out.println("BBBB");
	}
    }
}
/*
***************���***************

*/
