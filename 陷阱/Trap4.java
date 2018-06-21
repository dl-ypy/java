package javaTest;

/**
 * data:2018年3月26日20点10分
 * @author joker
 * Java常见陷阱之：j=j++问题
 */
public class Trap4{
	public static void main(String[] args){
		int j = 0;
		for (int i=0; i<100; i++) {
			j = j++;//首先将j赋给j,存入堆栈（此时堆栈中的j为0）,再进行++,进行++操作的时候，会在变量区重新分配一个空间，
					//执行++操作的是变量区中的j（变量区中的j为1），随后变量区中的j会赋给堆栈中的j，所以j为0。
					//如果换成j=++j就可以
		}
		System.out.println(j);  
	}
}

/**
 * JDK1.8运行结果
 * 0
*/