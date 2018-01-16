import java.math.BigDecimal;
/**
 * date:2017年7月28日10:07:34
 * target:浮点数的显示值，存储值，精确计算。
 * @author ypy
 */
public class Float_2{
	public static void main(String[] args) {
		BigDecimal a1 = new BigDecimal(0.4);
		BigDecimal a2 = new BigDecimal(0.2);
		System.out.println(a1);//得到存储值
		System.out.println(a2);
		System.out.println();
		
		System.out.println(0.4+0.2);//计算时用存储值计算，计算完的值在对应的区间会有一个存储值，显示的是其显示值
		System.out.println(0.4-0.2);
		System.out.println(0.4*0.2);
		System.out.println(0.4/0.2);
		System.out.println();
		
		//精确计算浮点数  但效率低
		BigDecimal b1 = new BigDecimal("0.4");
		BigDecimal b2 = new BigDecimal("0.2");
		System.out.println(b1.add(b2));
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
		System.out.println(b1.divide(b2));
	}

}
/*
***************JDK1.8运行结果****************
0.40000000000000002220446049250313080847263336181640625
0.200000000000000011102230246251565404236316680908203125

0.6000000000000001
0.2
0.08000000000000002
2.0

0.6
0.2
0.08
2
*/
