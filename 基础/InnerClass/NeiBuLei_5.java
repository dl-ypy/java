/**
 * date:2017��4��19��16:40:29 
 * target:�ڲ���ļ̳С�
 * @author ypy
 */
class WithInner {
	class Inner {
		protected void m() {
			System.out.println("���̳��ˣ�");
		}
	}
}

class A extends WithInner.Inner {//�̳����ڲ���
	A(WithInner wi) {//���췽��������ôд
		wi.super();
	}
}

public class NeiBuLei_5 {

	public static void main(String[] args) {
		WithInner wi = new WithInner();
		A a = new A(wi);
		a.m();
	}
}
/*
 *************** jdk1.8���н��*************** 
���̳��ˣ�
 */
