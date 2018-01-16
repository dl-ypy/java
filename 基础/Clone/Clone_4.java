import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * date:2017��5��25��15:58:12
 * target:clone����¡֮���л���
 * @author ypy
 * conclusion:
 *     ���л�ʵ�ʾ�������һ������¡���Ĺ��̡�
 *     ���л����¡��������ʱ�Ķ��١�
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
			System.out.println("Thing3���ܿ�¡��");
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
			System.out.println("Thing4���ܿ�¡��");
		}
		o.o3 = (Thing3) o3.clone();//�Դ����е��������������п�¡
		return o;
	}
}

public class Clone_4 {
	static final int SIZE = 5000;
	public static void main(String[] args) {
		//ʵ�����л���ԭʼ����
		Thing2[] a = new Thing2[SIZE];
		for (int i=0; i<a.length; i++) {
			a[i] = new Thing2();
		}
		//ʵ���¡��ԭʼ����
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
			System.out.println("���л�ʱ�䣺" + (t2-t1));
			
			t1 = System.currentTimeMillis();
			Thing4[] d = new Thing4[SIZE];
			for (int i=0; i<d.length; i++) {
				d[i] = (Thing4) b[i].clone();
			}
			t2 = System.currentTimeMillis();
			System.out.println("��¡ʱ�䣺" + (t2-t1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
/*
 *************** jdk1.8���н��***************
 ���л�ʱ�䣺196
 ��¡ʱ�䣺3
 */
