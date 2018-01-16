/*
    时间：2015年12月26日08:54:08
    目的：应用static记录对象的个数。
*/
class A
{
	  private int i;
	  private static int cnt = 0;//  用静态的可以少占空间，100个用一个空间就行
	  
	  public A()// 无参的
	  {
	  	  ++cnt;
	  }
	  
//	  public A(int i)// 有参的
//	  {
//	  	  this.i = i;
//	  	  ++cnt;
//	  }
	  
	  public static int getCnt()
	  {
	  	  return cnt;//返回的是A对象的个数
	  }
}
class Static_5
{
		public static void main(String[] args)
		{
			  System.out.printf("当前时刻A对象的个数：%d\n", A.getCnt());// 这里的A.getCnt()  用到static的应用
			  A aa1 = new A();
			  System.out.printf("当前时刻A对象的个数：%d\n", A.getCnt());
			  A aa2 = new A();
			  System.out.printf("当前时刻A对象的个数：%d\n", A.getCnt());
	  }
}	 
/*
***************结果***************
当前时刻A对象的个数：0
当前时刻A对象的个数：1
当前时刻A对象的个数：2
*/ 