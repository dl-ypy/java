/*
    时间：2015年12月31日11:16:31
    目的：有关系的不同包之间的相互访问。
*/
package Butongbao.butongbaoB;
import Butongbao.butongbaoA.Package_1;

class B extends Package_1
{
    public void f()
    {
	g();
	b();// 在子类内部可以访问从另一个包中继承过来的父类的public和protected成员。
    }
}

public class Package_2
{
    public static void main(String[] args)
    {
	B bb = new B();
	bb.f();

	bb.g();//  在子类外部，通过子类对象名能访问父类的public成员。
        //bb.b();                            但不能访问父类的protected成员，这就是public与protected的区别。
    }
}
/*
***************结果***************
F:\java\基础\package>javac -d . Package_1.java Package_2.java

F:\java\基础\package>java Butongbao.butongbaoB.Package_2
GGGG
BBBB
GGGG
*/
