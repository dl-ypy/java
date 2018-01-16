package dao;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * date:2017��5��22��20:40:59
 * target:���л��Ŀ��ơ�
 * @author ypy 
 */
class A implements Externalizable {
	private int i;
	private String s;
	
	public A() {
		System.out.println("A���ʼ����");
	}
	public A(String s, int i) {
		this.i = i;
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s + i;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("A.writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("A.readExternal");
		s = (String) in.readObject();
		i = in.readInt();
	}
	
}

public class Liu6_Object2 {
    public static void main(String[] args) {
    	A a = new A("�������", 123);
    	System.out.println("ԭʼ���ݣ�" + a);
    	try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("test.out"));
			System.out.println("����objects");
			o.writeObject(a);
			o.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.out"));
			System.out.println("�ָ� a!");
			a = (A) in.readObject();
			System.out.println("�ָ����ݣ�" + a);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
/*
 *************** jdk1.8���н��*************** 
ԭʼ���ݣ��������123
����objects
A.writeExternal
�ָ� a!
A���ʼ����
A.readExternal
�ָ����ݣ��������123
 */
