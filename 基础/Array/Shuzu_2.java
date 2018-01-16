/*
    时间：2016年1月26日20:21:07
    目的：数组的拷贝。
*/
public class Shuzu_2
{
    public static void main(String[] args)
    {
	int[] arr1 = new int[]{1, 2, 3, 4, 5};
	int[] arr2 = new int[]{-1, -2, -3, -4, -5};
	int i;

	System.arraycopy(arr1, 0, arr2, 1, 2);
	//  aar1数组下标从0开始的2个，覆盖掉arr2数组下标从1开始的
	System.out.printf("arr1 = \n");
	for (i=0; i<arr1.length; i++)//能直接调用  .length
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
***************结果***************
arr1 =
1 2 3 4 5
arr2 =
-1 1 2 -4 -5
*/
