/*
    时间：2015年12月26日14:19:12
    目的：通过static只生成一个对象
*/
class A
{
	  public int i = 20;
	  public static A aa = new A();//aa相当于一个指针，能指向它本身
	                               //必须是static的，因为下面的一个静态方法要调用它
	  public A()
	  {
	  	  
	  }   
	  
	  public static A getA()//必须是static的，因为主类中要直接通过类名访问该方法
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
	  	      System.out.printf("aa1和aa2相等，生成了一个对象。\n");
	  	  else
	  	      System.out.printf("aa1和aa2不相等，生成了两个对象。\n"); 
	  }
}
/*
***************结果***************
aa1和aa2相等，生成了一个对象。
*/