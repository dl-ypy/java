/*
    时间：2016年1月17日19:45:27
    目的：toString的实用程序举例。
*/
class Dian
{
    public int x, y;

    public Dian(int x, int y)
    {
	this.x = x;
	this.y = y;
    }

    public String toString()//重写父类的toString方法
    {
	return "[" + x + "," + y + "]";
    }
}

public class ToString_2
{
    public static void main(String[] args)
    {
	Dian d = new Dian(1, 2);
	System.out.println(d);// 这里就调用了toString方法,注意用的是println
    }
}
/*
***************结果***************
[1,2]
*/
