/*
ʱ�䣺2016��11��10��09:18:02
Ŀ�ģ�����
*/
import java.util.regex.*;

public class RegularExpression_12{
	public static void main(String[] args){
		Pattern p1 = Pattern.compile(".{3}(?<=a)");//()�е�һ����?,��ʾ����һ���飬<��ʾ�����ң�û��<��ʾ��ǰ����
																							//��ǰ���ҷ���ǰ�棬ƥ�䵽a��ʼ��ƥ�����ݰ���a����ǰ���ҷ���ǰ��Ͱ��������ݣ�,Ȼ���ٽ��к����ƥ�䣬 ���ں��棬��ƥ��ǰ������ݣ�Ȼ��aΪֹ��������a
																							//�������෴
		String s1 = "44aa55c";
		Matcher m1 = p1.matcher(s1);
		while (m1.find()){
			s(m1.group());
		}
		
		Pattern p2 = Pattern.compile("(\\d(\\d))\\2");//ǰ��ֳ����飬�����\\2��ʾƥ���Ҫ��ڶ�����ƥ��
		String s2 = "122";
		Matcher m2 = p2.matcher(s2);
		s(m2.matches());
		
		//Pattern p3 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		s("JAVA".matches("(?i)(java)"));//�൱����һ�еļ�д�������ִ�Сд
	}
	
	private static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
44a
true
true
*/