/**
 * date:2017��6��7��11:10:21
 * target:�ַ����ķ�ת���滻��
 * @author ypy
 */
public class String_6 {
	public static String str = "abc";
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();//��ԭ���ַ�����ת
		System.out.println("��ת��" + sb);
		System.out.println(str.replace("b", "mm"));//�滻�ַ�
	}
}
/*
 *************** jdk1.8���н��***************
��ת��cba
ammc
 */
