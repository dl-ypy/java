/*
    ʱ�䣺2016��1��22��16:41:37
    Ŀ�ģ�String���equals������ʹ�á�
*/
public class String_1
{
    public static void main(String[] args)
    {
	String str1 = new String("china");//new ������λ�ڶ��У�str1ָ��һ���ռ䣬str2ָ����һ���ռ䡣
	String str2 = new String("china");
	System.out.println(str1.equals(str2));//�ж�ָ��������Ƿ����

	if (str1 == str2)    //�ж��Ƿ�ָ��ͬһ��ַ
	    System.out.println("str1 == str2");
	else
	    System.out.println("str1 != str2");

	String str3 = "china";//��ʱ��china����������ţ�str3��str4��ָͬ��һ��china��
	String str4 = "china";
	if (str3 == str4)
	   System.out.println("str3 == str4"); 
	else
	   System.out.println("str3 != str4");
    }
}
/*
***************���***************
true
str1 != str2
str3 == str4
*/
