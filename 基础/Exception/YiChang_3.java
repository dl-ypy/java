/*
    ʱ�䣺2016��1��2��17:06:55
    Ŀ�ģ�Ϊʲô����if���ʵ���쳣��
*/
import java.util.Scanner;//  ���������

public class YiChang_3
{
    public static void main(String[] args)
    {
	int i;

	System.out.printf("������һ��������\n");
	Scanner sc = new Scanner(System.in);//  System.in��ʾ��������
	try//    ��Ϊ�������ü������룬�޷���if���ȷ��������
	   //    if (i == ?)   ����ȷ��
	{
	    i = sc.nextInt();
	    System.out.printf("i = %d\n", i);
	}
	catch(Exception e)
	{
            System.out.printf("�������벻�Ϸ���");
	}
    }
}
/*
***************���***************
������һ��������
gukgbkjgjgku
�������벻�Ϸ���
*/
