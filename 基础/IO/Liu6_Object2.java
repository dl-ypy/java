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
 * date:2017年5月22日20:40:59
 * target:序列化的控制。
 * @author ypy 
 */
class A implements Externalizable {
	private int i;
	private String s;
	
	public A() {
		System.out.println("A类初始化！");
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
    	A a = new A("海阔天空", 123);
    	System.out.println("原始数据：" + a);
    	try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("test.out"));
			System.out.println("保存objects");
			o.writeObject(a);
			o.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.out"));
			System.out.println("恢复 a!");
			a = (A) in.readObject();
			System.out.println("恢复数据：" + a);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
/*
 *************** jdk1.8运行结果*************** 
原始数据：海阔天空123
保存objects
A.writeExternal
恢复 a!
A类初始化！
A.readExternal
恢复数据：海阔天空123
 */
