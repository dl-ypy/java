/*
    ʱ�䣺2016��1��2��17:35:58
    Ŀ�ģ�printStackTrace�����Ľ��ܡ�
          ���Ե�ʱ��д���ܲ��Ҵ����·����
*/
class A
{
    int divide(int a, int b)
    {
	return a/b;
    }

    public void f()
    {
	g();
    }

    public void g()
    {
	divide(6, 0);
    }
}

public class YiChang_4
{
    public static void main(String[] args)
    {
	try
	{
	    new A().f();
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
}
/*
***************���***************
java.lang.ArithmeticException: / by zero
        at A.divide(YiChang_4.java:10)
        at A.g(YiChang_4.java:20)
        at A.f(YiChang_4.java:15)
        at YiChang_4.main(YiChang_4.java:30)
*/
