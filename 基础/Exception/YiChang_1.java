/*
    ʱ�䣺2016��1��1��13:23:16
    Ŀ�ģ��˽��쳣��
          �쳣���Ǳ���ʱ�Ĵ��󣬶�������ʱ�Ĵ���
          ����Exception����new�ġ�
*/
class A
{
    int divide(int a, int b)//  ��    
    {
	int m;
	m = a/b;//   ��0�Ļ����ڴ˴�����
	return m;
    }
    
}

public class YiChang_1
{
    public static void main(String[] args)
    {
	A aa = new A();

	try
	{
	    aa.divide(6, 0);//   �����׳��쳣����䡣
	}
	catch(ArithmeticException e)// e��������12���׳����쳣����
		                    // Ҳ��дΪException e  ��ΪException����������쳣�ࡣ
	{
	    e.printStackTrace();// �ɼ����Ϊ ������쳣�ľ�����Ϣ
            System.out.printf("������󣬳�������Ϊ�㡣\n");
	}

	System.out.printf("����Ĵ����Ѿ����!\n");//  ��������������⻹���ټ������С�
    }
}
/*
***************���***************
F:\java\����>javac YiChang_1.java

F:\java\����>java YiChang_1
java.lang.ArithmeticException: / by zero
        at A.divide(YiChang_1.java:11)
        at YiChang_1.main(YiChang_1.java:25)
������󣬳�������Ϊ�㡣
����Ĵ����Ѿ����!
*/
