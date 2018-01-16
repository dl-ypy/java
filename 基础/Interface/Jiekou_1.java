/*
    时间：2015年12月29日14:11:57
    目的：接口的应用。
          是抽象方法和常量值的集合，是一种特殊的抽象类。
	  如何选择用抽象类还是用接口？
	      接口是第一选择，只有在必须使用方法定义或者成员变量（因为接口的成员变量是static final的）的时候，才应考虑采用抽象类。
*/
interface It
{
    //public void f()  接口中不能有非抽象方法
    //{
    //}
    int i = 10;//  只能是public static final类型的，所以可以省略
    public void f();//  只能是abstract public类型的 可以省略
}

abstract class A implements It// 用implements来实现接口
                              // 因为It中有抽象方法，所以在没有重写该抽象方法是，该类必须是抽象的
{
    
}

class B implements It
{
    public void f()
    {
	System.out.printf("i = %d", i);
    }
}

public class Jiekou_1
{
    public static void main(String[] args)
    {
	B bb = new B();
	bb.f();
    }
}
/*
***************结果***************
i = 10
*/
