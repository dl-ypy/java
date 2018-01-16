/*
    时间：2015年12月27日18:37:29
    目的：看如何实现 “子类对象 = 父类对象”。
    			父类对象 = 子类对象
    			子类对象 = (子类类型)父类对象
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
    public void f()
    {
	System.out.printf("BBBB\n");
    }
}

public class Duotai_3
{
    public static void main(String[] args)
    {
	A aa = new A();
	B bb = new B();

	aa = bb;// 此时aa指向一个B类对象

	bb = (B)aa;// 强制类型转换
	           // 如果不写 aa = bb; 虽然语法上正确，但运行的时候是错误的
	bb.f();
    }
}
/*
***************结果***************
BBBB
*/
