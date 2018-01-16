/*
时间：2016年11月7日11:20:22
目的：matches_find_lookingAt
*/
import java.util.regex.*;

public class RegularExpression_06{
	public static void main(String[] args){
		Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-23232-596-5";
		Matcher m = p.matcher(s);//将s匹配到P所定义的表达式
		s(m.matches());//这是匹配整个字符串，所以为false
		m.reset();//将m重置，使其不影响下面的判断 因为matches与find会相互影响
		
		s(m.find());//匹配子串123  true
		s(m.start()+"-"+m.end());//显示子串的开始位置和结束位置的后一位   前提是子串必须匹配
		s(m.find());//匹配子串23232 true
		s(m.start()+"-"+m.end());
		s(m.find());//匹配子串596 true
		s(m.start()+"-"+m.end());
		s(m.find());//匹配子串5 false
		
		s(m.lookingAt());//lookingAt每次都从头开始找，都是123
		s(m.lookingAt());
		s(m.lookingAt());
		s(m.lookingAt());
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
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