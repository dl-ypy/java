/*
    ʱ�䣺2015��12��26��08:54:08
    Ŀ�ģ�Ӧ��static��¼����ĸ�����
*/
class A
{
	  private int i;
	  private static int cnt = 0;//  �þ�̬�Ŀ�����ռ�ռ䣬100����һ���ռ����
	  
	  public A()// �޲ε�
	  {
	  	  ++cnt;
	  }
	  
//	  public A(int i)// �вε�
//	  {
//	  	  this.i = i;
//	  	  ++cnt;
//	  }
	  
	  public static int getCnt()
	  {
	  	  return cnt;//���ص���A����ĸ���
	  }
}
class Static_5
{
		public static void main(String[] args)
		{
			  System.out.printf("��ǰʱ��A����ĸ�����%d\n", A.getCnt());// �����A.getCnt()  �õ�static��Ӧ��
			  A aa1 = new A();
			  System.out.printf("��ǰʱ��A����ĸ�����%d\n", A.getCnt());
			  A aa2 = new A();
			  System.out.printf("��ǰʱ��A����ĸ�����%d\n", A.getCnt());
	  }
}	 
/*
***************���***************
��ǰʱ��A����ĸ�����0
��ǰʱ��A����ĸ�����1
��ǰʱ��A����ĸ�����2
*/ 