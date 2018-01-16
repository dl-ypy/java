/**
 * date:2017年4月17日16:45:04
 * target:final修饰数据。
 * @author ypy
 */
public class Final_1{
	public static void main(String[] args) {
		FinalData f1 = new FinalData();
		FinalData f2 = new FinalData();
		//f1.i1++;   错误，final修饰的属性表示不可改变的
		System.out.println("f1:i3=" + f1.i3 + ",i4=" + f1.i4);//f1和f2的i4值相同，体现了static的特性
		System.out.println("f2:i3=" + f2.i3 + ",i4=" + f2.i4);
		
		f1.v1.i++;
		f1.v2.i++;
		f1.v1 = new Value();
		//f1.v2 = new Value();  final修饰类对象表示该引用不能改变，但其内容是可以改变的
		
		for (int i=0; i<f1.a.length; i++) {
			f1.a[i]++;
			System.out.println(f1.a[i]);
		}
		int[] b = {1,2,3};
		//f1.a = b;       final修饰数组与修饰类对象相同，表示该引用不能改变，但其内容是可以改变的
	}
}

class Value {
	int i = 1;
}

class FinalData {
	//基本数据类型作为编译期的常数
	final int i1 = 2;
	static final int I2 = 5;   //注意对于含有固定初始化值（即编译期常数）的 fianl static基本数据类型，它们的名字根据规则要全部采用大写。
	
	//基本数据类型作为运行期的常数,所以不是final修饰的属性就一定会在编译期赋值
	final int i3 = (int) (Math.random()*20);
	static final int i4 = (int) (Math.random()*20);
	
	//非基本数据类型
	Value v1 = new Value();
	final Value v2 = new Value();
	
	//final int i5;  final修饰的属性必须赋值    可以在构造方法中赋值，因为构造方法一定会被调用，所以一定会赋值
	//				  不能在普通方法中赋值，因为普通方法不一定会被调用，所以不一定会被赋值
	//final Value v3;
	
	//数组
	final int[] a = {1,2,3,4,5};
}
/*
 ***************jdk1.8运行结果*************** 
f1:i3=10,i4=7
f2:i3=15,i4=7
2
3
4
5
6
 */
