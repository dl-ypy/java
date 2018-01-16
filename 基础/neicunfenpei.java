class A
{
    int i;
    int j;

    public void show()
    {
        System.out.printf("调用方法后i = %d\n", i);
    }
}

public class neicunfenpei {
    public static void main(String[] args)
    {
    	A aa = new A();//new A 等价于(A *)malloc(sizeof(A));
    	    // new A(); 在堆中动态分配一块区域，被当作A对象
    	    // aa本身的内存是在栈中静态分配的
    	    // 堆中内存的地址赋给了aa
    	    // aa指向堆中的内存，aa代表了堆中的内存
    	    // aa.i 代表：aa这个静态指针变量所指向的动态内存中的A对象的成员i
        A aa2 = new A();
    	aa.i = 10;
        aa2.i = 20;
    	aa.j = 20;

    	System.out.printf("aa.i = %d, a.j = %d\n", aa.i, aa.j);

        aa2 = aa;   //此语句使得aa2和aa指向同一片空间

        System.out.printf("aa.i = %d\n", aa.i);

        aa.show();

        aa.i = 50;

        System.out.printf("aa2.i = %d\n", aa2.i);

        aa2.show();
    }
}
/*
***************结果***************
aa.i = 10, a.j = 20
aa.i = 10
调用方法后i = 10
aa2.i = 50
调用方法后i = 50
*/
