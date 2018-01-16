/**
 * date:2017��5��24��11:13:39
 * target:clone��������ǳ���¡��
 * @author ypy
 * conclusion:
 *     Java �е������Ա�����������ݶ���ͨ�����ݾ�����еġ�
 *     Object.clone()��ʽ��ʼ����ǰ�����Ȼ���һ�����Ƿ�Cloneable�����Ƿ���п�¡������
 *     Ȼ��Object.clone()����ԭ�ȵĶ����ж����Ϊ�¶����ڳ��㹻����ڴ棬�����ж�����λ��ԭ���Ķ����Ƶ��¶������������λ���ơ���
 *     ����㸴�ơ���ҪΪ������ÿ���������Ͷ����и��ơ�
 */
class A implements Cloneable {//ʵ��Cloneable�ӿڱ�ʾ���Ա���¡
	int i;
	public A(int i) {
		this.i = i;
	}
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();//�������е�clone������protected�ģ����������е���
		} catch (CloneNotSupportedException e) {
			System.out.println("���ܿ�¡��");
		}
		return o;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

public class Clone_1 {
	public static A g(A a) {//����¡����++
		a.i++;
		return a;
	}
	public static A f(A a) {//��¡�����++��ִ��++��ֻ�ǿ�¡��Ķ���
		a = (A) a.clone();
		a.i++;
		return a;
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		A a = new A(11);
		A b = g(a);
		
		if (a == b) {//a==b�����Ҷ�������++
			System.out.println("a==b");
		} else {
			System.out.println("a!=b");
		}
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
		A a1 = new A(55);
		A b1 = f(a1);
		
		if (a1 == b1) {//a1!=b1��ֻ�Կ�¡��Ķ��������++
			System.out.println("a1==b1");
		} else {
			System.out.println("a1!=b1");
		}
		
		System.out.println("a1=" + a1);
		System.out.println("b1=" + b1);
	}
}
/*
 *************** jdk1.8���н��*************** 
a==b
a=12
b=12
a1!=b1
a1=55
b1=56
 */
