/*
    2015��12��24��13:00:42
    Ŀ�ģ�this���÷���
*/
class A
{
    public int i;

    public A(int j)
    {
        i = j;
    }

    // public void show(A*this)  this����ǰ���ڵ���show�����Ķ���
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
	//aa1��aa2����ͨ�����ص�ָ��this������ͬһ������show
        A aa1 = new A(10);// aa1.show(aa1)
	A aa2 = new A(20);// aa2.show(aa2)

        aa1.show();
	aa2.show();
    }
}
/*
***************���***************
i = 10
i = 20
*/
