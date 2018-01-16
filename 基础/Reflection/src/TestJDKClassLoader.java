//JDK����ClassLoader
public class TestJDKClassLoader {

	public static void main(String[] args) {
		System.out.println(String.class.getClassLoader());//������
		System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());//�Լ��������
		System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());//ϵͳ��
		
		System.out.println("--------------------");
		
		//��ӡ��parents   ע�⣺���Ǽ̳У�����������
		//���ع��̣���������һ����ClassLoader�Ƿ���أ���������ˣ��Ͳ����ظ�����
		ClassLoader c = TestJDKClassLoader.class.getClassLoader();
		while (null != c){
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
	}

}
/*
***************JDK1.8���н��***************
null
sun.misc.Launcher$AppClassLoader
sun.misc.Launcher$AppClassLoader
--------------------
sun.misc.Launcher$AppClassLoader
sun.misc.Launcher$ExtClassLoader
*/