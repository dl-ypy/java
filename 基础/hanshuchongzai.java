/*
    2015��12��23��21:13:54
    Ŀ�ģ����������ء�
*/
class hanshuchongzai//  ��������ͬ�����βθ������β�˳���β���������  ������������һ����ͬ
                    //  ����ͷ���ֵ��ͬ����������ͬ��Ҳ�������Ϊ��֪�����õ��ĸ�
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
	System.out.printf("%f\n", add(1.1, 2.2));//��java�У�float�ͺ�double�Ͷ���%f
    }
}
/*
***************���***************
3
6
10
3.300000
*/
