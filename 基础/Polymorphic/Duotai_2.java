/**
 * date:2017年4月18日09:52:59
 * target:多态的可扩充性。
 * @author ypy
 * conclusion:
 *     多态的好处：
 *         1.可替换性（substitutability）。多态对已存在代码具有可替换性。例如，多态对圆Circle类工作，对其他任何圆形几何体，如圆环，也同样工作。
		   2.可扩充性（extensibility）。多态对代码具有可扩充性。增加新的子类不影响已存在类的多态性、继承性，以及其他特性的运行和操作。实际上新加子类更容易获得多态功能。例如，在实现了圆锥、半圆锥以及半球体的多态基础上，很容易增添球体类的多态性。
           3.接口性（interface-ability）。多态是超类通过方法签名，向子类提供了一个共同接口，由子类来完善或者覆盖它而实现的。
           4.灵活性（flexibility）。它在应用中体现了灵活多样的操作，提高了使用效率。
           5.简化性（simplicity）。多态简化对应用软件的代码编写和修改过程，尤其在处理大量对象的运算和操作时，这个特点尤为突出和重要。
 */
//形状类
class Shape {
	void draw() {
	}
	
	//新增加的方法
	void delete() {
		
	}
}

//圆形类
class Circle extends Shape {
	void draw() {
		System.out.println("Circle.draw()");
	}
	//新增加的方法
	void delete() {
		System.out.println("Circle.delete()");
	}
}

//正方形类
class Square extends Shape {
	void draw() {
		System.out.println("Square.draw()");
	}
	
	//新增加的方法
	void delete() {
		System.out.println("Square.delete()");
	}
}

//三角形类
class Triangle extends Shape {
	void draw() {
		System.out.println("Triangle.draw()");
	}
	//新增加的方法
	void delete() {
		System.out.println("Triangle.delete()");
	}
}

public class Duotai_2 {
	static void draw(Shape s) {//新增的方法与原有的方法互不影响，依然保持原来的多态性、继承性
		s.draw();
	}
	//新增的方法
	static void delete(Shape s) {
		s.delete();
	}
	public static void main(String[] args) {
		draw(new Circle());	
		delete(new Circle());
	}
}
/*
 *************** jdk1.8运行结果***************
 Circle.draw()
 Circle.delete()
 */
