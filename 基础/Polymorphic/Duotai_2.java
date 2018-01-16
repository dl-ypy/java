/**
 * date:2017��4��18��09:52:59
 * target:��̬�Ŀ������ԡ�
 * @author ypy
 * conclusion:
 *     ��̬�ĺô���
 *         1.���滻�ԣ�substitutability������̬���Ѵ��ڴ�����п��滻�ԡ����磬��̬��ԲCircle�๤�����������κ�Բ�μ����壬��Բ����Ҳͬ��������
		   2.�������ԣ�extensibility������̬�Դ�����п������ԡ������µ����಻Ӱ���Ѵ�����Ķ�̬�ԡ��̳��ԣ��Լ��������Ե����кͲ�����ʵ�����¼���������׻�ö�̬���ܡ����磬��ʵ����Բ׶����Բ׶�Լ�������Ķ�̬�����ϣ�����������������Ķ�̬�ԡ�
           3.�ӿ��ԣ�interface-ability������̬�ǳ���ͨ������ǩ�����������ṩ��һ����ͬ�ӿڣ������������ƻ��߸�������ʵ�ֵġ�
           4.����ԣ�flexibility��������Ӧ�����������������Ĳ����������ʹ��Ч�ʡ�
           5.���ԣ�simplicity������̬�򻯶�Ӧ������Ĵ����д���޸Ĺ��̣������ڴ���������������Ͳ���ʱ������ص���Ϊͻ������Ҫ��
 */
//��״��
class Shape {
	void draw() {
	}
	
	//�����ӵķ���
	void delete() {
		
	}
}

//Բ����
class Circle extends Shape {
	void draw() {
		System.out.println("Circle.draw()");
	}
	//�����ӵķ���
	void delete() {
		System.out.println("Circle.delete()");
	}
}

//��������
class Square extends Shape {
	void draw() {
		System.out.println("Square.draw()");
	}
	
	//�����ӵķ���
	void delete() {
		System.out.println("Square.delete()");
	}
}

//��������
class Triangle extends Shape {
	void draw() {
		System.out.println("Triangle.draw()");
	}
	//�����ӵķ���
	void delete() {
		System.out.println("Triangle.delete()");
	}
}

public class Duotai_2 {
	static void draw(Shape s) {//�����ķ�����ԭ�еķ�������Ӱ�죬��Ȼ����ԭ���Ķ�̬�ԡ��̳���
		s.draw();
	}
	//�����ķ���
	static void delete(Shape s) {
		s.delete();
	}
	public static void main(String[] args) {
		draw(new Circle());	
		delete(new Circle());
	}
}
/*
 *************** jdk1.8���н��***************
 Circle.draw()
 Circle.delete()
 */
