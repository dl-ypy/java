/*
ʱ�䣺2016��10��14��09:17:53
Ŀ�ģ���Comparable�ӿ�ʵ�ֶ��Զ����������
			ע��ArrayList�е�Ԫ���ǿ��ظ���
*/
import java.util.*;

class Student implements Comparable{//��ΪCollectios�಻�ܶ��Զ������������򣨲�֪���Զ�����������׼������ʲô��׼����,����Ҫ��Comparable
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
	
	@Override
	public int compareTo(Object o){//Comparable�ӿ��еķ���
		Student st = (Student)o;//Student�̳���Object,����Ҫ���������ǿ��ת��Ϊ���࣬����ʹ���������еĳ�Ա
		if (this.id == st.id)
			return 0;
		else if (this.id > st.id)
			return 1;
		else
			return -1;
	}
}

public class Container_03Comparable{
	public static void main(String[] args){
		List L = new ArrayList();
		L.add(new Student(1000, "mj"));
		L.add(new Student(1003, "ypy"));
		L.add(new Student(1002, "kb"));
		L.add(new Student(1002, "kb"));//����ͬ������Ԫ�أ����ظ�
		
		Collections.sort(L);//sort�������Զ����������comparableTo����
		System.out.println(L);
	}
}
/*
***************��������***************
G:\java\����>javac Container_03Comparable.java
ע: Container_03Comparable.javaʹ����δ�����򲻰�ȫ�Ĳ�����
ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:unchecked ���±��롣

G:\java\����>java Container_03Comparable
[1000  mj, 1002  kb, 1002  kb, 1003  ypy]

G:\java\����>
*/