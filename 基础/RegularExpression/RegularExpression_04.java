/*
时间：2016年11月7日10:22:44
目的：预定义字符类
*/
import java.util.regex.*;

public class RegularExpression_04{
	public static void main(String[] args){
		s(" \n\r\t".matches("\\s{4}"));//空白字符：[ \t\n\x0B\f\r]  恰好4次
		s(" ".matches("\\S"));//非空白字符：[^\s]
		s("a_8".matches("\\w{3}"));//单词字符：[a-zA-Z_0-9]
		s("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		s("\\".matches("\\\\"));//java中\表示转义字符，所以要用\\表示\，正则表达式本身匹配\，就需要\\,要将\\用字符串形式表现出来，就需要\\\\
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
true
false
true
true
true
*/