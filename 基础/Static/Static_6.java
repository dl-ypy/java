/*
    ʱ�䣺2015��12��26��14:19:12
    Ŀ�ģ�ͨ��staticֻ����һ������
*/
class A
{
	  public int i = 20;
	  public static A aa = new A();//aa�൱��һ��ָ�룬��ָ��������
	                               //������static�ģ���Ϊ�����һ����̬����Ҫ������
	  public A()
	  {
	  	  
	  }   
	  
	  public static A getA()//������static�ģ���Ϊ������Ҫֱ��ͨ���������ʸ÷���
	  {
	  	  return aa;
	  }                          
}

class Static_6
{
	  public static void main(String[] args)
	  {
	  	  A aa1 = A.getA();
	  	  A aa2 = A.getA();
	  	  
	  	  if (aa1 == aa2)
	  	      System.out.printf("aa1��aa2��ȣ�������һ������\n");
	  	  else
	  	      System.out.printf("aa1��aa2����ȣ���������������\n"); 
	  }
}
/*
***************���***************
aa1��aa2��ȣ�������һ������
*/