/*
    ʱ�䣺2015��12��25��22:27:20
    Ŀ�ģ�static��Ӧ�á�
    ������֤���ˣ�ֻ�з�private��static��Ա�ſ���ͨ����������
*/
class A
{
    private static int i = 30;
}

class Static_3
{
    public static void main(String[] args)
    {
        System.out.printf("i = %d\n", A.i);
    }
}
/*
***************���***************
Static_3.java:15: ����: i������A�з���private
        System.out.printf("i = %d\n", A.i);
                                       ^
*/