package javaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author joker
 * 算法之排序
 */
public class Test{
	static Integer[] arr = new Integer[]{5,66,9,0,-1,42,77}; 
	
	public static void main(String[] args) {
		System.out.println("排序前："+Arrays.toString(arr));
		selectSort(arr);
		System.out.println("选择排序："+Arrays.toString(arr));
		//转换为list将顺序重新打乱
		List<Integer> list = Arrays.asList(arr);
		Collections.shuffle(list);
		arr = (Integer[])list.toArray(new Integer[list.size()]);
		System.out.println("排序前："+Arrays.toString(arr));
		directInsertSort(arr);
		System.out.println("直接插入排序："+Arrays.toString(arr));
		//转换为list将顺序重新打乱
		list = Arrays.asList(arr);
		Collections.shuffle(list);
		arr = (Integer[])list.toArray(new Integer[list.size()]);
		System.out.println("排序前："+Arrays.toString(arr));
		BinaryInsertSort(arr);
		System.out.println("二分法插入排序："+Arrays.toString(arr));
	}
	
	/*
	 * 选择排序
	 * 描述：每次比较都选择最小的值，将其与此次比较的数的第一位交换，再将剩下的数进行比较
	 * 时间复杂度：n+(n-1)+...+1=n(n+1)/2
	 * */
	public static void selectSort(Integer[] arr) {
		Integer min;
		Integer tmp = 0;
		for (Integer i=0; i<arr.length; i++) {
			min = arr[i];
			//一次循环过后，最小的一定在第一位
			for (Integer j=i; j<arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];//得到最小值
					tmp = arr[i];  //将最小值与第一位交换
					arr[i] = min;
					arr[j] = tmp;
				}
			}
		}
	}
	
	/*
	 * 直接插入排序
	 * 描述：与前面的比较，循环将比当前数小的插入当前数后面，直到遇到小于等于当前数的，break，最后将初始时比较的数放到当前j的下一位
	 * 时间复杂度：n+(n-1)+...+1=n(n+1)/2
	 * */
	public static void directInsertSort(Integer[] arr) {
		Integer min;
		for (Integer i=0; i<arr.length; i++) {
			min = arr[i];
			int j;
			for (j=i-1; j>=0; j--) {
				if (arr[j] > min) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = min;
		}
	}
	
	/*
	 * 二分法插入排序
	 * 描述：与前面的比较，循环将比当前数小的插入当前数后面，直到遇到小于等于当前数的，break，最后将初始时比较的数放到当前j的下一位
	 * 时间复杂度：n+(n-1)+...+1=n(n+1)/2
	 * */
	public static void BinaryInsertSort(Integer[] arr) {
		for (Integer i=1; i<arr.length; i++) {
			int temp = arr[i]; //待插入的值
			int left = 0;
			int right = i-1;
			int mid = 0; //中间值
			//找到要插入的位置
			while (left <= right) {
				mid = (left+right)/2;
				if (temp < arr[mid]) {
					right = mid-1;
				} else {
					left = mid+1; 
				}
			}
			for (int j=i-1; j>=left; j--) {
				//比left右边大的值向后移一位，等待temp插入
				arr[j+1] = arr[j];
			}
			
			//插入temp
			if (left != i) {  //left等于i的情况为：要插入的为最大的，直接放到最后，不需要交换
				arr[left] = temp;
			}
		}
	}
}

/**
 * JDK1.8运行结果
 * 排序前：[5, 66, 9, 0, -1, 42, 77]
 * 选择排序：[-1, 0, 5, 9, 42, 66, 77]
 * 排序前：[5, 77, 42, 9, -1, 0, 66]
 * 直接排序：[-1, 0, 5, 9, 42, 66, 77]
 * 排序前：[0, 66, 42, 9, 77, 5, -1]
 * 二分法插入排序：[-1, 0, 5, 9, 42, 66, 77]
*/