/*
    ʱ�䣺2015��12��31��09:00:00
    Ŀ�ģ��������ʱ�ļ�㷽����
*/
package bao2;

class A
{
    public void f()
    {
	System.out.printf("AAAA\n");
    }
}

public class Package_2
{
    public static void main(String[] args)
    {
	A aa = new A();
	aa.f();
    }
}
/*
***************���***************
F:\java\����\package A>javac -d . Package_2.java    ����д�����Զ����ɰ�

F:\java\����\package A>java bao2.Package_2
AAAA
*/
