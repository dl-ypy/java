/*
    ʱ�䣺2016��1��24��09:21:15
    Ŀ�ģ�String���÷���������
          ͳ��һ���ַ�������һ���ַ����г��ֵĴ�����
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

	System.out.printf("abc����%d�Ρ�", cnt);
    }
}
/*
***************���***************
abc����3�Ρ�
*/
