import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * date:2017��4��24��09:42:45
 * target:Collections��ʹ�á�
 * @author ypy
 * conclusion:
 *     Collections�Ǽ������һ��������/�����࣬�����ṩ��һϵ�о�̬���������ڶԼ�����Ԫ�ؽ������������Լ��̰߳�ȫ�ȸ��ֲ�����
 */
public class Container_02Collections{
	public static void main(String[] args){
		System.out.println("Collectionֻ����");
		Collection<Object> c = new ArrayList<>();
		add(c);
		c = Collections.unmodifiableCollection(c);  //�ɶ����������޸�
		//c.add(2);  �����������
		print(c);
		System.out.println("-----------------");
		
		System.out.println("Listֻ����");
		List<Object> l = new ArrayList<>();
		add(l);
		l = Collections.unmodifiableList(l);
		//l.add(2);
		print(l);
		System.out.println("-----------------");
		
		System.out.println("Setֻ����");
		Set<Object> s = new HashSet<>();
		add(s);
		s = Collections.unmodifiableSet(s);
		//s.add(2);
		print(s);
		System.out.println("-----------------");
		
		System.out.println("Mapֻ����");
		Map<Object,Object> m = new HashMap<>();
		m.put(1, "ss");
		m.put(2, "a");
		m = Collections.unmodifiableMap(m);
		//m.put(3, "e");
		System.out.println(m);
		System.out.println("-----------------");
		
		
		//���Ƽ��ϵ�ͬ��
		Collection<Object> c1 = Collections.synchronizedCollection(new ArrayList<>());
		List<Object> l1 = Collections.synchronizedList(new ArrayList<>());
		Set<Object> s1 = Collections.synchronizedSet(new HashSet<>());
		Map<Object,Object> m1 = Collections.synchronizedMap(new HashMap<>());
		
		
		//���Ƽ���˳��
		List<Integer> list = new ArrayList<>();
		System.out.println("��ʼ˳��");
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.shuffle(list);//����˳��
		System.out.println("����˳���");
		System.out.println(list);
		System.out.println("���������");
		Collections.sort(list); //Ĭ��Ϊ��������
		System.out.println(list);
		System.out.println("���ַ����ң�");
		System.out.println("Ԫ��4��λ�ã�" + Collections.binarySearch(list, 4));//ֻ�����������е�ǰ���²��ܶ��ַ�����
		System.out.println("˳���ã�");
		Collections.reverse(list);//��˳����
		System.out.println(list);
		
		
		//����...�ܶ෽��
	}
	
	public static void add(Collection<Object> c) {
		c.add(1);
		c.add("ff");
		c.add(null);
		c.add(false);
	}
	
	public static void print(Collection<Object> c) {
		Iterator<Object> it = c.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
 /* *************** jdk1.8���н��*************** 
Collectionֻ����
1
ff
null
false
-----------------
Listֻ����
1
ff
null
false
-----------------
Setֻ����
ff
null
1
false
-----------------
Mapֻ����
{1=ss, 2=a}
-----------------
��ʼ˳��
[1, 5, 3, 4]
����˳���
[1, 4, 3, 5]
���������
[1, 3, 4, 5]
���ַ����ң�
Ԫ��4��λ�ã�2
˳���ã�
[5, 4, 3, 1]
 */
