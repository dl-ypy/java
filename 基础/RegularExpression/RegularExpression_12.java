/*
时间：2016年11月10日09:18:02
目的：补充
*/
import java.util.regex.*;

public class RegularExpression_12{
	public static void main(String[] args){
		Pattern p1 = Pattern.compile(".{3}(?<=a)");//()中第一个是?,表示不是一个组，<表示向后查找，没有<表示向前查找
																							//向前查找放在前面，匹配到a开始，匹配内容包括a（向前查找放在前面就包括该内容）,然后再进行后面的匹配， 放在后面，先匹配前面的内容，然后到a为止，不包括a
																							//向后查找相反
		String s1 = "44aa55c";
		Matcher m1 = p1.matcher(s1);
		while (m1.find()){
			s(m1.group());
		}
		
		Pattern p2 = Pattern.compile("(\\d(\\d))\\2");//前面分成两组，后面的\\2表示匹配的要与第二组相匹配
		String s2 = "122";
		Matcher m2 = p2.matcher(s2);
		s(m2.matches());
		
		//Pattern p3 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		s("JAVA".matches("(?i)(java)"));//相当于上一行的简写，不区分大小写
	}
	
	private static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
44a
true
true
*/