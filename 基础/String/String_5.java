import java.io.UnsupportedEncodingException;

/**
 * date:2017��6��1��10:55:31
 * target:��ĳ�ֱ����ʽ�����
 * @author ypy
 */
public class String_5 {
	public static void main(String[] args) {
		String str = "�������";
		try {
			String str2 = new String(str.getBytes("ISO-8859-1"));//���ISO-8859-1�����ʽ
			//String str2 = new String(str.getBytes("ISO-8859-1"),"UTF-8");//��ISO-8859-1�滻ΪUTF-8����
			//str2 = str2.trim();  //����һ����������ȥ����ͷ����β�Ŀհ�
			System.out.println(str2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
/*
 *************** jdk1.8���н��***************
????
 */
