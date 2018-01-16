/**
 * date:2017年4月15日17:37:02
 * target:finalize方法在垃圾回收时的运用。
 * @author Administrator
 *
 */
 public class Finalize{
	public static void main(String[] args) {
		while (!Char.f) {
			new Char();
		}
		
		System.gc();//提醒垃圾回收器进行回收，但不一定执行，具体取决于JVM
		System.runFinalization();//强制调用已经失去引用的对象的finalize方法
								 //调用该方法说明 Java 虚拟机做了一些努力运行已被丢弃对象的 finalize 方法，
								 //但是这些对象的 finalize 方法至今尚未运行。当控制权从方法调用中返回时，
								 //Java 虚拟机已经尽最大努力去完成所有未执行的终止方法。
		System.out.println("一共创建的对象： " + Char.created + 
				",一共回收的对象：" + Char.finalized);
		System.out.println("bye");
	}
}

class Char {
	static boolean gcrun = false;//指出垃圾收集器是否已经开始运行
	static boolean f = false;//用于停止对象的生成
	static int created = 0;//创建的对象数量
	static int finalized = 0;//垃圾收集器已进行完收尾工作的对象数量
	int i;
	Char() {
		i = ++created;
		if (created == 50) {
			System.out.println("创建第50个对象！");
		}
	}
	
	//垃圾收集器删除对象之前调用，一旦执行此方法，就表示该对象已无用,只有当垃圾回收器释放该对象的内存时才调用
	//但调用完此方法也不一定被回收
	//会有多个对象（即将被垃圾收集器回收的对象）调用
	//各对象调用的此方法的顺序也不确定
	@Override
	protected void finalize() {
		if (!gcrun) {
			System.out.println("开始调用finalize方法，在创建了第" + i + "个对象后，垃圾回收器开始运行！");
			gcrun = true;
		}
		
		if (i == 50) {
			System.out.println("正在对第50个对象进行收尾工作，设置停止标签，停止对象的创建！");
			f = true;
		}
		
		finalized++;
		if (finalized >= created)
			System.out.println("所有" + finalized + "个对象已被回收！");
	}
}
/*
 ***************jdk1.8运行结果*************** 
 创建第50个对象！
 开始调用finalize方法，在创建了第229117个对象后，垃圾回收器开始运行！
 正在对第50个对象进行收尾工作，设置停止标签，停止对象的创建！
 一共创建的对象： 2469966,一共回收的对象：2468775
 bye 
 */
