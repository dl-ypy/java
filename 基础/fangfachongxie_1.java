/*
    时间：2015年12月27日10:47:19
    目的：方法的重写。
          只有继承的时候才会有重写。
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
	  public void f()// 重写的方法。
	  {
	  	  super.f(); // 调用从父类继承过来的f方法。
	  	  System.out.printf("BBBB\n");
	  }
}

public class fangfachongxie_1
{
	  public static void main(String[] zhangsan)//这里原本是args，它的本质是一个形参，所以写成什么名字都无所谓。
	  {
	      B bb = new B();
	      bb.f();
	  }
}
/*
***************结果***************
AAAA
BBBB
*/