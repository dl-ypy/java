//���������
public class Operator_1Arithmetic{
    public static void main(String[] args) {
        double a = 5;
	int b = 0;
	System.out.println(a/b);//���ΪInfinity�����޴󣩣�ֻ�е�����һ����Ϊdouble����ʱ���Ż�����˽��

	double aa = 35.66;
	double bb = 12.56;
	System.out.println(aa%bb);//��Ϊ������洢Ϊ������������С��������ȫת��Ϊ�����ƣ����Ա����ܹ���������������ȡ��ȴΪ������������

	byte c = 10;
	byte d = 120;
	//byte n = c + d;
	//short n = c + d;  ��������Ϊ����������֪��c+d��ֵ�Ƕ��٣��Ὣ���Զ�����Ϊint���͡�
	int n = c + d;
	byte m = (byte)(c+d);//ǿ������ת�����ԣ�������10+120����127�������һ�����ֵ��
	System.out.println(n);
	System.out.println(m);
    }
}
/***************JDK1.8���***************
Infinity
10.539999999999996
130
-126
*/