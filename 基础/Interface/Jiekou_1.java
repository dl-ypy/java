/*
    ʱ�䣺2015��12��29��14:11:57
    Ŀ�ģ��ӿڵ�Ӧ�á�
          �ǳ��󷽷��ͳ���ֵ�ļ��ϣ���һ������ĳ����ࡣ
	  ���ѡ���ó����໹���ýӿڣ�
	      �ӿ��ǵ�һѡ��ֻ���ڱ���ʹ�÷���������߳�Ա��������Ϊ�ӿڵĳ�Ա������static final�ģ���ʱ�򣬲�Ӧ���ǲ��ó����ࡣ
*/
interface It
{
    //public void f()  �ӿ��в����зǳ��󷽷�
    //{
    //}
    int i = 10;//  ֻ����public static final���͵ģ����Կ���ʡ��
    public void f();//  ֻ����abstract public���͵� ����ʡ��
}

abstract class A implements It// ��implements��ʵ�ֽӿ�
                              // ��ΪIt���г��󷽷���������û����д�ó��󷽷��ǣ���������ǳ����
{
    
}

class B implements It
{
    public void f()
    {
	System.out.printf("i = %d", i);
    }
}

public class Jiekou_1
{
    public static void main(String[] args)
    {
	B bb = new B();
	bb.f();
    }
}
/*
***************���***************
i = 10
*/
