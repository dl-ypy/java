/*
    时间：2015年12月29日13:18:22
    目的：抽象类的应用
    注：abstract不能修饰构造方法，因为abstract修饰的方法表示不会实现，只有被继承后才会实现，
        而构造方法不能被继承，且实例化一个对象时一定会实现。
        abstract不能修饰变量，只能修饰类或者方法。
*/
abstract class A//  必须是抽象类
{
    abstract public void f();// 抽象方法  无方法体，必须有分号 
}

abstract class B//  抽象类中可以有非抽象方法，非抽象方法能够提高代码复用
                //子类继承父类后，非抽象方法可以不用重写即可调用
{
    public void f()
    {
	
    }
}

abstract class C extends A// 父类中要有抽象方法，如果子类中没有实现该方法，子类必须是抽象的
{
    
}

class D extends A// 子类中实现（重写）了该方法，子类可以是非抽象类
{
    public void f()
    {
	System.out.printf("DDDD\n");
    }
}

public class Chouxianglei
{
    public static void main(String[] args)
    {
	// A aa = new A(); 不能定义一个抽象类的对象
	D dd = new D();
	dd.f();

	A aa;//  可以定义一个抽象类的引用

	aa = dd;
	aa.f(); // 实现多态
    }
}
/*
***************结果***************
DDDD
DDDD
*/
