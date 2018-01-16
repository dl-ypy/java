import java.util.Arrays;

/**
 * date:2017��7��5��15:25:03
 * target:�ߵ����顣
 * @author ypy
 */
public class ArrayReversal {
	public static void main(String[] args) {
		int[] arr = new int[]{
				(int)(Math.random()*100),
				(int)(Math.random()*100),
				(int)(Math.random()*100),
				(int)(Math.random()*100),
				(int)(Math.random()*100),
				(int)(Math.random()*100)
				};
		System.out.println(Arrays.toString(arr));
		swap(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * ��������еߵ�����
	 * @param arr
	 */
	public static void swap(int[] arr) {
		int len = arr.length;
		for (int i=0; i<len/2; i++) {
			int temp = arr[i];
			arr[i] = arr[len-1-i];
			arr[len-1-i] = temp;
		}
	}
}

/*
***************JDK1.8���н��****************
[78, 8, 65, 26, 66, 41]
[41, 66, 26, 65, 8, 78]
*/
