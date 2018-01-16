/*
    时间：2016年1月2日17:35:58
    目的：printStackTrace方法的介绍。
          调试的时候写，能查找错误的路径。
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
***************结果***************
java.lang.ArithmeticException: / by zero
        at A.divide(YiChang_4.java:10)
        at A.g(YiChang_4.java:20)
        at A.f(YiChang_4.java:15)
        at YiChang_4.main(YiChang_4.java:30)
*/
