/*
    ʱ�䣺2015��12��27��10:58:38
    Ŀ�ģ���������д��
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
	  public void f()//����ķ���Ȩ�ޱ��� >= ����ķ���Ȩ��
	  {
	  	  System.out.printf("BBBB\n");
	  }
	  
//	  public int f()   ��дʱ����ֵ�����ͣ����������βα�����ͬ��
//	  {
//	  	  System.out.printf("BBBB\n");
//	  }
}

public class fangfachongxie_2
{
	  public static void main(String[] args)
	  {
	  	  B bb = new B();
	  	  bb.f();
	  }
}
/*
***************���***************
BBBB
*/