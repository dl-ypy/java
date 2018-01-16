/*
    时间：2015年12月29日15:16:14
    目的：接口实现多态。
*/
interface It
{
   void f();
}

class A implements It
{
    public void f()
    {
	System.out.printf("AAAA\n");
    }

    public void g()
    {
    }
}

class Jiekou_3
{
    public static void main(String[] args)
    {
	It it;// 不是new出来的，接口的对象不能new，但可以定义一个接口引用类型的变量
	it = new A();// 指向实现接口的对象
	it.f();// 实现多态，但f()方法必须是接口It中有的
	//it.g();// 错误，因为g()是子类中特有的成员，不能通过父类接口直接调用
    }
}
/*
***************结果***************
AAAA
*/
