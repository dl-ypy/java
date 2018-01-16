/*
    时间：2015年12月27日10:58:38
    目的：方法的重写。
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
	  public void f()//子类的访问权限必须 >= 父类的访问权限
	  {
	  	  System.out.printf("BBBB\n");
	  }
	  
//	  public int f()   重写时返回值的类型，方法名和形参必须相同。
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
***************结果***************
BBBB
*/