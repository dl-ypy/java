/**
 * date:2017��4��19��09:00:027 
 * target:������������Ƕ���ڲ��ࡣ
 * @author ypy
 */
class Parcel {
	public String internalTracking() {
		String s = null;
		if (true) {
			//������ζ�����������������ġ���������ͬ�������ж����õ����롣Ȼ�����ڶ��������Ǹ�������֮�⣬���ǲ���ʹ�õġ�
			class TrackingSlip {
				private String id;

				TrackingSlip(String s) {
					id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("100"); 
			s = ts.getSlip();
		}
		//TrackingSlip ts = new TrackingSlip("slip");  ����ֻ����if������������ʹ�ø��ڲ���
		return s;
	}
}

public class NeiBuLei_3 {
	public static void main(String[] args) {
		Parcel p = new Parcel();
		System.out.println("id=" + p.internalTracking());
	}
}
/*
 *************** jdk1.8���н��***************
id=100
 */
