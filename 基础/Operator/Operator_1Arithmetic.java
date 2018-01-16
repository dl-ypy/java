//算数运算符
public class Operator_1Arithmetic{
    public static void main(String[] args) {
        double a = 5;
	int b = 0;
	System.out.println(a/b);//输出为Infinity（无限大），只有当其中一个数为double类型时，才会输出此结果

	double aa = 35.66;
	double bb = 12.56;
	System.out.println(aa%bb);//因为计算机存储为二进制数，而小数不能完全转换为二进制，所以本来能够除尽的数，这里取余却为除不尽的数。

	byte c = 10;
	byte d = 120;
	//byte n = c + d;
	//short n = c + d;  都错误，因为编译器并不知道c+d的值是多少，会将其自动提升为int类型。
	int n = c + d;
	byte m = (byte)(c+d);//强制类型转换可以，但这里10+120大于127，会输出一个溢出值。
	System.out.println(n);
	System.out.println(m);
    }
}
/***************JDK1.8结果***************
Infinity
10.539999999999996
130
-126
*/