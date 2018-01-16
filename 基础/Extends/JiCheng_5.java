/**
 * date:2017年4月20日16:03:29 
 * target:继承中构造方法执行顺序的一些问题。
 * @author ypy
 * conclusion:
 *     执行顺序：
 *     main->new RoundGlyph的对象（此时，在采取其他任何操作之前，为对象分配的存储空间初始化成二进制零，radius=0）
 *     ->父类的构造方法->子类重写的draw方法(此时的radius还为0)->对radius赋值1->子类的构造方法
 */
abstract class Glyph {
	abstract void draw();
	Glyph() {
		System.out.println("Glyph() before draw()");
		draw();
		System.out.println("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;//如果这个属性是static的，那么输出结果就为RoundGlyph.draw(), radius = 1
						   //因为在类加载的时候就为其赋值为1了

	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}

	@Override
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
}

public class JiCheng_5 {
	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}
/*
 * *************** jdk1.8运行结果*************** 
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
 */
