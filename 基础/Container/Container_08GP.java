/*
ʱ�䣺2016��10��21��09:27:47
Ŀ�ģ����͵�ʹ��
      ʹ�÷��ͺ󣬱���ʱ�����о���
*/
import java.util.*;

class Student implements Comparable<Student>{//������Ƿ��ͣ����������ͣ���ǿ��ȫ��
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
	public int compareTo(Student st){//ʹ�÷��ͺ󣬴˴��Ĳ������ͱ�����ǰ�������Ƶ����ͣ��˴���Student����
		
		if (this.id == st.id)
			return 0;
		else if (this.id > st.id)
			return 1;
		else
			return -1;
	}
}

public class Container_08GP{
	public static void main(String[] args){
		List<Student> L = new ArrayList<Student>();//����
		L.add(new Student(1000, "mj"));
		L.add(new Student(1003, "ypy"));
		L.add(new Student(1002, "kb"));
		L.add(new Student(1002, "kb"));
		
		Collections.sort(L);
		System.out.println(L);
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>javac Container_08GP.java

G:\java\����>java Container_08GP
[1000  mj, 1002  kb, 1002  kb, 1003  ypy]

G:\java\����>
*/