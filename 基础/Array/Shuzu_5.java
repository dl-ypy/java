import java.util.Random;

/**
 * date:2017��4��15��22:58:13
 * target:һ������������ͬ���͵����顣
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
			return "A��Ķ���";
		}
	}

/*
 ***************jdk1.8���н��*************** 
50
0.1
22.2222
ypy
A��Ķ���
 */
