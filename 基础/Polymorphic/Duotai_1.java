/**
 * date:2017��4��18��09:07:28
 * target:��̬���⡣
 * @author ypy
 * conclusion:
 *     ʲô�Ƕ�̬��
 *         ����˵���Ǹ�������ָ���������
 *     ��̬��3������:
	   1:�̳�
	   2:��д(��д����̳еķ���)
	   3:��������ָ���������
 */
//��״��
class Shape {
	void draw() {
	}
}

//Բ����
class Circle extends Shape {
	void draw() {
		System.out.println("Circle.draw()");
	}
}

//��������
class Square extends Shape {
	void draw() {
		System.out.println("Square.draw()");
	}
}

//��������
class Triangle extends Shape {
	void draw() {
		System.out.println("Triangle.draw()");
	}
}

public class Duotai_1 {
	public static void main(String[] args) {
		Shape s1 = new Circle();  //��������
								  //���԰����������������󿴴�����Բ�ε�����״������
		s1.draw();				  //s1���֪������˭��draw������
								  //��������˺��ڰ󶨣���̬�󶨻������ڰ󶨣���java�ڲ�������ж�
	}
}
/*
 *************** jdk1.8���н��***************
 Circle.draw()
 */
