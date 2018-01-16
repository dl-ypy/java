import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * date:2017��4��22��17:54:53
 * target:ListIterator��
 * @author ypy
 * conclusion:
 *     ListIterator��Iterator���һЩ������
 *     ListIteratorֻ������List�������ࡣ
 */
public class Container_11 {
	public static void main(String[] args) {
		List<Object> arraylist = new ArrayList<>();
		for (int i=0; i<5; i++) {
			arraylist.add(i);
		}
		print2(arraylist);
	}
	
	public static void print2(List<Object> o) {
		System.out.println("-------------------");
		ListIterator<Object> it = o.listIterator();
		it.add("����Ԫ��");   //ListIterator�������Ԫ�أ������ڵ�ǰ�α��ǰ����ӣ����Ե�һ��˳�����ʱ������ʾ
						    //�����һ�α���Ϊ����������Ϳ�����ʾ����
		while (it.hasNext()) {
			System.out.println("���غ�������" + it.nextIndex());
			System.out.println(it.next());
		}
		System.out.println("-------------------");
		while (it.hasPrevious()) {  //ListIterator���������������������˳�����֮����Ϊ��һ�α���ʱ��
			                        //�α�λ�ڵ�һ��Ԫ�ص�ǰ�棬��������������ǰ��û��Ԫ��
			System.out.println(it.previous());
		}
		System.out.println("-------------------");
		while (it.hasNext()) {
			System.out.println("����ǰ������" + it.previousIndex());
			System.out.println(it.next());
		}
		System.out.println("-------------------");
		it.set("�޸�");   //ListIterator�����޸�Ԫ��
						 //��ָ��Ԫ���滻 next �� previous ���ص����һ��Ԫ�أ���ѡ��������
					     //ֻ�������һ�ε��� next �� previous ���û�е��� ListIterator.remove Ҳû�е��� ListIterator.add ʱ�ſ��Խ��иõ��á�
		                 //��ʵ�����ڵ��ø÷���ǰ���һ�ε��õ�next�����ϸ�˳����������һ����
		                 //�����������������ʱ��������޸ĺ��Ԫ���ǵ�һ��
		while (it.hasPrevious()){
			System.out.println(it.previous());
		}
		System.out.println("-------------------");
		it.remove();  //ɾ��Ԫ�أ���set������ʹ������
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
/*
 * *************** jdk1.8���н��*************** 
-------------------
���غ�������1
0
���غ�������2
1
���غ�������3
2
���غ�������4
3
���غ�������5
4
-------------------
4
3
2
1
0
����Ԫ��
-------------------
����ǰ������-1
����Ԫ��
����ǰ������0
0
����ǰ������1
1
����ǰ������2
2
����ǰ������3
3
����ǰ������4
4
-------------------
�޸�
3
2
1
0
����Ԫ��
-------------------
0
1
2
3
�޸�
 */
