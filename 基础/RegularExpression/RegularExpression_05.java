/*
ʱ�䣺2016��11��7��10:56:33
Ŀ�ģ��߽�ƥ����
*/
import java.util.regex.*;

public class RegularExpression_05{
	public static void main(String[] args){
		s("hello sir".matches("^h.*"));//^ �еĿ�ͷ   ������0�����������ַ�
		s("hello sir".matches(".*ir$"));//$ �еĽ�β 
		s("hello sir".matches("^h[a-z]{1,3}o\\b.*"));//\b ���ʱ߽� 
		s("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		s(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//�հ���""+����
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
true
true
true
false
true
*/