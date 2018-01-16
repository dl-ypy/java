/*
ʱ�䣺2016��11��7��11:20:22
Ŀ�ģ�matches_find_lookingAt
*/
import java.util.regex.*;

public class RegularExpression_06{
	public static void main(String[] args){
		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-23232-596-5";
		Matcher m = p.matcher(s);//��sƥ�䵽P������ı��ʽ
		s(m.matches());//����ƥ�������ַ���������Ϊfalse
		m.reset();//��m���ã�ʹ�䲻Ӱ��������ж� ��Ϊmatches��find���໥Ӱ��
		
		s(m.find());//ƥ���Ӵ�123  true
		s(m.start()+"-"+m.end());//��ʾ�Ӵ��Ŀ�ʼλ�úͽ���λ�õĺ�һλ   ǰ�����Ӵ�����ƥ��
		s(m.find());//ƥ���Ӵ�23232 true
		s(m.start()+"-"+m.end());
		s(m.find());//ƥ���Ӵ�596 true
		s(m.start()+"-"+m.end());
		s(m.find());//ƥ���Ӵ�5 false
		
		s(m.lookingAt());//lookingAtÿ�ζ���ͷ��ʼ�ң�����123
		s(m.lookingAt());
		s(m.lookingAt());
		s(m.lookingAt());
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
false
true
0-3
true
4-9
true
10-13
false
true
true
true
true
*/