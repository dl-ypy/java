import java.util.Arrays;
import java.util.Comparator;

/**
 * date:2017��7��3��15:31:03
 * target:Comparator�Զ�����бȽϣ���һ����ͨ��ʵ��Compareable�ӿڡ�
 * @author ypy
 */
public class Comparator {
	public static void main(String[] args) {
		A[] arr = new A[]{new A(4), new A(2), new A(1)};
		Arrays.sort(arr, new MyComparator());//ͨ��ָ���ȽϷ�ʽ�Ƚ�
		System.out.println(arr[0].getI()+","+arr[1].getI()+","+arr[2].getI());
	}
}

class A{
	private int i;

	public A(int i) {
		super();
		this.i = i;
	}

	public A() {
		super();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

//�Զ���ıȽϷ�ʽ
class MyComparator implements Comparator<A> {

	@Override
	public int compare(A o1, A o2) {
		if (o1.getI() > o2.getI()) {
			return 1;
		} else if (o1.getI() < o2.getI()) {
			return -1;
		}
		return 0;
	}
	
}
/*
***************JDK1.8���н��****************
1,2,4
*/
