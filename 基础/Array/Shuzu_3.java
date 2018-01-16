/*
    时间：2016年1月26日20:37:14
    目的：数组的排序。
*/
import java.util.*;

public class Shuzu_3
{
    public static void main(String[] args)
    {
	int[] data = new int[]{1, 2, 6, 4, 5, 3, 8, 7, 9};
	int i;

	System.out.printf("排序前数组data的内容是：");
	for (i=0; i<data.length; i++)
	{
	    System.out.printf("%d ", data[i]);
	}

	System.out.printf("\n");

	Arrays.sort(data);// 排序的方法。
        System.out.printf("排序后数组data的内容是：");
	for (int e : data)// 将data数组中的每个元素取出，赋给e。
	{
	    System.out.printf("%d ", e);
	}

    }
}
/*
***************结果***************
排序前数组data的内容是：1 2 6 4 5 3 8 7 9
排序后数组data的内容是：1 2 3 4 5 6 7 8 9
*/
