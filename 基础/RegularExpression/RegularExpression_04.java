/*
ʱ�䣺2016��11��7��10:22:44
Ŀ�ģ�Ԥ�����ַ���
*/
import java.util.regex.*;

public class RegularExpression_04{
	public static void main(String[] args){
		s(" \n\r\t".matches("\\s{4}"));//�հ��ַ���[ \t\n\x0B\f\r]  ǡ��4��
		s(" ".matches("\\S"));//�ǿհ��ַ���[^\s]
		s("a_8".matches("\\w{3}"));//�����ַ���[a-zA-Z_0-9]
		s("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		s("\\".matches("\\\\"));//java��\��ʾת���ַ�������Ҫ��\\��ʾ\��������ʽ����ƥ��\������Ҫ\\,Ҫ��\\���ַ�����ʽ���ֳ���������Ҫ\\\\
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
true
false
true
true
true
*/