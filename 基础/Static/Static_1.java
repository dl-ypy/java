/*
    2015��12��25��21:31:18
    Ŀ�ģ�static��Ӧ�á�
    ������֤���ˣ�A��Ķ��������һ��static����i��
    ע��static����Ϊ��̬��ȫ�ֱ����������࣬���Բ����ڷ������涨��static������
        static�������ι��췽������Ϊ���췽�����ഴ������ʱ���õģ����������ڶ��󣬶�static�������ڶ���
*/
class A
{
    //public int i = 10;    aa2.show();�����Ϊ i = 10
    public static int i = 10; //  ��ʱ���Ϊ i = 20
    
    public void show()
    {
        System.out.printf("i = %d\n", i);
    }
}

class Static_1
{
    public static void main(String[] args)
    {
        A aa1 = new A();
        A aa2 = new A();
        
        aa1.i = 20;
        aa2.show();
    }
}
/*
***************���***************
i = 20
*/