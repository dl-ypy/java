/*
    ʱ�䣺2016��1��15��10:00:29
    Ŀ�ģ��Զ����쳣��
*/
class DivisorIsZeroException extends Exception//�˴������Exception,���봦����쳣
{
    public DivisorIsZeroException(String errorMessage)//����Ϊ������Ϣ
    {
	super(errorMessage);//���ø���Exception�Ĳ���
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
                throw new DivisorIsZeroException("��������Ϊ�㣡");
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
***************���***************
i = 3
*/
