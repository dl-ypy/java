/*
时间：2016年11月5日16:19:49
目的：了解正则表达式
*/
import java.util.regex.*;

public class RegularExpression_01{
	public static void main(String[] args){
		s("abc".matches("..."));//字符串匹配（字符匹配）
													  //一个.代表一个字符，返回为Boolean型
		s("a98j78768p".replaceAll("\\d", "-"));//将字符串中的数字转换为-
																					 // \d表示数字0-9，因为Java本身还有个转义字符，所以为\\d
																					 //参考帮助文档中Pattern的内容
		Pattern p = Pattern.compile("[a-z]{3}");//将给定的正则表达式编译到模式中
																						//匹配a-z中的任意三个字母
		Matcher m = p.matcher("dfg");//创建匹配给定输入与此模式的匹配器
		s(m.matches());
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
true
a--j-----p
true
*/