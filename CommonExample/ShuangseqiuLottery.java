//双色球抽奖
import java.util.Arrays;
import java.util.Random;

public class ShuangseqiuLottery {

	public static void main(String[] args) {
		//int a = 0;
		//while (true) {
		System.out.println("生成双色球：");
		int arr1[] = randomCreate();
		System.out.println(Arrays.toString(arr1));
		System.out.println("抽奖：");
		int arr2[] = randomCreate();
		System.out.println(Arrays.toString(arr2));
		int bonus = rule(arr1, arr2);
		System.out.println("奖金：" + bonus + "元。");
		/*a++;
		System.out.println(a);
		if (bonus == 1000000) {
			break;
		}*/
		//}
	}
	
	public static int[] randomCreate() {
		int[] arr = new int[7];
		int a;
		int j;
		Random random = new Random();
		while (true) {
			if ((arr[0] = random.nextInt(16)) != 0)
				break;
		}
		for (int i=1; i<6; i++) {
			a = random.nextInt(33);
			for (j=i; j>0; j--) {
				if (a == arr[j-1]) {
					break;
				}
			}
			if ((j==0) && (a!=0)) {
				arr[i] = a;
			} else {
				i--;
			}
		}
		while (true) {
			if ((arr[6] = random.nextInt(16)) != 0)
				break;
		}
		return arr;
	}

	public static int rule(int[] arr1, int[] arr2) {
		int bonus = 0;
		int redNum = 0;
		for (int i=0; i<arr1.length-1; i++) {
			for (int j=0; j<arr2.length-1; j++) {
				if (arr1[i]==arr2[j]) {
					redNum++;
				}
			}
		}
		if ((redNum==6) && (arr1[arr1.length-1]==arr2[arr2.length-1])) {
			bonus = 1000000;
		} else if ((redNum==6) && (arr1[arr1.length-1]!=arr2[arr2.length-1])) {
			bonus = 50000;
		} else if ((redNum==5) && (arr1[arr1.length-1]==arr2[arr2.length-1])) {
			bonus = 3000;
		} else if (((redNum==5)&&(arr1[arr1.length-1]!=arr2[arr2.length-1])) || ((redNum==4)&&(arr1[arr1.length-1]==arr2[arr2.length-1]))) {
			bonus = 200;
		} else if (((redNum==4)&&(arr1[arr1.length-1]!=arr2[arr2.length-1])) || ((redNum==3)&&(arr1[arr1.length-1]==arr2[arr2.length-1]))) {
			bonus = 10;
		} else if ((arr1[arr1.length-1]==arr2[arr2.length-1]) && ((redNum==0)||(redNum==1)||(redNum==2))) {
			bonus = 5;
		} 
		return bonus;
	}
}
