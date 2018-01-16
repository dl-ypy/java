/*
    时间：2016年1月24日08:21:04
    目的：String常用方法举例。
*/
public class String_3
{
    public static void main(String[] args)
    {
	String str = "abAM1，!23";
	int cntU = 0;//大写字母的个数。
	int cntL = 0;//小写字母的个数。
	int cntOther = 0;
	int i;

	for (i=0; i<str.length(); i++)
	{
	    char ch = str.charAt(i);

	    if (ch>='A' && ch<='Z')//或者 if (Character.isUpperCase(ch))
	    {
		 cntU++;
	    }
	    else if (ch>='a' && ch<='z')//或者 if (Character.isLowerCase(ch))
	    {
		cntL++;
	    }
	    else
	    {
		cntOther++;
	    }
	}
	System.out.printf("大写字母个数：%d\n", cntU);
	System.out.printf("小写字母个数：%d\n", cntL);
	System.out.printf("其他字母个数：%d\n", cntOther);
    }
}
/*
***************结果***************
大写字母个数：2
小写字母个数：2
其他字母个数：5
*/
