/*
    时间：2015年12月25日21:55:24
    目的：static的应用。
    本程序证明了：static属性i是属于类本身，或者讲：没有对象，任然可以直接通过类名的方式访问该类的static属性i。
                  static方法同理
                  但很显然，static属性和方法也可以通过类所创建的对象访问
*/
class A
{
    //public int i = 10;  此情况会出现语法错误
    public static int i = 10; 
    
    public static void f()
    {
        System.out.printf("123\n");
    }
}

class Static_2   //  此主类中并没有创建对象：A aa = new A();
{
    public static void main(String[] args)
    {
        System.out.printf("i = %d\n", A.i);
        A.f();
    }
    
}
/*
***************结果***************
i = 10
123
*/