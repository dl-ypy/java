/*
ʱ�䣺2016��11��5��16:19:49
Ŀ�ģ��˽�������ʽ
*/
import java.util.regex.*;

public class RegularExpression_01{
	public static void main(String[] args){
		s("abc".matches("..."));//�ַ���ƥ�䣨�ַ�ƥ�䣩
													  //һ��.����һ���ַ�������ΪBoolean��
		s("a98j78768p".replaceAll("\\d", "-"));//���ַ����е�����ת��Ϊ-
																					 // \d��ʾ����0-9����ΪJava�����и�ת���ַ�������Ϊ\\d
																					 //�ο������ĵ���Pattern������
		Pattern p = Pattern.compile("[a-z]{3}");//��������������ʽ���뵽ģʽ��
																						//ƥ��a-z�е�����������ĸ
		Matcher m = p.matcher("dfg");//����ƥ������������ģʽ��ƥ����
		s(m.matches());
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
true
a--j-----p
true
*/