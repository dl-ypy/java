/*
    时间：2016年1月22日17:08:24
    目的：String类的valuOf方法和Integer的parseInt方法。
*/
public class String_2
{
    public static void main(String[] args)
    {
	int i = 123;
	String str = "465";

	//i = str//错误
	//str = i//错误

	str = String.valueOf(i);//将整型转换成字符串型
	System.out.printf("str = %s\n", str);

	i = Integer.parseInt(str);
	System.out.printf("i = %d\n", i);
    }
}
/*
***************结果***************
str = 123
i = 123
*/
