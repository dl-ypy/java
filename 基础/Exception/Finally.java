/*
    ʱ�䣺2016��1��13��15:42:18
    Ŀ�ģ�finally��ʹ�á�
*/
class A
{
    public int f(int n, int m)
    {
			int a = m / n;

			return m;
    }
}
public class Finally
{
    public static void main(String[] args)
    {
	try
	{
	    new A().f(6, 0);
	}
	catch(ArrayIndexOutOfBoundsException e)//���������쳣ԭ�����Բ��Ჶ��
	{
	    System.out.printf("222\n");//���ԣ���Щ���벻ִ��
	    e.printStackTrace();//���������쳣·�������˳����в����
	    //System.exit(0);   ������񵽶�Ӧ���쳣��ִ�е�catch�е����ʱ������ͻ���ֹ��finally���ֵ����Ͳ���ִ����
	}
	finally              //  �����쳣�������finally�еĴ��붼��ִ��
		             //  Ŀ���Ǳ�֤���ܳ��������������쳣����������Ҫ����finally�е�һЩ��Ҫ�����ṩһ��ͳһ���ͷų��ڣ���ص��ļ���
	{
	    System.out.printf("���try����return��䣬�������finallyǰִ�У�����finally�󷵻�\n");
	}
    }
}
/*
***************���***************
���try����return��䣬�������finallyǰִ�У�����finally�󷵻�

*/
