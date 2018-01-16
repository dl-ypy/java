/*
    时间：2016年1月15日10:00:29
    目的：自定义异常。
*/
class DivisorIsZeroException extends Exception//此处最好是Exception,必须处理的异常
{
    public DivisorIsZeroException(String errorMessage)//参数为错误信息
    {
	super(errorMessage);//调用父类Exception的参数
    }
}

class A
{
    int divide(int a, int b)
    {
	try
	{
            if (0 == b)
	    {
                throw new DivisorIsZeroException("除数不能为零！");
            }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}

	int m = a / b;

	return m;
    }
}

public class YiChang_6zidingyi
{
    public static void main(String[] args)
    {
	A aa = new A();
	int i = aa.divide(6, 2);

	System.out.printf("i = %d\n", i);
    }
}
/*
***************结果***************
i = 3
*/
