/*
    时间：2016年1月25日19:36:20
    目的：printf和println的区别。
*/
class Dian
{
    public int x, y;

    public Dian(int x, int y)
    {
	this.x = x;
	this.y = y;
    }

    public String toString()
    {
	return "[" + x + ", " + y + "]";
    }
}

public class println
{
    public static void main(String[] args)
    {
	Dian d = new Dian(3, 2);
	System.out.printf("%s\n", d);
	System.out.println(d);

	int i, j, k;
	i = 1;
	j = 2;
	k = 3;
	System.out.printf("%d的值 + %d的值是 %d\n", i, j, k);
	System.out.println(i + "的值 + " + j + "的值是 " + k);

	int m = 47;
	System.out.printf("十进制数字%d用十六进制表示是：%#X\n", m, m);
	System.out.println("十进制数字" + m + "用十六进制表示是：OX" + Integer.toHexString(m).toUpperCase());
	//   Integer.toHexString(m) 表示m的十六进制   toUpperCase() 表示用大写字母
    }
}
/*
***************结果***************
[3, 2]
[3, 2]
1的值 + 2的值是 3
1的值 + 2的值是 3
十进制数字47用十六进制表示是：0X2F
十进制数字47用十六进制表示是：OX2F
*/
