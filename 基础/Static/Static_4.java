/*
    ʱ�䣺2015��12��25��22:50:39
    Ŀ�ģ�static��Ӧ�á�
    ������֤���ˣ������ġ�
    why?
    ��ľ�̬��Ա(�����ͷ���)�����౾��������ص�ʱ��ͻ�����ڴ棬����ͨ������ֱ��ȥ���ʣ�
    �Ǿ�̬��Ա�������ͷ�����������Ķ�������ֻ������Ķ���������������ʵ����ʱ�Ż�����ڴ棬Ȼ��ͨ����Ķ���ʵ����ȥ���ʡ�
*/
class A
{
    public static int i = 10;
    public int j = 99;
    
    public static void f()
    {
        //g();error ��̬�������ܷ��ʷǾ�̬����
        //j = 1;error ��̬�������ܷ��ʷǾ�̬����
        System.out.printf("FFFF\n");	
    }
    
    public void g()
    {
    	  f();// �Ǿ�̬�����ܷ��ʾ�̬����
    	  System.out.printf("GGGG\n");
    	  System.out.printf("i = %d\n", i);//�Ǿ�̬�����ܷ��ʾ�̬����
    }
}

class Static_4
{
	  public static void main(String[] args)
	  {
	  	  A aa = new A();
	  	  
	  	  aa.f();
	  	  aa.g();
	  	  
	  }
}
/*
***************���***************
FFFF
FFFF
GGGG
i = 10
*/