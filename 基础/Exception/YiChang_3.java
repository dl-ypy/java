/*
    时间：2016年1月2日17:06:55
    目的：为什么不用if语句实现异常。
*/
import java.util.Scanner;//  导入输入包

public class YiChang_3
{
    public static void main(String[] args)
    {
	int i;

	System.out.printf("请输入一个整数：\n");
	Scanner sc = new Scanner(System.in);//  System.in表示键盘输入
	try//    因为这里是用键盘输入，无法用if语句确定其条件
	   //    if (i == ?)   不能确定
	{
	    i = sc.nextInt();
	    System.out.printf("i = %d\n", i);
	}
	catch(Exception e)
	{
            System.out.printf("您的输入不合法！");
	}
    }
}
/*
***************结果***************
请输入一个整数：
gukgbkjgjgku
您的输入不合法！
*/
