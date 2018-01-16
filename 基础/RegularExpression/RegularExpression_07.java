/*
时间：2016年11月8日08:52:23
目的：替换字符串
*/
import java.util.regex.*;

public class RegularExpression_07{
	public static void main(String[] args){
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);//第二个参数是忽略大小写
		Matcher m = p.matcher("java JAva jAva JAVA jaVa bgfgf");
		while (m.find()){
			s(m.group());//找到忽略大小写的java
		}
		
		s(m.replaceAll("JAVA"));//全部替换为大写
		
		//偶数为小写 奇数为大写
		m.reset();
		java.lang.StringBuffer buf = new java.lang.StringBuffer();
		int i = 0;
		while (m.find()){
			i++;
			if (i%2 == 0){
				m.appendReplacement(buf, "java");//将替换后的字符串存储到buf中
			}else{
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);//将没有匹配到的也添加到buf中
		s(buf);
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
java
JAva
jAva
JAVA
jaVa
JAVA JAVA JAVA JAVA JAVA bgfgf
JAVA java JAVA java JAVA bgfgf
*/
