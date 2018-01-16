/*
    时间：2015年12月30日22:20:16
    目的：简单了解包。
*/
package bao1;//  必须是第一条语句

class A
{
    public void f()
    {
        System.out.printf("AAAA\n");
    }
}

class Package_1
{
    public static void main(String[] args)
    {
	A aa = new A();
	aa.f();
    }
}
/*
***************结果***************
F:\java\基础\package A>javac Package_1.java

F:\java\基础\package A>java Package_1      这里因为运行的时候并没有自动生成包，需要手动创建，并且将文件都移动进去
错误: 找不到或无法加载主类 Package_1

F:\java\基础\package A>java Package_1      这里是因为运行的时候应该写 java 包名.文件名
错误: 找不到或无法加载主类 Package_1

F:\java\基础\package A>java bao1.Package_1
AAAA
*/

