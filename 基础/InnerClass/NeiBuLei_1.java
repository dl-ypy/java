import Parcel.M;

/**
 * date:2017��4��18��17:22:34 
 * target:�ڲ�����⡣
 * @author ypy
 * knowledge:
 *     �ڲ������ɵ�.class�ļ������ƣ��ⲿ��$�ڲ���.class
 * conclusion:
 *     Ϊʲôʹ���ڲ��ࣿ
 *         1.�ڲ�������ö��ʵ����ÿ��ʵ�������Լ���״̬��Ϣ��������������Χ�������Ϣ�໥������
		   2.�ڵ�����Χ���У������ö���ڲ����Բ�ͬ�ķ�ʽʵ��ͬһ���ӿڣ����߼̳�ͬһ���ࡣ
		   3.�����ڲ�������ʱ�̲�����������Χ�����Ĵ�����
		   4.�ڲ��ಢû�������Ի�ġ�is-a����ϵ��������һ��������ʵ�塣
		   5.�ڲ����ṩ�˸��õķ�װ�����˸���Χ�࣬�����඼���ܷ���
		   6.���ƿ�ܡ�
 */
class Parcel {
	private int i = 100;
	private static int m = 200;
	//�Ǿ�̬�ڲ���
	//�Ǿ�̬���в����о�̬��Ա�������Է����ⲿ��ľ�̬��Ա
	protected class Destination {//protected������ͬһ���µ���������з��ʣ�private��ֻ������ڲ�����ⲿ����з���
		private String label;
		//public static int n = 5;
		Destination(String label) {
			this.label = label;
			//�Ǿ�̬�ڲ���������һ���ⲿ���ָ��this,��this��ʾ���ⲿ������ã�����ֱ�ӷ����ⲿ��ĳ�Ա������˽�С�
			System.out.println("Destination construction!" + i);
		}

		String readLabel() {
			return label;
		}
	}
	
	//��̬�ڲ���
	//�����ڴ���Ĳ���
	//��̬�ڲ��಻�ܷ����ⲿ��ķǾ�̬��Ա����Ϊ��̬�ڲ������ⲿ�����ʱ�ͻ��ʼ��
	public static class M {
		private static int n = 200;
		public void print() {
			System.out.println(n+m);//��̬�ڲ��಻�ٰ����ⲿ���thisָ�룬�������ⲿ��װ��ʱ��ʼ��,ֻ����ʹ���ⲿ��ľ�̬����
		}
		
		public static void sPrint() {
			System.out.println(n+m);
		}
	}

	//��ʼ���ڲ���Destination
	public Destination instance(String s) {
		return new Destination(s);
	}

	//�����ڲ���ʼ���ڲ���
	public void ship(String dest) {
		Destination d = instance(dest);
		System.out.println("Ŀ����⣺" + d.readLabel());
	}
}

public class NeiBuLei_1{
	public static void main(String[] args) {
		Parcel p = new Parcel();
		p.ship("Tanzania");
		//�����ⲿ��ʼ���ڲ���
		//�ⲿ��Ҫ�����ڲ���ĳ�Ա�����봴������
		//�Ǿ�̬�ڲ����ʵ��һ��Ҫ�����ⲿ���ʵ���С����ڴ����ڲ���֮ǰҪ�����ⲿ�� ��Ҫ����new�ؼ�������������ڲ���Ķ���
		Parcel q = new Parcel();
		Parcel.Destination d = q.instance("Borneo");
		System.out.println("Ŀ����⣺" + d.readLabel());
		//��̬�ڲ����ʵ������Ҫ�����ⲿ���ʵ���У����ڴ�����̬���ڲ������ʱ������Ҫ���ⲿ��Ķ���
		M m = new M();
		m.print();
		Parcel.M.sPrint();
	}
}
/*
 *************** jdk1.8���н��*************** 
Destination construction!100
Ŀ����⣺Tanzania
Destination construction!100
Ŀ����⣺Borneo
400
400
 */
