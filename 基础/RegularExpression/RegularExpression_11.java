/*
时间：2016年11月10日08:44:19
目的：Reluctant  Possessive
*/
import java.util.regex.*;

public class RegularExpression_11{
	public static void main(String[] args){
		Pattern p1 = Pattern.compile(".{3,10}[0-9]");//greedy  直接读取到最多的10个，然后往出吐，再匹配
		Pattern p2 = Pattern.compile(".{3,10}?[0-9]");//reluctant   从最少的三个读取，直到匹配
		Pattern p3 = Pattern.compile(".{3,10}+[0-9]");//possessive   直接读取到最多的10个，但不往出吐，所以本表达式匹配不上  （追求效率）
		String s = "aaaa5bbbb5";
		Matcher m1 = p1.matcher(s);
		Matcher m2 = p2.matcher(s);
		Matcher m3 = p3.matcher(s);
		
		if (m1.find()){
			s(m1.start() + "-" + m1.end());
		}else{
			s("无法匹配！");
		}
		
		if (m2.find()){
			s(m2.start() + "-" + m2.end());
		}else{
			s("无法匹配！");
		}
		
		if (m3.find()){
			s(m3.start() + "-" + m3.end());
		}else{
			s("无法匹配！");
		}
	}
	
	private static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
0-10
0-5
无法匹配！
*/