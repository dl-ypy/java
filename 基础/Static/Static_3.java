/*
    时间：2015年12月25日22:27:20
    目的：static的应用。
    本程序证明了：只有非private的static成员才可以通过类名访问
*/
class A
{
    private static int i = 30;
}

class Static_3
{
    public static void main(String[] args)
    {
        System.out.printf("i = %d\n", A.i);
    }
}
/*
***************结果***************
Static_3.java:15: 错误: i可以在A中访问private
        System.out.printf("i = %d\n", A.i);
                                       ^
*/