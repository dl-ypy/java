/*
    时间：2015年12月27日18:54:47
    目的：通过父类对象不能调用子类特有的成员，但通过 “父类 = 子类”可以实现调用。
                                        
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

    public void g()
    {
	System.out.printf("GGGG\n");
    }
}

public class Duotai_4
{
		public static void h(A aa)
		{
				B bb = new B();
				aa.f();
				aa = bb;
				bb = (B)aa;//父类强制转换为子类
				bb.g();//使得在该方法中能够调用子类特有的方法
		}
    public static void main(String[] args)
    {
				A aa = new A();
				B bb = new B();

				//aa.g();//  error g方法是子类B特有的，不能通过父类对象调用。
				h(bb);
    }
}
/*
***************结果***************
BBBB
GGGG
*/
