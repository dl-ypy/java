import java.util.*;

/**
 * date:2017��4��23��09:29:00
 * target:Set��
 * @author ypy
 * conclusion:
 * 	   Set��������ԣ�Ԫ���ǲ����ظ��ġ�
 *     HashSet:
 * 	       HashSet��Ԫ�ش��˳�����ӽ�ȥʱ���˳��û���κι�ϵ��
 *         HashSet�ఴ�չ�ϣ�㷨����ȡ�����еĶ��󣬴�ȡ�ٶȱȽϿ졣
 *         HashSet�������ֵΪnull��Ԫ�أ������ֻ����һ��nullԪ�أ���Ŷ�����ᱨ��
 *         HashSet�����߳�ͬ���ġ�
 *         ʹ�ó���������ġ����ظ������ݼ��ϡ�
 *         ע���Լ�д���������дequals��hashCode����������ʵ�ֲ����ظ���
 *     LinkedHashSet:��HashSet�����ࣩ
 *         LinkedHashSet����Ԫ�ص����˳��
 *         ʹ�ó�����ά�������HashSet��
 *     TreeSet:
 *         ��������null��
 *         TreeSet�Ƕ�Set�е�Ԫ�ؽ��������ţ�TreeSet��ʵ����SortedSet�ӿڣ��ܹ��Լ����еĶ���������򣩡�
 *         ʹ�ó���������Ԫ�ش�С����ļ��ϣ�Ԫ����Ҫʵ��Comparable�ӿڡ� 
 *         ע���Լ�д���������дcompareTo��������ʵ�������������дcompareTo�ͻ��׳��쳣����
 *
 *     Set�д洢�����ݵ����Ͷ�������дhashCode��equales��������ΪSet�е�Ԫ���ǲ����ظ��ġ�
 */
class Teacher {
	private String name;
	private int id;
	
	public Teacher(int id, String name){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id + "  " + name;
	}
	
	public boolean equals(Object o){
		Teacher st = (Teacher)o;
		return st.id==this.id && st.name==this.name;
	}
	
	public int hashCode(){
		return new String(id+name).hashCode();//��Container_05hashCode.java�е�֪ʶ��֪��String(��ͬ����).hashCode()�Ĺ�ϣ������ͬ��
	}
}

class Student implements Comparable<Object>{
	private String name;
	private int id;
	
	public Student(int id, String name){
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id + "  " + name;
	}
	
	//TreeSet������дcompareTo����
	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;  
		//ע������Ƚ�ʱҪ��id��name���Ƚϣ�����ֻ�Ƚ�idʱ����TreeSet�ж��ظ�ʱ��ֻ��id��ͬ���ж�Ϊ�ظ�
		if ((this.id+this.name).hashCode() == (s.id+s.name).hashCode()) {
			return 0;
		} else if ((this.id+this.name).hashCode() > (s.id+s.name).hashCode()) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class Container_04Set{
	public static void main(String[] args){
		Set<Object> s1 = new HashSet<>();
		System.out.println("HashSet��ȡ�����������ͣ�");
		s1.add("a");   //java���������Ѿ���д��equals��hashCode����
		s1.add("b");
		s1.add("a");
		System.out.println(s1);
		System.out.println("----------------");
		
		Set<Teacher> S = new HashSet<Teacher>();
		System.out.println("HashSet��ȡ�ǻ����������ͣ�");
		S.add(new Teacher(1000, "a"));
		S.add(new Teacher(1003, "ypy"));
		S.add(new Teacher(1002, "kb"));//�ж���ظ�Ԫ��
		S.add(new Teacher(1002, "kb"));
		S.add(new Teacher(1002, "kb"));
		S.add(new Teacher(1002, "iiii"));
		S.add(null);       //HashSet�����ſ�ֵ
		
		System.out.println(S);
		System.out.println("----------------");
		
		
		System.out.println("LinkedHashSet��ȡ�����������ͣ�");
		Set<Object> linkedhashset = new LinkedHashSet<>();
		linkedhashset.add(5);
		linkedhashset.add(6);
		linkedhashset.add(6);
		linkedhashset.add("aaa");
		linkedhashset.add(1);
		linkedhashset.add(null);  //LinkedHashSet�����ſ�ֵ
		System.out.println(linkedhashset);
		System.out.println("----------------");
		
		System.out.println("LinkedHashSet��ȡ�ǻ����������ͣ�");
		Set<Object> linkedhashset1 = new LinkedHashSet<>();
		linkedhashset1.add(new Teacher(2,"w"));
		linkedhashset1.add(new Teacher(2,"w"));
		linkedhashset1.add(new Teacher(1,"m"));
		System.out.println(linkedhashset1);
		System.out.println("----------------");
		
		
		System.out.println("TreeSet��ȡ�����������ͣ�");
		Set<Object> treeset = new TreeSet<>();
		treeset.add(5);
		treeset.add(2);
		treeset.add(2);
		treeset.add(3);
		System.out.println(treeset);
		System.out.println("----------------");
		
		Set<Object> treeset1 = new TreeSet<>();
		System.out.println("TreeSet��ȡ�ǻ����������ͣ�");
		treeset1.add(new Student(5,"aa"));
		treeset1.add(new Student(3,"s"));
		treeset1.add(new Student(2,"a"));
		treeset1.add(new Student(2,"b"));
		treeset1.add(new Student(2,"b"));
		System.out.println(treeset1);
	}
}
/*
 * *************** jdk1.8���н��*************** 
HashSet��ȡ�����������ͣ�
[a, b]
----------------
HashSet��ȡ�ǻ����������ͣ�
[1002  kb, null, 1003  ypy, 1000  a, 1002  iiii]
----------------
LinkedHashSet��ȡ�����������ͣ�
[5, 6, aaa, 1, null]
----------------
LinkedHashSet��ȡ�ǻ����������ͣ�
[2  w, 1  m]
----------------
TreeSet��ȡ�����������ͣ�
[2, 3, 5]
----------------
TreeSet��ȡ�ǻ����������ͣ�
[2  a, 2  b, 3  s, 5  aa]
 */
