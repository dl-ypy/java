/*
    时间：2015年12月25日22:50:39
    目的：static的应用。
    本程序证明了：见下文。
    why?
    类的静态成员(变量和方法)属于类本身，在类加载的时候就会分配内存，可以通过类名直接去访问；
    非静态成员（变量和方法）属于类的对象，所以只有在类的对象产生（创建类的实例）时才会分配内存，然后通过类的对象（实例）去访问。
*/
class A
{
    public static int i = 10;
    public int j = 99;
    
    public static void f()
    {
        //g();error 静态方法不能访问非静态方法
        //j = 1;error 静态方法不能访问非静态变量
        System.out.printf("FFFF\n");	
    }
    
    public void g()
    {
    	  f();// 非静态方法能访问静态方法
    	  System.out.printf("GGGG\n");
    	  System.out.printf("i = %d\n", i);//非静态方法能访问静态变量
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
***************结果***************
FFFF
FFFF
GGGG
i = 10
*/