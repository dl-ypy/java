/*
    ʱ�䣺2015��12��27��10:47:19
    Ŀ�ģ���������д��
          ֻ�м̳е�ʱ��Ż�����д��
*/
class A
{
	  public void f()
	  {
	  	  System.out.printf("AAAA\n");
	  }
}

class B extends A
{
	  public void f()// ��д�ķ�����
	  {
	  	  super.f(); // ���ôӸ���̳й�����f������
	  	  System.out.printf("BBBB\n");
	  }
}

public class fangfachongxie_1
{
	  public static void main(String[] zhangsan)//����ԭ����args�����ı�����һ���βΣ�����д��ʲô���ֶ�����ν��
	  {
	      B bb = new B();
	      bb.f();
	  }
}
/*
***************���***************
AAAA
BBBB
*/