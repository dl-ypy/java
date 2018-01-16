import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * date:2017年5月25日15:58:12
 * target:clone深层克隆之序列化。
 * @author ypy
 * conclusion:
 *     序列化实际经历的是一个“克隆”的过程。
 *     序列化与克隆的区别：用时的多少。
 */
class Thing1 implements Serializable {
}

class Thing2 implements Serializable {
	Thing1 o1 = new Thing1();
}

class Thing3 implements Cloneable {
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Thing3不能克隆！");
		}
		return o;
	}
}

class Thing4 implements Cloneable {
	Thing3 o3 = new Thing3();

	public Object clone() {
		Thing4 o = null;
		try {
			o = (Thing4) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Thing4不能克隆！");
		}
		o.o3 = (Thing3) o3.clone();//对此类中的其他对象句柄进行克隆
		return o;
	}
}

public class Clone_4 {
	static final int SIZE = 5000;
	public static void main(String[] args) {
		//实验序列化的原始数据
		Thing2[] a = new Thing2[SIZE];
		for (int i=0; i<a.length; i++) {
			a[i] = new Thing2();
		}
		//实验克隆的原始数据
		Thing4[] b = new Thing4[SIZE];
		for (int i=0; i<b.length; i++) {
			b[i] = new Thing4();
		}
		
		long t1 = System.currentTimeMillis();
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		try {
			ObjectOutputStream o = new ObjectOutputStream(buf);
			for (int i=0; i<a.length; i++) {
				o.writeObject(a[i]);
			}
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
			Thing2[] c = new Thing2[SIZE];
			for (int i=0; i<c.length; i++) {
				c[i] = (Thing2) in.readObject();
			}
			long t2 = System.currentTimeMillis();
			System.out.println("序列化时间：" + (t2-t1));
			
			t1 = System.currentTimeMillis();
			Thing4[] d = new Thing4[SIZE];
			for (int i=0; i<d.length; i++) {
				d[i] = (Thing4) b[i].clone();
			}
			t2 = System.currentTimeMillis();
			System.out.println("克隆时间：" + (t2-t1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
/*
 *************** jdk1.8运行结果***************
 序列化时间：196
 克隆时间：3
 */
