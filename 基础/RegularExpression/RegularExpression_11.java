/*
ʱ�䣺2016��11��10��08:44:19
Ŀ�ģ�Reluctant  Possessive
*/
import java.util.regex.*;

public class RegularExpression_11{
	public static void main(String[] args){
		Pattern p1 = Pattern.compile(".{3,10}[0-9]");//greedy  ֱ�Ӷ�ȡ������10����Ȼ�������£���ƥ��
		Pattern p2 = Pattern.compile(".{3,10}?[0-9]");//reluctant   �����ٵ�������ȡ��ֱ��ƥ��
		Pattern p3 = Pattern.compile(".{3,10}+[0-9]");//possessive   ֱ�Ӷ�ȡ������10�������������£����Ա����ʽƥ�䲻��  ��׷��Ч�ʣ�
		String s = "aaaa5bbbb5";
		Matcher m1 = p1.matcher(s);
		Matcher m2 = p2.matcher(s);
		Matcher m3 = p3.matcher(s);
		
		if (m1.find()){
			s(m1.start() + "-" + m1.end());
		}else{
			s("�޷�ƥ�䣡");
		}
		
		if (m2.find()){
			s(m2.start() + "-" + m2.end());
		}else{
			s("�޷�ƥ�䣡");
		}
		
		if (m3.find()){
			s(m3.start() + "-" + m3.end());
		}else{
			s("�޷�ƥ�䣡");
		}
	}
	
	private static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
0-10
0-5
�޷�ƥ�䣡
*/