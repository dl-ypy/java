/**
 * date:2017��5��26��09:03:13
 * target:String��StringBuffer��StringBuilder��
 * @author ypy
 * conclusion:
 *     String�ǲ��ɱ�ģ����ַ���������������������ʱʹ�ã���������"+��+="��
 *     StringBuffer�ǿɱ�ģ����̰߳�ȫ�ġ�
 *     StringBuilder�ǿɱ�ģ��Ƿ��̰߳�ȫ�������ڵ��̵߳ģ�Ч�ʸߡ�
 */
public class Str_StrBuf_StrBud {
	public static void main(String[] args) {
		String s = "m";  //String���еĳ�Ա��final�������ǲ��ɱ��
		System.out.println(s.hashCode());
		s = "y";  //��ʱ���¸�ֵʵ�������´�����һ��String����
		System.out.println(s.hashCode());
	}
}
/*
 *************** jdk1.8���н��***************
109
121
 */
