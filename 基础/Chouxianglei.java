/*
    ʱ�䣺2015��12��29��13:18:22
    Ŀ�ģ��������Ӧ��
    ע��abstract�������ι��췽������Ϊabstract���εķ�����ʾ����ʵ�֣�ֻ�б��̳к�Ż�ʵ�֣�
        �����췽�����ܱ��̳У���ʵ����һ������ʱһ����ʵ�֡�
        abstract�������α�����ֻ����������߷�����
*/
abstract class A//  �����ǳ�����
{
    abstract public void f();// ���󷽷�  �޷����壬�����зֺ� 
}

abstract class B//  �������п����зǳ��󷽷����ǳ��󷽷��ܹ���ߴ��븴��
                //����̳и���󣬷ǳ��󷽷����Բ�����д���ɵ���
{
    public void f()
    {
	
    }
}

abstract class C extends A// ������Ҫ�г��󷽷������������û��ʵ�ָ÷�������������ǳ����
{
    
}

class D extends A// ������ʵ�֣���д���˸÷�������������Ƿǳ�����
{
    public void f()
    {
	System.out.printf("DDDD\n");
    }
}

public class Chouxianglei
{
    public static void main(String[] args)
    {
	// A aa = new A(); ���ܶ���һ��������Ķ���
	D dd = new D();
	dd.f();

	A aa;//  ���Զ���һ�������������

	aa = dd;
	aa.f(); // ʵ�ֶ�̬
    }
}
/*
***************���***************
DDDD
DDDD
*/
