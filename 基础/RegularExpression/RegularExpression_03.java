/*
时间：2016年11月5日17:28:26
目的：范围
*/
import java.util.regex.*;

public class RegularExpression_03{
	public static void main(String[] args){
		s("a".matches("[abc]"));//a、b 或 c
		s("a".matches("[^abc]"));//任何字符，除了 a、b 或 c
		s("A".matches("[a-zA-Z]"));//a 到 z 或 A 到 Z，两头的字母包括在内
		s("A".matches("[a-z]|[A-Z]"));//同上
		s("A".matches("[a-z[A-Z]]"));//同上
		s("R".matches("[A-Z&&[RFG]]"));//A-Z和RFG的交集
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
true
*/