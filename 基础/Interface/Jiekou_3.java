/*
    ʱ�䣺2015��12��29��15:16:14
    Ŀ�ģ��ӿ�ʵ�ֶ�̬��
*/
interface It
{
   void f();
}

class A implements It
{
    public void f()
    {
	System.out.printf("AAAA\n");
    }

    public void g()
    {
    }
}

class Jiekou_3
{
    public static void main(String[] args)
    {
	It it;// ����new�����ģ��ӿڵĶ�����new�������Զ���һ���ӿ��������͵ı���
	it = new A();// ָ��ʵ�ֽӿڵĶ���
	it.f();// ʵ�ֶ�̬����f()���������ǽӿ�It���е�
	//it.g();// ������Ϊg()�����������еĳ�Ա������ͨ������ӿ�ֱ�ӵ���
    }
}
/*
***************���***************
AAAA
*/
