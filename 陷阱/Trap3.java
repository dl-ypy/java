package javaTest;

/**
 * data:2018年3月22日20点48分
 * @author joker
 * Java常见陷阱之：new StringBuffer() 括号中用''
 */
public class Trap3{
	public static void main(String[] args){
		StringBuffer s = new StringBuffer('a');
		s.append("b");
		System.out.println(s);  //只输出b,因为new的时候用的时单引号，char会自动转换为int类型，表示为StringBuffer的容量
	}
	
}

/**
 * JDK1.8运行结果
 * b
*/