/*
ʱ�䣺2016��10��13��10:10:31
Ŀ�ģ�Ϊʲô��Ҫ������
			��Ϊ�����������䣬����Ԫ�ر�����ͬһ���͵�
			���������д�ŵĶ��Ƕ������д������ֵ���ͻ��ڲ�ת���ɶ���
*/
import java.util.*;

class A{
	public String toString(){
		return "��д��toString����";
	}
}

public class Container_01{
	public static void main(String[] args){
		ArrayList al = new ArrayList();
		al.add(123);//���͵����ڲ���Integerʵ���ˡ��Զ�װ�䡱����˿��Ե���toString����
		al.add("ypy");//�ַ����ı������һ�������ܵ���toString����
		al.add(88.88);
		al.add(new A());
		//System.out.println(al[2]);  ������������
		System.out.println(al.get(2));//ʵ����һ�����鹦�ܵķ�ʽ
		Object[] objArr = al.toArray();//���Խ�����ת��Ϊ����
		System.out.println(objArr[3]);//ת��Ϊ�������������ķ�ʽʵ��
		System.out.println(al);//���ʱal����������󶼻���ø��Ե�toString����
	}
}
/*
***************��������***************
G:\java\����>javac Container.java
ע: Container.javaʹ����δ�����򲻰�ȫ�Ĳ�����
ע: �й���ϸ��Ϣ, ��ʹ�� -Xlint:unchecked ���±��롣

G:\java\����>java Container
88.88
��д��toString����
[123, ypy, 88.88, ��д��toString����]

G:\java\����>
*/