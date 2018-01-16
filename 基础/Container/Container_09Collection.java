import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * date:2017��4��22��09:06:38
 * target:Collection�ӿڵĳ��÷�����
 * @author ypy
 * conclusion:
 *     List��Set��ʵ����Collection�ӿڡ�
 */
public class Container_09Collection {
	public static void main(String[] args) {
		Collection<Object> c = new ArrayList<>();
		System.out.println("�Ƿ�ɹ����Ԫ��A?" + c.add("A"));   //���Ԫ�ز���������ɹ�������true
		c.add(2.222);
		c.add(new A());
		Collection<Object> c0 = new ArrayList<>();
		c0.add("c0���ϵ�Ԫ��");
		Collection<Object> c1 = new ArrayList<>();
		c1.add(20);
		c1.addAll(c);   //�����һ�����ϣ�������˼����е�����Ԫ��
		c1.addAll(c0);
		System.out.println("�Ƿ����Ԫ��A?" + c1.contains("A"));//�ж��Ƿ����ĳ��Ԫ��
		System.out.println("�Ƿ��������c?" + c1.containsAll(c));//�ж��Ƿ����һ������
		System.out.println("���ϰ�����Ԫ�ظ���Ϊ��" + c1.size());  //���ؼ���������Ԫ�ص�����
		
		//��ӡԪ��
		Iterator<Object> it = c1.iterator();
		System.out.println("-----------------");
		System.out.println("ɾ��ǰ����c1�а���Ԫ�أ�");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		Object[] a = c1.toArray();  //���ذ�����������Ԫ�ص�����
		System.out.println("-----------------");
		System.out.println("ת��Ϊ���飺");
		for (int i=0; i<a.length; i++) {
			System.out.println("a[" + i + "]:" + a[i]);
		}
		
		System.out.println("-----------------");
		System.out.println("ɾ��Ԫ��A��");
		c1.remove("A");//ɾ��������������ĳ��Ԫ��
		Iterator<Object> it1 = c1.iterator();//�ù�һ��iterator�󣬱����ٴ�����һ����������
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		System.out.println("-----------------");
		System.out.println("ɾ������c��");
		c1.removeAll(c);//ɾ��������������ĳ������
		Iterator<Object> it2 = c1.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println("-----------------");
		System.out.println("ֻ����c0���ϵ�Ԫ�غ�");
		c1.retainAll(c0);//ֻ����ĳ�����ϵ�Ԫ��
		Iterator<Object> it3 = c1.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		System.out.println("-----------------");
		System.out.println("�������Ԫ�غ�");
		c1.clear();//�������Ԫ��
		Iterator<Object> it4 = c1.iterator();
		while (it4.hasNext()) {
			System.out.println(it4.next());
		}
		System.out.println(c1.isEmpty());//�жϼ����Ƿ�Ϊ��
	}
}

class A {
	@Override
	public String toString() {
		return "A���toString����";
	}
}
/*
 * *************** jdk1.8���н��*************** 
�Ƿ�ɹ����Ԫ��A?true
�Ƿ����Ԫ��A?true
�Ƿ��������c?true
���ϰ�����Ԫ�ظ���Ϊ��5
-----------------
ɾ��ǰ����c1�а���Ԫ�أ�
20
A
2.222
A���toString����
c0���ϵ�Ԫ��
-----------------
ת��Ϊ���飺
a[0]:20
a[1]:A
a[2]:2.222
a[3]:A���toString����
a[4]:c0���ϵ�Ԫ��
-----------------
ɾ��Ԫ��A��
20
2.222
A���toString����
c0���ϵ�Ԫ��
-----------------
ɾ������c��
20
c0���ϵ�Ԫ��
-----------------
ֻ����c0���ϵ�Ԫ�غ�
c0���ϵ�Ԫ��
-----------------
�������Ԫ�غ�
true
 */
