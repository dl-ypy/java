/**
 * date:2017年4月19日09:00:027 
 * target:在任意作用域嵌套内部类。
 * @author ypy
 */
class Parcel {
	public String internalTracking() {
		String s = null;
		if (true) {
			//并不意味着类是有条件创建的——它会随同其他所有东西得到编译。然而，在定义它的那个作用域之外，它是不可使用的。
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
		//TrackingSlip ts = new TrackingSlip("slip");  错误，只能在if语句的作用域中使用该内部类
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
 *************** jdk1.8运行结果***************
id=100
 */
