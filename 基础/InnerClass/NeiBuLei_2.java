/**
 * date:2017年4月19日08:30:17 
 * target:方法内定义内部类。
 * @author ypy
 */
interface Destination {
	String readLabel();
}

class Parcel {
	//在一个方法内部定义内部类，PDestination不可从 dest()的外部访问。
	public Destination dest(String s) {//方法的返回类型为一个接口类型
		class PDestination implements Destination {//此内部类必须实现该指定接口才能满足返回的类型是该接口类型
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
		Destination d = p.dest("Tanzania");//上溯造型
		System.out.println(d.readLabel());
	}
}
/*
 *************** jdk1.8运行结果*************** 
 *Tanzania
 */
