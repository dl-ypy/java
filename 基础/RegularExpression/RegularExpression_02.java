/*
ʱ�䣺2016��11��5��16:52:08
Ŀ�ģ���ʶ . * +  Ԫ�ַ�(MetaCharacters)
*/
import java.util.regex.*;

public class RegularExpression_02{
	public static void main(String[] args){
		s("a".matches("."));//�κ��ַ������н���������ƥ��Ҳ���ܲ�ƥ�䣩
		s("aa".matches("aa"));
		s("aaaa".matches("a*"));//��λ���
		s("aaaa".matches("a+"));//һ�λ���
		s("".matches("a*"));
		s("aaaa".matches("a?"));//һ�λ�һ��Ҳû��
		s("".matches("a?"));
		s("a".matches("a?"));
		s("48946511815616".matches("\\d{3,100}"));//X{n,m} ��ʾ���� n �Σ����ǲ����� m �� 
		s("192.168.10.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		s("192".matches("[0-2][0-9][0-9]"));
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
true
true
false
true
true
true
false
true
*/