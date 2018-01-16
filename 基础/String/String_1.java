/*
    时间：2016年1月22日16:41:37
    目的：String类的equals方法的使用。
*/
public class String_1
{
    public static void main(String[] args)
    {
	String str1 = new String("china");//new 出来的位于堆中，str1指向一个空间，str2指向另一个空间。
	String str2 = new String("china");
	System.out.println(str1.equals(str2));//判断指向的内容是否相等

	if (str1 == str2)    //判断是否指向同一地址
	    System.out.println("str1 == str2");
	else
	    System.out.println("str1 != str2");

	String str3 = "china";//此时的china在数据区存放，str3和str4共同指向一个china。
	String str4 = "china";
	if (str3 == str4)
	   System.out.println("str3 == str4"); 
	else
	   System.out.println("str3 != str4");
    }
}
/*
***************结果***************
true
str1 != str2
str3 == str4
*/
