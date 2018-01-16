/**
 * date:2017年5月26日09:03:13
 * target:String，StringBuffer，StringBuilder。
 * @author ypy
 * conclusion:
 *     String是不可变的，是字符串常量，操作少量数据时使用，尽量少用"+或+="。
 *     StringBuffer是可变的，是线程安全的。
 *     StringBuilder是可变的，是非线程安全，适用于单线程的，效率高。
 */
public class Str_StrBuf_StrBud {
	public static void main(String[] args) {
		String s = "m";  //String类中的成员用final声明，是不可变的
		System.out.println(s.hashCode());
		s = "y";  //此时重新赋值实际是重新创建了一个String对象
		System.out.println(s.hashCode());
	}
}
/*
 *************** jdk1.8运行结果***************
109
121
 */
