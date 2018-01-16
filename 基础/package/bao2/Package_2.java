/*
    时间：2015年12月31日09:00:00
    目的：编译包层时的简便方法。
*/
package bao2;

class A
{
    public void f()
    {
	System.out.printf("AAAA\n");
    }
}

public class Package_2
{
    public static void main(String[] args)
    {
	A aa = new A();
	aa.f();
    }
}
/*
***************结果***************
F:\java\基础\package A>javac -d . Package_2.java    这样写就能自动生成包

F:\java\基础\package A>java bao2.Package_2
AAAA
*/
