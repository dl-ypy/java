/*
    ʱ�䣺2015��12��27��18:37:29
    Ŀ�ģ������ʵ�� ��������� = ������󡱡�
    			������� = �������
    			������� = (��������)�������
*/
class A
{
    public void f()
    {
	System.out.printf("AAAA\n");
    }
}

class B extends A
{
    public void f()
    {
	System.out.printf("BBBB\n");
    }
}

public class Duotai_3
{
    public static void main(String[] args)
    {
	A aa = new A();
	B bb = new B();

	aa = bb;// ��ʱaaָ��һ��B�����

	bb = (B)aa;// ǿ������ת��
	           // �����д aa = bb; ��Ȼ�﷨����ȷ�������е�ʱ���Ǵ����
	bb.f();
    }
}
/*
***************���***************
BBBB
*/
