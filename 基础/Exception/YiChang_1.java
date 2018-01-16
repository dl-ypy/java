/*
    时间：2016年1月1日13:23:16
    目的：了解异常。
          异常不是编译时的错误，而是运行时的错误。
          所有Exception都是new的。
*/
class A
{
    int divide(int a, int b)//  除    
    {
	int m;
	m = a/b;//   除0的话，在此处出错。
	return m;
    }
    
}

public class YiChang_1
{
    public static void main(String[] args)
    {
	A aa = new A();

	try
	{
	    aa.divide(6, 0);//   可能抛出异常的语句。
	}
	catch(ArithmeticException e)// e用来接收12行抛出的异常对象
		                    // 也可写为Exception e  因为Exception是最根部的异常类。
	{
	    e.printStackTrace();// 可简单理解为 输出该异常的具体信息
            System.out.printf("除零错误，除数不能为零。\n");
	}

	System.out.printf("上面的错误已经解决!\n");//  处理了上面的问题还能再继续运行。
    }
}
/*
***************结果***************
F:\java\基础>javac YiChang_1.java

F:\java\基础>java YiChang_1
java.lang.ArithmeticException: / by zero
        at A.divide(YiChang_1.java:11)
        at YiChang_1.main(YiChang_1.java:25)
除零错误，除数不能为零。
上面的错误已经解决!
*/
