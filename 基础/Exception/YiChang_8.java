/**
 * date:2017年4月26日17:13:41 
 * target:异常的匹配。
 * @author ypy conclusion:
 *         Collections是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
 */
class Father extends Exception {
}

class Children extends Father {
}

public class YiChang_8 {
	public static void main(String[] args) {
		try {
			throw new Children();
		} catch (Children a) {          //既捕获子类异常，又捕获父类异常，并且子类异常在父类异常的前面，能够正确匹配。
										//只捕获父类异常，也能正确捕获。
										//既捕获子类异常，又捕获父类异常，并且子类异常在父类异常的后面，就会出错。
			System.out.println("Caught Father");
		} catch (Father a) {
			System.out.println("Caught Father");
		}
	}
}
/*
 * *************** jdk1.8运行结果*************** 
 * Caught Father
 */
