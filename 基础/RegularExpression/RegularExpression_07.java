/*
ʱ�䣺2016��11��8��08:52:23
Ŀ�ģ��滻�ַ���
*/
import java.util.regex.*;

public class RegularExpression_07{
	public static void main(String[] args){
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);//�ڶ��������Ǻ��Դ�Сд
		Matcher m = p.matcher("java JAva jAva JAVA jaVa bgfgf");
		while (m.find()){
			s(m.group());//�ҵ����Դ�Сд��java
		}
		
		s(m.replaceAll("JAVA"));//ȫ���滻Ϊ��д
		
		//ż��ΪСд ����Ϊ��д
		m.reset();
		java.lang.StringBuffer buf = new java.lang.StringBuffer();
		int i = 0;
		while (m.find()){
			i++;
			if (i%2 == 0){
				m.appendReplacement(buf, "java");//���滻����ַ����洢��buf��
			}else{
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);//��û��ƥ�䵽��Ҳ��ӵ�buf��
		s(buf);
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8���н��***************
java
JAva
jAva
JAVA
jaVa
JAVA JAVA JAVA JAVA JAVA bgfgf
JAVA java JAVA java JAVA bgfgf
*/
