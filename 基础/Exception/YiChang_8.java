/**
 * date:2017��4��26��17:13:41 
 * target:�쳣��ƥ�䡣
 * @author ypy conclusion:
 *         Collections�Ǽ������һ��������/�����࣬�����ṩ��һϵ�о�̬���������ڶԼ�����Ԫ�ؽ������������Լ��̰߳�ȫ�ȸ��ֲ�����
 */
class Father extends Exception {
}

class Children extends Father {
}

public class YiChang_8 {
	public static void main(String[] args) {
		try {
			throw new Children();
		} catch (Children a) {          //�Ȳ��������쳣���ֲ������쳣�����������쳣�ڸ����쳣��ǰ�棬�ܹ���ȷƥ�䡣
										//ֻ�������쳣��Ҳ����ȷ����
										//�Ȳ��������쳣���ֲ������쳣�����������쳣�ڸ����쳣�ĺ��棬�ͻ����
			System.out.println("Caught Father");
		} catch (Father a) {
			System.out.println("Caught Father");
		}
	}
}
/*
 * *************** jdk1.8���н��*************** 
 * Caught Father
 */
