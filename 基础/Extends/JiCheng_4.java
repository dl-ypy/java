/**
 * date:2017年4月20日09:40:51
 * target:继承中的收尾工作。
 * @author ypy
 * conclusion:
 *     在构建finalize收尾工作时，应该首先执行子类的收尾，再是父类的收尾。
 *     这是由于子类的收尾可能调用父类中相同的方法，要求父类组件仍然处于活动状态。
 */
class DoBaseFinalization {
	public static boolean flag = true;
}
class Father {
	public Father() {
		System.out.println("father!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("father finalize!");
	}
}
class Childen extends Father {
	public Childen() {
		System.out.println("childen!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("childen finalize!");
		if (DoBaseFinalization.flag) {
			super.finalize();
		}
	}
}
public class JiCheng_4 {
	public static void main(String[] args) {
		new Childen();
		System.runFinalizersOnExit(true);//这里如果调用System.gc()方法时不会执行父类的finalize()
	}
}
/* *************** jdk1.8运行结果*************** 
father!
childen!
childen finalize!
father finalize!
 */
