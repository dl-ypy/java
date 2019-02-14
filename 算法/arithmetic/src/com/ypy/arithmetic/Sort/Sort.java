package com.ypy.arithmetic.Sort;
/**
 * @author joker
 * @data 2018��6��27��08��31��
 * @target �����㷨
 */
public class Sort {
	/**
	 * �Ľ���ð����������
	 * ˼�룺�����ĵ�һ��Ԫ�ص����һ��Ԫ�ؽ��������Ƚϣ�����Ҫʱ��������Ԫ��
	 *      �Ľ�����Ƿ񽻻������жϣ����û�н�������ζ��������ɣ�����Ҫ�ٽ��в���
	 * ʱ�临�Ӷȣ�
	 *      ����ʱ�临�Ӷȣ�O(n^2)
	 *      ������ʱ�临�Ӷȣ�O(n)
	 *      ƽ�����ʱ�临�Ӷȣ�O(n^2)
	 *      �ռ临�Ӷȣ�O(1)
	 *      �ȶ��ԣ��ȶ�
	 *      �����ԣ���
	 * @param arr
	 */
	public static void bubbleSortAsc(Integer[] arr) {
		boolean isSwap = true;//�ж��Ƿ���н�����
		for (int i=0; i<arr.length-1&&isSwap; i++) {
			isSwap = false;  //��ʼ����ʱ������Ϊû���н�������
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					isSwap = true;  //���������������Ϊtrue
				}
			}
		}
	}
	
	/**
	 * �Ľ���ð�ݽ�������
	 * @param arr
	 */
	public static void bubbleSortDesc(Integer[] arr) {
		boolean isSwap = true;//�ж��Ƿ���н�����
		for (int i=0; i<arr.length-1&&isSwap; i++) {
			isSwap = false;  //��ʼ����ʱ������Ϊû���н�������
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					isSwap = true;  //���������������Ϊtrue
				}
			}
		}
	}
	
	/**
	 * ѡ����������
	 * ˼�룺1.Ѱ����������С��ֵ
	 *      2.�õ�ǰλ�õ�ֵ������Сֵ
	 *      3.������Ԫ���ظ��˹���
	 * ʱ�临�Ӷȣ�
	 *      ����ʱ�临�Ӷȣ�O(n^2)
	 *      ������ʱ�临�Ӷȣ�O(n)
	 *      ƽ�����ʱ�临�Ӷȣ�O(n^2)
	 *      �ռ临�Ӷȣ�O(1)
	 *      �ȶ��ԣ����ȶ�
	 *      �����ԣ���
	 * @param arr
	 */
	public static void selectSortAsc(Integer[] arr) {
		for (int i=0; i<arr.length; i++) {
            int min = i;
            //������С�������±�
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
	 * ѡ��������
	 * @param arr
	 */
	public static void selectSortDesc(Integer[] arr) {
		for (int i=0; i<arr.length; i++) {
            int max = i;
            //�������������±�
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
	 * ֱ�Ӳ�����������
	 * ˼�룺ÿ�δӵ�i������ʼ��ѭ����ǰ��������бȽϣ�
	 *      �ȵ�i������Ķ�����ƶ�һλ����󽫵�iλ��������ʵ�λ�á�
	 * ���ܣ�
	 *      ����ʱ�临�Ӷȣ�O(n^2)
	 *      ������ʱ�临�Ӷȣ�O(n)
	 *      ƽ�����ʱ�临�Ӷȣ�O(n^2)
	 *      �ռ临�Ӷȣ�O(1)
	 *      �ȶ��ԣ��ȶ�
	 *      �����ԣ���
	 * ʵ������Ч������ѡ�������ð������
	 * @param arr
	 */
	public static void insertSortAsc(Integer[] arr) {
		int min;
		for (int i=1; i<arr.length; i++) {
			min = arr[i];
			int j;
			//����i��ѭ����ǰ��Ľ��бȽ�
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
	 * ֱ�Ӳ��뽵������
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
	 * ���ַ�������������
	 * ˼�룺
	 *      ����0~i-1���м�㣬��i��������Ԫ�����м�ֵ���бȽϣ�
	 *      ����i��������ֵ��˵��Ԫ��iҪ�����м�ֵ������Ϊi-1��ֵ֮�䣬
	 *      ��֮�����ڿ�ʼֵ���м�ֵ֮�䡣
	 *      ���ϵ�ͨ���������������۰�ȷ��Ҫ�����λ�á�
	 *      ȷ��λ�ú󣬽��������к��ƣ���ֵ���롣
	 * ���ܣ�
	 *      ����ʱ�临�Ӷȣ�O(n^2)����ȷ����
	 *      ������ʱ�临�Ӷȣ�O(n^2)
	 *      ƽ�����ʱ�临�Ӷȣ�O(n^2)
	 *      �ȶ��ԣ��ȶ�
	 * @param arr
	 */
	public static void binaryInsertSortAsc(Integer[] arr) {
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i]; //�������ֵ
			int left = 0;
			int right = i-1;
			int mid = 0; //�м�ֵ
			//�ҵ�Ҫ�����λ��
			while (left <= right) {//���������ʱ��left����Ҫ�����λ��
				mid = (left+right)/2;
				if (temp < arr[mid]) {
					right = mid-1;
				} else {
					left = mid+1; 
				}
			}
			for (int j=i-1; j>=left; j--) {
				//left�ұߵ�ֵ�����һλ���ȴ�temp����
				arr[j+1] = arr[j];
			}
			
			//����temp
			if (left != i) {  //left����i�����Ϊ��Ҫ�����Ϊ���ģ�ֱ�ӷŵ���󣬲���Ҫ����
				arr[left] = temp;
			}
		}
	}
	
	/**
	 * ���ַ����뽵������
	 * @param arr
	 */
	public static void binaryInsertSortDesc(Integer[] arr) {
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i]; //�������ֵ
			int left = 0;
			int right = i-1;
			int mid = 0; //�м�ֵ
			//�ҵ�Ҫ�����λ��
			while (left <= right) {//���������ʱ��left����Ҫ�����λ��
				mid = (left+right)/2;
				if (temp > arr[mid]) {
					right = mid-1;
				} else {
					left = mid+1; 
				}
			}
			for (int j=i-1; j>=left; j--) {
				//left�ұߵ�ֵ�����һλ���ȴ�temp����
				arr[j+1] = arr[j];
			}
			
			//����temp
			if (left != i) {  //left����i�����Ϊ��Ҫ�����Ϊ���ģ�ֱ�ӷŵ���󣬲���Ҫ����
				arr[left] = temp;
			}
		}
	}
}
