class A
{
    int i;
    int j;

    public void show()
    {
        System.out.printf("���÷�����i = %d\n", i);
    }
}

public class neicunfenpei {
    public static void main(String[] args)
    {
    	A aa = new A();//new A �ȼ���(A *)malloc(sizeof(A));
    	    // new A(); �ڶ��ж�̬����һ�����򣬱�����A����
    	    // aa������ڴ�����ջ�о�̬�����
    	    // �����ڴ�ĵ�ַ������aa
    	    // aaָ����е��ڴ棬aa�����˶��е��ڴ�
    	    // aa.i ����aa�����ָ̬�������ָ��Ķ�̬�ڴ��е�A����ĳ�Աi
        A aa2 = new A();
    	aa.i = 10;
        aa2.i = 20;
    	aa.j = 20;

    	System.out.printf("aa.i = %d, a.j = %d\n", aa.i, aa.j);

        aa2 = aa;   //�����ʹ��aa2��aaָ��ͬһƬ�ռ�

        System.out.printf("aa.i = %d\n", aa.i);

        aa.show();

        aa.i = 50;

        System.out.printf("aa2.i = %d\n", aa2.i);

        aa2.show();
    }
}
/*
***************���***************
aa.i = 10, a.j = 20
aa.i = 10
���÷�����i = 10
aa2.i = 50
���÷�����i = 50
*/
