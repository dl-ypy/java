import java.math.BigDecimal;
/**
 * date:2017��7��28��10:07:34
 * target:����������ʾֵ���洢ֵ����ȷ���㡣
 * @author ypy
 */
public class Float_2{
	public static void main(String[] args) {
		BigDecimal a1 = new BigDecimal(0.4);
		BigDecimal a2 = new BigDecimal(0.2);
		System.out.println(a1);//�õ��洢ֵ
		System.out.println(a2);
		System.out.println();
		
		System.out.println(0.4+0.2);//����ʱ�ô洢ֵ���㣬�������ֵ�ڶ�Ӧ���������һ���洢ֵ����ʾ��������ʾֵ
		System.out.println(0.4-0.2);
		System.out.println(0.4*0.2);
		System.out.println(0.4/0.2);
		System.out.println();
		
		//��ȷ���㸡����  ��Ч�ʵ�
		BigDecimal b1 = new BigDecimal("0.4");
		BigDecimal b2 = new BigDecimal("0.2");
		System.out.println(b1.add(b2));
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
		System.out.println(b1.divide(b2));
	}

}
/*
***************JDK1.8���н��****************
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
