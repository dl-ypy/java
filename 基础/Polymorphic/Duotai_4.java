/*
    ʱ�䣺2015��12��27��18:54:47
    Ŀ�ģ�ͨ����������ܵ����������еĳ�Ա����ͨ�� ������ = ���ࡱ����ʵ�ֵ��á�
                                        
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

    public void g()
    {
	System.out.printf("GGGG\n");
    }
}

public class Duotai_4
{
		public static void h(A aa)
		{
				B bb = new B();
				aa.f();
				aa = bb;
				bb = (B)aa;//����ǿ��ת��Ϊ����
				bb.g();//ʹ���ڸ÷������ܹ������������еķ���
		}
    public static void main(String[] args)
    {
				A aa = new A();
				B bb = new B();

				//aa.g();//  error g����������B���еģ�����ͨ�����������á�
				h(bb);
    }
}
/*
***************���***************
BBBB
GGGG
*/
