/**
 * date:2017年7月28日10:45:39
 * target:浮点数的比较。
 * conclusion：比较浮点数尽量避免用"=="、"!="，而用">="...等代替。
 * @author ypy
 */
public class Float_3 {
	public static void main(String[] args) {
		float a = 10.2222219f;
		float b = 10.2222222f;
		float c = 0.000f;
		
		System.out.println(Math.abs(c)<=0.000001);//比较浮点数与0，0.000001表示精度，表示误差在该精度范围内相等
		System.out.println();
		
		//比较两个浮点数是否相等
		System.out.println(a==b);//因为a和b都超出精度，超出精度的会略去，对剩下的部分进行处理，
								 //而处理后剩下的部分相等，所以判断相等，与事实不符，计算金钱等 需要精确计算
		System.out.println(4.9f==4.9);//
		System.out.println(Math.abs(4.9f-4.9)<=1e-6);
	}

}
/*
***************JDK1.8运行结果****************
true

true
false
true
*/
