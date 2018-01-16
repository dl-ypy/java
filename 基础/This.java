/*
    2015年12月24日13:00:42
    目的：this的用法。
*/
class A
{
    public int i;

    public A(int j)
    {
        i = j;
    }

    // public void show(A*this)  this代表当前正在调用show方法的对象。
    public void show()
    {
        //System.out.printf("i = %d\n", (*this).i);
        System.out.printf("i = %d\n", i);
    }
}

public class This_1
{
    public static void main(String[] args)
    {
	//aa1和aa2可以通过隐藏的指针this，共用同一个方法show
        A aa1 = new A(10);// aa1.show(aa1)
	A aa2 = new A(20);// aa2.show(aa2)

        aa1.show();
	aa2.show();
    }
}
/*
***************结果***************
i = 10
i = 20
*/
