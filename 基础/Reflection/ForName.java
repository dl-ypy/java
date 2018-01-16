/**
 * date:2017��5��23��10:26:53
 * target:forName�����ࡣ
 * @author ypy
 * conclusion:
 *     ÿ��Class ֻ��������Ҫ��ʱ��Ż����룬��static��ʼ����������������ʱִ�еġ�
 */
class Candy {
	static {
		System.out.println("����Candy�࣡");
	}
}

class Gum {
	static {
		System.out.println("����Gum�࣡");
	}
}

class Cookie {
	static {
		System.out.println("����Cookie�࣡");
	}
}

public class ForName {
	public static void main(String[] args) {
		System.out.println("main");
		new Candy();
		System.out.println("����Candy��...");
		try {
			Class.forName("Gum");//����а���Ҫ���ϰ���
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Class.forName(\"Gum\")��...");
		new Cookie();
		System.out.println("����Cookie��...");
	}
}
/*
 *************** jdk1.8���н��*************** 
main
����Candy�࣡
����Candy��...
����Gum�࣡
Class.forName("Gum")��...
����Cookie�࣡
����Cookie��...
 */
