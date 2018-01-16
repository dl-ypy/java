import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * date:2017年6月9日10:20:03
 * target:产生10个随机数并对其排序。
 * @author ypy
 */
public class RandomNumberSort{
	//产生10个随机数
	public static List<Integer> randomNumber() {
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i=0; i<10; i++) {
			list.add(r.nextInt(100));//随机数介于0（含）和100之间
		}
		return list;
	}
	
	//对List中的元素排序
	public static void sort(List<Integer> list) {
		Collections.sort(list);
	}
	
	//遍历
	public static void print(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int count = 0;
		while (it.hasNext()) {
			System.out.println("第" + ++count + "个元素：" + it.next());
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = randomNumber();
		System.out.println("排序前：----------------");
		print(list);
		sort(list);
		System.out.println("排序后：----------------");
		print(list);
	}
}
/*
 *************** jdk1.8运行结果***************
排序前：----------------
第1个元素：80
第2个元素：45
第3个元素：12
第4个元素：58
第5个元素：63
第6个元素：40
第7个元素：30
第8个元素：20
第9个元素：86
第10个元素：38
排序后：----------------
第1个元素：12
第2个元素：20
第3个元素：30
第4个元素：38
第5个元素：40
第6个元素：45
第7个元素：58
第8个元素：63
第9个元素：80
第10个元素：86
 */
