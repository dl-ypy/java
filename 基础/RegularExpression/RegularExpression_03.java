/*
ʱ�䣺2016��11��5��17:28:26
Ŀ�ģ���Χ
*/
import java.util.regex.*;

public class RegularExpression_03{
	public static void main(String[] args){
		s("a".matches("[abc]"));//a��b �� c
		s("a".matches("[^abc]"));//�κ��ַ������� a��b �� c
		s("A".matches("[a-zA-Z]"));//a �� z �� A �� Z����ͷ����ĸ��������
		s("A".matches("[a-z]|[A-Z]"));//ͬ��
		s("A".matches("[a-z[A-Z]]"));//ͬ��
		s("R".matches("[A-Z&&[RFG]]"));//A-Z��RFG�Ľ���
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
true
*/