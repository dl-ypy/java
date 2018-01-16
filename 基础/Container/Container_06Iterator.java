/*
ʱ�䣺2016��10��17��08:37:12
Ŀ�ģ�Iterator�ӿڵ�ʹ��
*/
import java.util.*;

public class Container_06Iterator{
	
	//�����Ǿ�̬��������Ϊ�������main������Ҫ���ã���main�����Ǿ�̬�ģ���̬�������ܵ��÷Ǿ�̬����
	public static void showCollection(Collection c){//�ܹ�����κ�����
		Iterator it = c.iterator();
		while (it.hasNext()){//hasNext()�������ж���û����һ�����տ�ʼ��ʱ���α�λ�ڵ�һ��Ԫ�ص�ǰ��
			System.out.println(it.next());//ִ��next()�����������α��ұߵ��Ǹ�Ԫ�أ��α������һλ
		}
	}
	
	public static void main(String[] args){
		ArrayList al = new ArrayList();
		al.add("one");
		al.add(22);
		al.add(new Point(1, 1));
		System.out.println("al�����������ǣ�");
		showCollection(al);
	}
}

class Point{
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>java Container_06Iterator
al�����������ǣ�
one
22
(1,1)

G:\java\����>
*/