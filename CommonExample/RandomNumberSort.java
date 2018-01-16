import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * date:2017��6��9��10:20:03
 * target:����10�����������������
 * @author ypy
 */
public class RandomNumberSort{
	//����10�������
	public static List<Integer> randomNumber() {
		List<Integer> list = new ArrayList<>();
		Random r = new Random();
		for (int i=0; i<10; i++) {
			list.add(r.nextInt(100));//���������0��������100֮��
		}
		return list;
	}
	
	//��List�е�Ԫ������
	public static void sort(List<Integer> list) {
		Collections.sort(list);
	}
	
	//����
	public static void print(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int count = 0;
		while (it.hasNext()) {
			System.out.println("��" + ++count + "��Ԫ�أ�" + it.next());
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = randomNumber();
		System.out.println("����ǰ��----------------");
		print(list);
		sort(list);
		System.out.println("�����----------------");
		print(list);
	}
}
/*
 *************** jdk1.8���н��***************
����ǰ��----------------
��1��Ԫ�أ�80
��2��Ԫ�أ�45
��3��Ԫ�أ�12
��4��Ԫ�أ�58
��5��Ԫ�أ�63
��6��Ԫ�أ�40
��7��Ԫ�أ�30
��8��Ԫ�أ�20
��9��Ԫ�أ�86
��10��Ԫ�أ�38
�����----------------
��1��Ԫ�أ�12
��2��Ԫ�أ�20
��3��Ԫ�أ�30
��4��Ԫ�أ�38
��5��Ԫ�أ�40
��6��Ԫ�أ�45
��7��Ԫ�أ�58
��8��Ԫ�أ�63
��9��Ԫ�أ�80
��10��Ԫ�أ�86
 */
