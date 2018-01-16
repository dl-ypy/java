/**
 * date:2017��7��5��16:24:15
 * target:������������ת��Ϊ�������֡�
 * @author ypy
 */
public class DigitTransitionRMB {
	public static final char[] data = new char[]{
			'��','Ҽ','��','��','��','��','½','��','��','��'
	};
	
	public static final char[] units = new char[]{
			'Ԫ','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��'	
	};
	
	public static void main(String[] args) {
		System.out.println(transition(87772109));
	}
	
	/**
	 * ������������ת��Ϊ��������
	 * @param money
	 * @return
	 */
	public static String transition(int money) {
		StringBuffer sb = new StringBuffer();
		int unit = 0;
		while (money != 0) {
			//���ʱ��С����������λ����������
			sb.insert(0, units[unit++]);
			int number = money%10;
			sb.insert(0, data[number]);
			money /= 10;
		}
		//ɾ��0����ĵ�λ
		for (int i=0; i<sb.length(); i++) {
			if (sb.charAt(i) == '��') {
				sb.deleteCharAt(i+1);
			}
		}
		return sb.toString();
	}
}

/*
***************JDK1.8���н��****************
��Ǫ�����ʰ����ǪҼ�����Ԫ
*/
