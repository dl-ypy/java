/*
时间：2016年11月5日16:52:08
目的：认识 . * +  元字符(MetaCharacters)
*/
import java.util.regex.*;

public class RegularExpression_02{
	public static void main(String[] args){
		s("a".matches("."));//任何字符（与行结束符可能匹配也可能不匹配）
		s("aa".matches("aa"));
		s("aaaa".matches("a*"));//零次或多次
		s("aaaa".matches("a+"));//一次或多次
		s("".matches("a*"));
		s("aaaa".matches("a?"));//一次或一次也没有
		s("".matches("a?"));
		s("a".matches("a?"));
		s("48946511815616".matches("\\d{3,100}"));//X{n,m} 表示至少 n 次，但是不超过 m 次 
		s("192.168.10.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		s("192".matches("[0-2][0-9][0-9]"));
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
true
true
false
true
true
true
false
true
*/