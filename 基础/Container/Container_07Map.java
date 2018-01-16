import java.util.*;
import java.util.Map.Entry;

/**
 * date:2017��4��23��16:55:35
 * target:Map��
 * @author ypy
 * conclusion:
 *     Map�в��ܰ����ظ���key��ÿһ��key����Ӧһ��value��
 *     HashMap,LinkedHashMap,TreeMap֮���������HashSet,LinkedHashSet,TreeSet֮����������ơ�
 *	       ע��Map��Ȼ����ǿ�󣨲�������ʱ����Ҫ�Ƚϣ������㷨ֱ�Ӽ������Ӧ�Ĵ洢��ַ��,
 *	       ����Ҳ��ȱ��,�㷨������,����ռ����⣬�ռ������ʵͣ����й�ϣ��ͻ�����⡣
 *     ��ΪKey�����ͣ�������дhashCode��equales��������ΪKeyֵ��Ψһ�ģ�Key��Value�Ĺ�ϵ��һ�Զ�Ĺ�ϵ��
 *     ��TreeMap����ʵ��Comparable�ӿڣ���Ϊ������ġ�
 *     Map�ɴ��null������������
 *     Hashtable������null��
 */
class Student{
	private int key;
	private int age;
	private String name;
	
	public Student(int key, int age, String name){
		this.key = key;
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "[" + key + "," + name + "," + age + "]";
	}
}

public class Container_07Map{
	public static void main(String[] args){
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		System.out.println("HashMap��ȡ�����������ͣ�");
		m1.put(1, "b");
		m1.put(1, "b");
		m1.put(4, "e");
		m1.put(3, "a");
		System.out.println(m1);
		System.out.println("-------------------");
		
		System.out.println("HashMap��ȡ�ǻ����������ͣ�");
		Map<Integer, Student> m = new HashMap<Integer, Student>();
		m.put(1001, new Student(1001, 20, "a"));//�˴���1001Ҳʵ�����Զ�װ�似��
		m.put(1002, new Student(1002, 22, "b"));
		m.put(1005, new Student(1002, 22, "b"));
		m.put(1003, new Student(1003, 23, "c"));
		System.out.println(m);
		System.out.println("-------------------");
		
		//��������Ԫ�ط���һ������ȡkey�����ܿ���ͨ��key��ȡ��value����Ҫ���ȡkey��value���ǽ����õ����ֱ���������Ч�ʸߣ�
		System.out.println("����һ��m�����е�����Ԫ���ǣ�");
		Set s = m.keySet();//��ȡ��ǰ�������������ļ���
		Iterator it = s.iterator();
		while (it.hasNext()){
			Integer key = (Integer)it.next();//�õ������е�ÿ����������ԭ����Object����ת��ΪInteger����,��Ϊ��ǰ���Զ�װ��ʱת��ΪInteger����
			System.out.println(m.get(key));//�õ���Ϊkey�����ݲ����
		}
		System.out.println("-------------------");
		
		//��������Ԫ�ط�����������ȡvalue��
		System.out.println("��������m�����е�����Ԫ���ǣ�");
		Collection<Student> collection = m.values();//����ֵ�Ǹ�ֵ��Collection����
		System.out.println(collection);
		System.out.println("-------------------");
		
		//��������Ԫ�ط�����������ȡkey��value��
		System.out.println("��������m�����е�����Ԫ���ǣ�");
		//ͨ��entrySet()������map�����е�ӳ���ϵȡ���������ϵ����Map.Entry���ͣ�
		Set<Entry<Integer, Student>> entrySet = m.entrySet();
		//����ϵ����entrySet���е�������ŵ���������                
		Iterator<Entry<Integer, Student>> it1 = entrySet.iterator();

		while(it1.hasNext()) {
		     Entry<Integer, Student> me = it1.next();//��ȡMap.Entry��ϵ����me
		     Integer key = me.getKey();//ͨ����ϵ�����ȡkey
		     Student value = me.getValue();//ͨ����ϵ�����ȡvalue
		     System.out.println("{" + key + "=" + value + "}");
		}
		System.out.println("-------------------");
		
		System.out.println("ֱ�Ӳ���ĳ��Ԫ��");
		System.out.println(m.get(1002));
		System.out.println(m.get(1000));//�Ҳ����Ļ᷵�ؿ�ֵ
	}
}
 /* *************** jdk1.8���н��*************** 
HashMap��ȡ�����������ͣ�
{1=b, 3=a, 4=e}
-------------------
HashMap��ȡ�ǻ����������ͣ�
{1001=[1001,a,20], 1002=[1002,b,22], 1003=[1003,c,23], 1005=[1002,b,22]}
-------------------
����һ��m�����е�����Ԫ���ǣ�
[1001,a,20]
[1002,b,22]
[1003,c,23]
[1002,b,22]
-------------------
��������m�����е�����Ԫ���ǣ�
[[1001,a,20], [1002,b,22], [1003,c,23], [1002,b,22]]
-------------------
��������m�����е�����Ԫ���ǣ�
{1001=[1001,a,20]}
{1002=[1002,b,22]}
{1003=[1003,c,23]}
{1005=[1002,b,22]}
-------------------
ֱ�Ӳ���ĳ��Ԫ��
[1002,b,22]
null
 */
