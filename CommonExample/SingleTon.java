/**
 * date:2017��6��30��11:04:25
 * target:����ģʽ
 * @author ypy
 */
public class SingleTon {
	public static void main(String[] args) {
		SingleTon1 s = SingleTon1.getInstance();
		System.out.println(s);
		SingleTon1 s1 = SingleTon1.getInstance();
		System.out.println(s1);
		SingleTon2 s2 = SingleTon2.getInstance();
		System.out.println(s2);
		SingleTon2 s3 = SingleTon2.getInstance();
		System.out.println(s3);
	}
}

//����ģʽ  �����ʱ�ʹ�������  �����ڹ��췽���д��ݲ���
class SingleTon1 {
	private static final SingleTon1 instance = new SingleTon1();
	
	private SingleTon1() {
		
	}
	
	public static SingleTon1 getInstance() {
		return instance;
	}
}

//����ģʽ  ֻ���ⲿ�����һ������ʵ����ʱ���ȥ������
class SingleTon2 {
	private SingleTon2() {
		
	}
	
	private static SingleTon2 instance = null;
	
	public static SingleTon2 getInstance() {  //�ɼ�synchronized�����Ͼ�Ϊ�̰߳�ȫ�ģ���Ч�ʵ�
		if (instance == null) {
			instance = new SingleTon2();
		}
		return instance;
	}
}


/*
***************JDK1.8���н��****************
SingleTon1@15db9742
SingleTon1@15db9742
SingleTon2@6d06d69c
SingleTon2@6d06d69c
*/
