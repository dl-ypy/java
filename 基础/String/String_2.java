/*
    ʱ�䣺2016��1��22��17:08:24
    Ŀ�ģ�String���valuOf������Integer��parseInt������
*/
public class String_2
{
    public static void main(String[] args)
    {
	int i = 123;
	String str = "465";

	//i = str//����
	//str = i//����

	str = String.valueOf(i);//������ת�����ַ�����
	System.out.printf("str = %s\n", str);

	i = Integer.parseInt(str);
	System.out.printf("i = %d\n", i);
    }
}
/*
***************���***************
str = 123
i = 123
*/
