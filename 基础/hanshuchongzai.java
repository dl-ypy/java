/*
    2015年12月23日21:13:54
    目的：函数的重载。
*/
class hanshuchongzai//  函数名相同，但形参个数、形参顺序，形参数据类型  这三个至少有一个不同
                    //  如果就返回值不同，其他都相同，也会出错，因为不知道调用的哪个
{
    static int add(int a, int b)
    {
        return a + b;
    }

    static int add(int a, int b, int c)
    {
        return a + b + c;
    }

    static int add(int a, int b, int c, int d)
    {
        return a + b + c + d;
    }

    static double add(double a, double b)
    {
        return a + b;
    }

    public static void main(String[] args)
    {
        System.out.printf("%d\n", add(1, 2));
	System.out.printf("%d\n", add(1, 2, 3));
	System.out.printf("%d\n", add(1, 2, 3, 4));
	System.out.printf("%f\n", add(1.1, 2.2));//在java中，float型和double型都用%f
    }
}
/*
***************结果***************
3
6
10
3.300000
*/
