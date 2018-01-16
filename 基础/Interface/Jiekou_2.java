/*
    时间：2015年12月29日14:34:52
    目的：接口的继承问题。
*/
interface It1
{
    int i = 10;
    public void f();
}

interface It2
{
    
}

interface It3 extends It1,It2// 接口可以继承接口，并且可实现多继承，但接口不可实现接口。
{
}

class A
{
    
}

abstract class B extends A implements It1,It2// 同时实现继承类和实现接口，顺序必须是extends在前，implements在后
{
}

public class Jiekou_2
{
    public static void main(String[] args)
    {
	
    }
}
