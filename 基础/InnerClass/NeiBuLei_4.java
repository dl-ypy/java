/**
 * date:2017年4月19日09:30:41 
 * target:匿名内部类。
 * @author ypy
 * conclusion:
 *     使用匿名内部类的前提条件：必须继承一个父类或实现一个接口，但最多只能继承一个父类，或实现一个接口。
 *     匿名内部类的下两条规则：
 *         1）匿名内部类不能是抽象类，因为系统在创建匿名内部类的时候，会立即创建内部类的对象。因此不允许将匿名内部类定义成抽象类。
    	   2）匿名内部类不等定义构造器（构造方法），因为匿名内部类没有类名，所以无法定义构造器，但匿名内部类可以定义实例初始化块，
 */
interface Destination {
	public String readLabel();
}

class Parcel {
	public Destination dest(final String dest) {//JDK1.8以前，如果内部类要使用外部类的一个局部变量，必须用final修饰该变量
												//内部类不会因为定义在方法中就会随着方法的执行完毕而跟随者被销毁,
												//如果外部类的方法中的变量不定义final，那么当外部类方法执行完毕的时候，这个局部变量肯定也就被GC了,
												//然而内部类的某个方法还没有执行完，这个时候他所引用的外部变量已经找不到了。
												//如果定义为final，java会将这个变量复制一份作为成员变量内置于内部类中，这样的话，由于final所修饰的值始终无法改变，所以这个变量所指向的内存区域就不会变。
		//匿名内部类
		return new Destination() {
			private String label = dest;//匿名内部类没有构造方法，要初始化只能在声明属性时初始化
			private float cost;
			//假如需要采取一些类似于构建器的行动,实际上，一个实例初始化模块就是一个匿名内部类的构建器。
			//当然，它的功能是有限的；我们不能对实例初始化模块进行过载处理，所以只能拥有这些构建器的其中一个。
			{
				cost = (float) Math.random();
				System.out.println(cost);
			}

			public String readLabel() {
				return label;
			}
		};
	}
}

public class NeiBuLei_4 {
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Destination d = p.dest("TaiYuan");
		System.out.println(d.readLabel());
	}
}
/*
 *************** jdk1.8运行结果***************
0.9106549
TaiYuan
 */
