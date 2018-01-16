/*
时间：2016年11月8日09:27:49
目的：对正则表达式分组
*/
import java.util.regex.*;

public class RegularExpression_08{
	public static void main(String[] args){
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");//一对()表示一组，这里第一组表示数字，第二组表示字母
		Matcher m = p.matcher("123aa-3435bb-949zz-00");
		while (m.find()){
			s(m.group(1));//参数表示第几组
			s(m.group(2));
		}
	}
	
	public static void s(Object o){
		System.out.println(o);
	}
}
/*
***************JDK1.8运行结果***************
123
aa
3435
bb
949
zz
*/
