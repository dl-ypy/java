/*
    ʱ�䣺2016��1��26��20:37:14
    Ŀ�ģ����������
*/
import java.util.*;

public class Shuzu_3
{
    public static void main(String[] args)
    {
	int[] data = new int[]{1, 2, 6, 4, 5, 3, 8, 7, 9};
	int i;

	System.out.printf("����ǰ����data�������ǣ�");
	for (i=0; i<data.length; i++)
	{
	    System.out.printf("%d ", data[i]);
	}

	System.out.printf("\n");

	Arrays.sort(data);// ����ķ�����
        System.out.printf("���������data�������ǣ�");
	for (int e : data)// ��data�����е�ÿ��Ԫ��ȡ��������e��
	{
	    System.out.printf("%d ", e);
	}

    }
}
/*
***************���***************
����ǰ����data�������ǣ�1 2 6 4 5 3 8 7 9
���������data�������ǣ�1 2 3 4 5 6 7 8 9
*/
