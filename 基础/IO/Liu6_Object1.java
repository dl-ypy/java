/*
时间：2016年10月12日11:08:36
目的：程序的序列化
      将object类型的数据写入，读出，可跨平台
*/
import java.io.*;

public class Liu6_Object1{
	public static void main(String[] args) throws Exception{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Student ss = new Student("ypy", 20, 88.8f);
		Student ss2 = null;
		
		//写入文件
		FileOutputStream fos = new FileOutputStream("object_output.txt");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(ss);
		//读取文件
		ois = new ObjectInputStream(new FileInputStream("object_output.txt"));
		ss2 = (Student)ois.readObject();
		
		System.out.println("name:" + ss2.sname);
		System.out.println("id:" + ss2.sid);
		System.out.println("score:" + ss2.sscore);
	}
}

class Student implements Serializable{//实现了一个空接口，空接口是一种标识，表示如果实现该接口就允许序列化，否则，就不允许序列化
	public String sname = null;
	transient public int sid = 0;//transient表示不允许序列化，就是说在用writeObject写入时就不允许写入
	public float sscore = 0;
	
	public Student(String name, int id, float score){
		this.sname = name;
		this.sid = id;
		this.sscore = score;
	}
}
/*
***************程序运行***************
G:\java\基础>javac Liu6_Object.java

G:\java\基础>java Liu6_Object
name:ypy
id:0
score:88.8

G:\java\基础>
*/