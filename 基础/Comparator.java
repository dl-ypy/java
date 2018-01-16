import java.util.Arrays;
import java.util.Comparator;

/**
 * date:2017年7月3日15:31:03
 * target:Comparator对对象进行比较，另一种是通过实现Compareable接口。
 * @author ypy
 */
public class Comparator {
	public static void main(String[] args) {
		A[] arr = new A[]{new A(4), new A(2), new A(1)};
		Arrays.sort(arr, new MyComparator());//通过指定比较方式比较
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

//自定义的比较方式
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
***************JDK1.8运行结果****************
1,2,4
*/
