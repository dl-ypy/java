/*
    ʱ�䣺2015��12��25��21:55:24
    Ŀ�ģ�static��Ӧ�á�
    ������֤���ˣ�static����i�������౾�����߽���û�ж�����Ȼ����ֱ��ͨ�������ķ�ʽ���ʸ����static����i��
                  static����ͬ��
                  ������Ȼ��static���Ժͷ���Ҳ����ͨ�����������Ķ������
*/
class A
{
    //public int i = 10;  �����������﷨����
    public static int i = 10; 
    
    public static void f()
    {
        System.out.printf("123\n");
    }
}

class Static_2   //  �������в�û�д�������A aa = new A();
{
    public static void main(String[] args)
    {
        System.out.printf("i = %d\n", A.i);
        A.f();
    }
    
}
/*
***************���***************
i = 10
123
*/