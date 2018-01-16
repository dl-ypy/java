/*
    时间：2016年1月17日19:29:27
    目的：toString()方法。
*/
class A//  任何类都默认继承Object类，toString是该类中的一个方法
{
    
}

public class ToString_1
{
    public static void main(String[] args)
    {
	A aa = new A();
	System.out.printf("%s\n", aa.toString());
    }
}
/*
***************结果***************
A@659e0bfd           //A表示类A   659e0bfd 表示对象aa在堆中地址的16进制表示（哈希码）
*/
