/**
 * date:2017��4��19��08:30:17 
 * target:�����ڶ����ڲ��ࡣ
 * @author ypy
 */
interface Destination {
	String readLabel();
}

class Parcel {
	//��һ�������ڲ������ڲ��࣬PDestination���ɴ� dest()���ⲿ���ʡ�
	public Destination dest(String s) {//�����ķ�������Ϊһ���ӿ�����
		class PDestination implements Destination {//���ڲ������ʵ�ָ�ָ���ӿڲ������㷵�ص������Ǹýӿ�����
			private String label;

			PDestination(String label) {
				this.label = label;
			}

			public String readLabel() {
				return label;
			}
		}
		return new PDestination(s);
	}
}

public class NeiBuLei_2 {
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Destination d = p.dest("Tanzania");//��������
		System.out.println(d.readLabel());
	}
}
/*
 *************** jdk1.8���н��*************** 
 *Tanzania
 */
