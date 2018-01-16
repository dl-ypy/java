import java.util.Random;

/**
 * date:2017年4月15日22:58:13
 * target:一个方法产生不同类型的数组。
 * @author ypy
 */
 public class Test{
	 static void m(Object[] o) {
			for (int i=0; i<o.length; i++) {
				System.out.println(o[i]);
			}
		}
		public static void main(String[] args) {
			m(new Object[] {
					new Integer(50),
					new Float(0.1),
					new Double(22.2222),
					"ypy",
					new A()
			});
		}
	}

	class A {
		@Override
		public String toString() {
			return "A类的对象";
		}
	}

/*
 ***************jdk1.8运行结果*************** 
50
0.1
22.2222
ypy
A类的对象
 */
