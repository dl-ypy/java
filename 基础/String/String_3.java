/*
    ʱ�䣺2016��1��24��08:21:04
    Ŀ�ģ�String���÷���������
*/
public class String_3
{
    public static void main(String[] args)
    {
	String str = "abAM1��!23";
	int cntU = 0;//��д��ĸ�ĸ�����
	int cntL = 0;//Сд��ĸ�ĸ�����
	int cntOther = 0;
	int i;

	for (i=0; i<str.length(); i++)
	{
	    char ch = str.charAt(i);

	    if (ch>='A' && ch<='Z')//���� if (Character.isUpperCase(ch))
	    {
		 cntU++;
	    }
	    else if (ch>='a' && ch<='z')//���� if (Character.isLowerCase(ch))
	    {
		cntL++;
	    }
	    else
	    {
		cntOther++;
	    }
	}
	System.out.printf("��д��ĸ������%d\n", cntU);
	System.out.printf("Сд��ĸ������%d\n", cntL);
	System.out.printf("������ĸ������%d\n", cntOther);
    }
}
/*
***************���***************
��д��ĸ������2
Сд��ĸ������2
������ĸ������5
*/
