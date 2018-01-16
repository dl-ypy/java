/**
 * date:2017年6月1日10:27:19
 * target:label的用途。
 * @author ypy
 * conclusion:
 *     break只能跳出当前循环，而使用label标签可以跳出多重循环。
 */
public class Label {
	public static void main(String[] args) {
		System.out.println("只用break时：");
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (i == 2) {
					break;
				}
				System.out.println("i=" + i + "时：" + j);
			}
		}
		
		System.out.println("------------------------");
		System.out.println("加label");
		label:   //可以是任何名字
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (i == 2) {
					break label;
				}
				System.out.println("i=" + i + "时：" + j);
			}
		}
	}
}
/*
 *************** jdk1.8运行结果***************
只用break时：
i=0时：0
i=0时：1
i=0时：2
i=0时：3
i=0时：4
i=1时：0
i=1时：1
i=1时：2
i=1时：3
i=1时：4
i=3时：0
i=3时：1
i=3时：2
i=3时：3
i=3时：4
i=4时：0
i=4时：1
i=4时：2
i=4时：3
i=4时：4
------------------------
加label
i=0时：0
i=0时：1
i=0时：2
i=0时：3
i=0时：4
i=1时：0
i=1时：1
i=1时：2
i=1时：3
i=1时：4
 */
