/*
ʱ�䣺2016��11��8��09:27:49
Ŀ�ģ���������ʽ����
*/
import java.util.regex.*;

public class RegularExpression_08{
	public static void main(String[] args){
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");//һ��()��ʾһ�飬�����һ���ʾ���֣��ڶ����ʾ��ĸ
		Matcher m = p.matcher("123aa-3435bb-949zz-00");
		while (m.find()){
			s(m.group(1));//������ʾ�ڼ���
			s(m.group(2));
		}
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
123
aa
3435
bb
949
zz
*/
