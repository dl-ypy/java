package javaTest;

/**
 * data:2018年3月28日20点00分
 * @author joker
 * Java常见陷阱之：finally一定会执行？
 */
public class Trap5{
	public static void main(String[] args){
		try {
			System.out.println("111");
			System.exit(0);   //程序退出后就不会执行fianlly
		} finally {
			System.out.println("222");
		}
	}
}

/**
 * JDK1.8运行结果
 * 111
*/