/**
 * date:2017年4月18日09:07:28
 * target:多态初解。
 * @author ypy
 * conclusion:
 *     什么是多态？
 *         简单来说就是父类引用指向子类对象。
 *     多态有3个条件:
	   1:继承
	   2:重写(重写父类继承的方法)
	   3:父类引用指向字类对象
 */
//形状类
class Shape {
	void draw() {
	}
}

//圆形类
class Circle extends Shape {
	void draw() {
		System.out.println("Circle.draw()");
	}
}

//正方形类
class Square extends Shape {
	void draw() {
		System.out.println("Square.draw()");
	}
}

//三角形类
class Triangle extends Shape {
	void draw() {
		System.out.println("Triangle.draw()");
	}
}

public class Duotai_1 {
	public static void main(String[] args) {
		Shape s1 = new Circle();  //上溯造型
								  //可以把子类对象当做父类对象看待，把圆形当做形状看待。
		s1.draw();				  //s1如何知道调用谁的draw方法？
								  //这里进行了后期绑定（动态绑定或运行期绑定），java内部会进行判断
	}
}
/*
 *************** jdk1.8运行结果***************
 Circle.draw()
 */
