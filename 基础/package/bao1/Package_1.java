/*
    ʱ�䣺2015��12��30��22:20:16
    Ŀ�ģ����˽����
*/
package bao1;//  �����ǵ�һ�����

class A
{
    public void f()
    {
        System.out.printf("AAAA\n");
    }
}

class Package_1
{
    public static void main(String[] args)
    {
	A aa = new A();
	aa.f();
    }
}
/*
***************���***************
F:\java\����\package A>javac Package_1.java

F:\java\����\package A>java Package_1      ������Ϊ���е�ʱ��û���Զ����ɰ�����Ҫ�ֶ����������ҽ��ļ����ƶ���ȥ
����: �Ҳ������޷��������� Package_1

F:\java\����\package A>java Package_1      ��������Ϊ���е�ʱ��Ӧ��д java ����.�ļ���
����: �Ҳ������޷��������� Package_1

F:\java\����\package A>java bao1.Package_1
AAAA
*/

