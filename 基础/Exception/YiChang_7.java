/*
    ʱ�䣺2016��1��15��10:30:06
    Ŀ�ģ��쳣������֪ʶ��
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
    void f() throws A,B//�������Ϊthrows A��B,Ҳ����throws A,B,Ҳ����˵����throws�ķ�Χ����<=���࣬���ڶ�̬�Ĺ�ϵ
    {
    }
}

class Test
{
    public void k(M mm)//��������A��B������catch
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
С֪ʶ��1.��catch���࣬��catch����
        2.catch��catch֮�䲻������������
*/
