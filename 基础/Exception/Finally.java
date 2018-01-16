/*
    时间：2016年1月13日15:42:18
    目的：finally的使用。
*/
class A
{
    public int f(int n, int m)
    {
			int a = m / n;

			return m;
    }
}
public class Finally
{
    public static void main(String[] args)
    {
	try
	{
	    new A().f(6, 0);
	}
	catch(ArrayIndexOutOfBoundsException e)//不是上述异常原因，所以不会捕获到
	{
	    System.out.printf("222\n");//所以，这些代码不执行
	    e.printStackTrace();//该语句输出异常路径，但此程序中不输出
	    //System.exit(0);   如果捕获到对应的异常，执行到catch中的这句时，程序就会终止，finally部分的语句就不会执行了
	}
	finally              //  无论异常捕获与否，finally中的代码都会执行
		             //  目的是保证不管程序在哪里遇到异常而奔溃，都要运行finally中的一些重要程序，提供一个统一的释放出口，如关掉文件等
	{
	    System.out.printf("如果try中有return语句，该语句在finally前执行，但在finally后返回\n");
	}
    }
}
/*
***************结果***************
如果try中有return语句，该语句在finally前执行，但在finally后返回

*/
