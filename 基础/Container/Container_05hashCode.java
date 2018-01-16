/*
ʱ�䣺2016��10��16��09:49:06
Ŀ�ģ�ΪʲôҪ��дhashCode����
			java�Զ�������Ѿ���д��hashCode������new����ͬ���ݣ���ͬ�ڴ�ռ䣩�Ĺ�ϣ������ͬ�ģ���String��Integer
			���Լ��������û����дhashCode������������ͬ���ݵĹ�ϣ��Ҳ�ǲ�ͬ�ģ��籾�����е�A��
			���Թ�ϣ��Ϊ�ڲ��洢ģʽ�������У�Ҫ��Ƚ�����ֵ�Ƿ���ͬ������ͨ����ϣ���ҵ���Ӧ���ڴ��ַ��Ȼ���ڸõ�ַ��Ӧ�������н��бȽ�
			����Ҫ��ȥ���ظ���ֵ��������дhashCode����������ͬһ���ڴ��ַ����Ӧ�������У���ͨ����дequals�����������ڽ��бȽ�
*/
import java.util.*;

class A{
	private int id;
	
	public A(int id){
		this.id = id;
	}
}

class B{
	private int id;
	
	public B(int id){
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		return new Integer(id).hashCode();
	}
}

public class Container_05hashCode{
	public static void main(String[] args){
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println("new A(1).hashCode() = " + new A(1).hashCode());
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println("new Integer(1).hashCode() = " + new Integer(1).hashCode());
		System.out.println("new String(\"ypy\").hashCode() = " + new String("ypy").hashCode());
		System.out.println("new String(\"ypy\").hashCode() = " + new String("ypy").hashCode());
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		System.out.println("new B(1).hashCode() = " + new B(1).hashCode());
		
		Integer it1 = new Integer(1);
		Integer it2 = new Integer(1);
		System.out.println(it1 == it2);
		System.out.println(it1.equals(it2));
		System.out.println(it1.hashCode() == it2.hashCode());
	}
}
/*
***************JDK1.8���н��***************
new A(1).hashCode() = 366712642
new A(1).hashCode() = 1829164700
new Integer(1).hashCode() = 1
new Integer(1).hashCode() = 1
new String("ypy").hashCode() = 119874
new String("ypy").hashCode() = 119874
new B(1).hashCode() = 1
new B(1).hashCode() = 1
false
true
true
*/