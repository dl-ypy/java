/*
    ʱ�䣺2016��1��26��20:21:07
    Ŀ�ģ�����Ŀ�����
*/
public class Shuzu_2
{
    public static void main(String[] args)
    {
	int[] arr1 = new int[]{1, 2, 3, 4, 5};
	int[] arr2 = new int[]{-1, -2, -3, -4, -5};
	int i;

	System.arraycopy(arr1, 0, arr2, 1, 2);
	//  aar1�����±��0��ʼ��2�������ǵ�arr2�����±��1��ʼ��
	System.out.printf("arr1 = \n");
	for (i=0; i<arr1.length; i++)//��ֱ�ӵ���  .length
	{
	    System.out.printf("%d ", arr1[i]);
	}

	System.out.printf("\n");

	System.out.printf("arr2 = \n");
	for (i=0; i<arr2.length; i++)
	{
	    System.out.printf("%d ", arr2[i]);
	}
    }
}
/*
***************���***************
arr1 =
1 2 3 4 5
arr2 =
-1 1 2 -4 -5
*/
