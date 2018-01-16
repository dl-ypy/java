/*
    时间：2016年1月15日10:30:06
    目的：异常的其他知识。
*/
class A extends Exception
{
}

class B extends Exception
{
}

class C extends Exception
{
}

class M 
{
    void f() throws A,B
    {
    }
}

class N extends M
{
    void f() throws A,B//这里可以为throws A或B,也可以throws A,B,也就是说子类throws的范围必须<=父类，由于多态的关系
    {
    }
}

class Test
{
    public void k(M mm)//这里必须对A，B都进行catch
    {
	try
	{
	    mm.f();
	}
	catch(A aa)
	{
	    
	}
	catch(B bb)
	{
	}
    }
}

public class YiChang_7
{
    public static void main(String[] args)
    {
	M m = new M();
	Test t = new Test();

	t.k(m);
    }
}
/*
小知识：1.先catch子类，再catch父类
        2.catch和catch之间不能有其他代码
*/
