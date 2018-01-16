/*
    时间：2016年1月24日09:21:15
    目的：String常用方法举例。
          统计一个字符串在另一个字符串中出现的次数。
*/
public class String_4
{
    public static void main(String[] args)
    {
	String str1 = "abcasdabcabc";
	String str2 = "abc";
	int index = -1;
	int cnt = 0;

	index = str1.indexOf(str2);

	while (-1 != index)
	{
	    cnt++;
	    index = str1.indexOf(str2,index+str2.length());
	}

	System.out.printf("abc出现%d次。", cnt);
    }
}
/*
***************结果***************
abc出现3次。
*/
