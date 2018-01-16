/*
时间：2016年11月7日10:56:33
目的：边界匹配器
*/
import java.util.regex.*;

public class RegularExpression_05{
	public static void main(String[] args){
		s("hello sir".matches("^h.*"));//^ 行的开头   后面有0个或多个任意字符
		s("hello sir".matches(".*ir$"));//$ 行的结尾 
		s("hello sir".matches("^h[a-z]{1,3}o\\b.*"));//\b 单词边界 
		s("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		s(" \n".matches("^[\\s&&[^\\n]]*\\n$"));//空白行""+换行
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
true
true
true
false
true
*/