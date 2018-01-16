/*
    2015年12月25日21:31:18
    目的：static的应用。
    本程序证明了：A类的多个对象公用一个static属性i。
    注：static变量为静态的全局变量，属于类，所以不能在方法里面定义static变量。
        static不能修饰构造方法，因为构造方法是类创建对象时调用的，必须依赖于对象，而static则不依赖于对象。
*/
class A
{
    //public int i = 10;    aa2.show();输出的为 i = 10
    public static int i = 10; //  此时输出为 i = 20
    
    public void show()
    {
        System.out.printf("i = %d\n", i);
    }
}

class Static_1
{
    public static void main(String[] args)
    {
        A aa1 = new A();
        A aa2 = new A();
        
        aa1.i = 20;
        aa2.show();
    }
}
/*
***************结果***************
i = 20
*/