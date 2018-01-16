/**
 * date:2017年4月17日17:11:59
 * target:final修饰方法。
 * @author ypy
 * conclusion:
 *     一：为什么用final修饰方法？
 *           1.为方法“上锁”，防止任何继承类改变它的本来含义。
 *           2.将一个方法设成 final后，编译器就可以把对那个方法的所有调用都置入“嵌入”调用里。
 *             只要编译器发现一个final 方法调用，就会（根据它自己的判断）忽略为执行方法调用机制而采取的常规代码插入方法（将自变量压入堆栈；跳至方法代码并执行它；跳回来；清除堆栈自变量；最后对返回值进行处理）。
 *             相反，它会用方法主体内实际代码的一个副本来替换方法调用。这样做可避免方法调用时的系统开销。
 *     二：什么时候用final修饰方法？
 *           通常，只有在方法的代码量非常少，或者想明确禁止方法被覆盖的时候，才应考虑将一个方法设为final。
 */
public class Final_2{
	public static void main(String[] args) {

	}
}

class FinalMethod {
//	final FinalMethod() {   构造方法不能用final修饰，因为final修饰的方法不能被子类重写，隐含可以被继承，但构造方法是不能被子类继承的。
//		
//	}
	final void m() {
		
	}
}

class A extends FinalMethod {
//	void m() {    final修饰的方法不能被重写
//		
//	}
}
/*
 ***************jdk1.8运行结果*************** 
 */
