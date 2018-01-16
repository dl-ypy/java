/**
 * date:2017��4��20��16:03:29 
 * target:�̳��й��췽��ִ��˳���һЩ���⡣
 * @author ypy
 * conclusion:
 *     ִ��˳��
 *     main->new RoundGlyph�Ķ��󣨴�ʱ���ڲ�ȡ�����κβ���֮ǰ��Ϊ�������Ĵ洢�ռ��ʼ���ɶ������㣬radius=0��
 *     ->����Ĺ��췽��->������д��draw����(��ʱ��radius��Ϊ0)->��radius��ֵ1->����Ĺ��췽��
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
	private int radius = 1;//������������static�ģ���ô��������ΪRoundGlyph.draw(), radius = 1
						   //��Ϊ������ص�ʱ���Ϊ�丳ֵΪ1��

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
 * *************** jdk1.8���н��*************** 
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
 */
