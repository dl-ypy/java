package com.ypy.arithmetic.Sort;
/**
 * @author joker
 * @data 2018年6月27日08点31分
 * @target 排序算法
 */
public class Sort {
	/**
	 * 改进版冒泡升序排序
	 * 思想：迭代的第一个元素到最后一个元素进行两两比较，当需要时交换两个元素
	 *      改进后对是否交换进行判断，如果没有交换则意味着排序完成，不需要再进行操作
	 * 时间复杂度：
	 *      最坏情况时间复杂度：O(n^2)
	 *      最好情况时间复杂度：O(n)
	 *      平均情况时间复杂度：O(n^2)
	 *      空间复杂度：O(1)
	 *      稳定性：稳定
	 *      复杂性：简单
	 * @param arr
	 */
	public static void bubbleSortAsc(Integer[] arr) {
		boolean isSwap = true;//判断是否进行交换过
		for (int i=0; i<arr.length-1&&isSwap; i++) {
			isSwap = false;  //开始排序时，设置为没进行交换操作
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					isSwap = true;  //如果交换，则设置为true
				}
			}
		}
	}
	
	/**
	 * 改进版冒泡降序排序
	 * @param arr
	 */
	public static void bubbleSortDesc(Integer[] arr) {
		boolean isSwap = true;//判断是否进行交换过
		for (int i=0; i<arr.length-1&&isSwap; i++) {
			isSwap = false;  //开始排序时，设置为没进行交换操作
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					isSwap = true;  //如果交换，则设置为true
				}
			}
		}
	}
	
	/**
	 * 选择升序排序
	 * 思想：1.寻找序列中最小的值
	 *      2.用当前位置的值交换最小值
	 *      3.对所有元素重复此过程
	 * 时间复杂度：
	 *      最坏情况时间复杂度：O(n^2)
	 *      最好情况时间复杂度：O(n)
	 *      平均情况时间复杂度：O(n^2)
	 *      空间复杂度：O(1)
	 *      稳定性：不稳定
	 *      复杂性：简单
	 * @param arr
	 */
	public static void selectSortAsc(Integer[] arr) {
		for (int i=0; i<arr.length; i++) {
            int min = i;
            //查找最小的数组下标
            for (int j=i+1; j<arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min > i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
	}
	
	/**
	 * 选择降序排序
	 * @param arr
	 */
	public static void selectSortDesc(Integer[] arr) {
		for (int i=0; i<arr.length; i++) {
            int max = i;
            //查找最大的数组下标
            for (int j=i+1; j<arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (max > i) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
	}
	
	/**
	 * 直接插入升序排序
	 * 思想：每次从第i个数开始，循环与前面的数进行比较，
	 *      比第i个数大的都向后移动一位，最后将第i位数插入合适的位置。
	 * 性能：
	 *      最坏情况时间复杂度：O(n^2)
	 *      最好情况时间复杂度：O(n)
	 *      平均情况时间复杂度：O(n^2)
	 *      空间复杂度：O(1)
	 *      稳定性：稳定
	 *      复杂性：简单
	 * 实际运行效率优于选择排序和冒泡排序
	 * @param arr
	 */
	public static void insertSortAsc(Integer[] arr) {
		int min;
		for (int i=1; i<arr.length; i++) {
			min = arr[i];
			int j;
			//将第i个循环与前面的进行比较
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
	
	/**
	 * 直接插入降序排序
	 * @param arr
	 */
	public static void insertSortDesc(Integer[] arr) {
		int max;
		for (int i=1; i<arr.length; i++) {
			max = arr[i];
			int j;
			for (j=i-1; j>=0; j--) {
				if (arr[j] < max) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = max;
		}
	}
	
	/**
	 * 二分法插入升序排序
	 * 思想：
	 *      计算0~i-1的中间点，用i索引处的元素与中间值进行比较，
	 *      假设i索引处的值大，说明元素i要插入中间值与索引为i-1的值之间，
	 *      反之，就在开始值与中间值之间。
	 *      不断的通过上述方法进行折半确定要插入的位置。
	 *      确定位置后，将整个序列后移，将值插入。
	 * 性能：
	 *      最坏情况时间复杂度：O(n^2)（不确定）
	 *      最好情况时间复杂度：O(n^2)
	 *      平均情况时间复杂度：O(n^2)
	 *      稳定性：稳定
	 * @param arr
	 */
	public static void binaryInsertSortAsc(Integer[] arr) {
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i]; //待插入的值
			int left = 0;
			int right = i-1;
			int mid = 0; //中间值
			//找到要插入的位置
			while (left <= right) {//当左右相等时，left就是要插入的位置
				mid = (left+right)/2;
				if (temp < arr[mid]) {
					right = mid-1;
				} else {
					left = mid+1; 
				}
			}
			for (int j=i-1; j>=left; j--) {
				//left右边的值向后移一位，等待temp插入
				arr[j+1] = arr[j];
			}
			
			//插入temp
			if (left != i) {  //left等于i的情况为：要插入的为最大的，直接放到最后，不需要交换
				arr[left] = temp;
			}
		}
	}
	
	/**
	 * 二分法插入降序排序
	 * @param arr
	 */
	public static void binaryInsertSortDesc(Integer[] arr) {
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i]; //待插入的值
			int left = 0;
			int right = i-1;
			int mid = 0; //中间值
			//找到要插入的位置
			while (left <= right) {//当左右相等时，left就是要插入的位置
				mid = (left+right)/2;
				if (temp > arr[mid]) {
					right = mid-1;
				} else {
					left = mid+1; 
				}
			}
			for (int j=i-1; j>=left; j--) {
				//left右边的值向后移一位，等待temp插入
				arr[j+1] = arr[j];
			}
			
			//插入temp
			if (left != i) {  //left等于i的情况为：要插入的为最大的，直接放到最后，不需要交换
				arr[left] = temp;
			}
		}
	}
}
