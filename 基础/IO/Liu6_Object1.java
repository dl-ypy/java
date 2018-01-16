/*
ʱ�䣺2016��10��12��11:08:36
Ŀ�ģ���������л�
      ��object���͵�����д�룬�������ɿ�ƽ̨
*/
import java.io.*;

public class Liu6_Object1{
	public static void main(String[] args) throws Exception{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Student ss = new Student("ypy", 20, 88.8f);
		Student ss2 = null;
		
		//д���ļ�
		FileOutputStream fos = new FileOutputStream("object_output.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(ss);
		//��ȡ�ļ�
		ois = new ObjectInputStream(new FileInputStream("object_output.txt"));
		ss2 = (Student)ois.readObject();
		
		System.out.println("name:" + ss2.sname);
		System.out.println("id:" + ss2.sid);
		System.out.println("score:" + ss2.sscore);
	}
}

class Student implements Serializable{//ʵ����һ���սӿڣ��սӿ���һ�ֱ�ʶ����ʾ���ʵ�ָýӿھ��������л������򣬾Ͳ��������л�
	public String sname = null;
	transient public int sid = 0;//transient��ʾ���������л�������˵����writeObjectд��ʱ�Ͳ�����д��
	public float sscore = 0;
	
	public Student(String name, int id, float score){
		this.sname = name;
		this.sid = id;
		this.sscore = score;
	}
}
/*
***************��������***************
G:\java\����>javac Liu6_Object.java

G:\java\����>java Liu6_Object
name:ypy
id:0
score:88.8

G:\java\����>
*/