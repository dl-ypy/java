/*
ʱ�䣺2016��10��26��15:59:43
Ŀ�ģ���������Math.round������ȡ��Math.ceil������ȡ��Math.floor
*/
public class Round{
	public static void main(String[] args){
		System.out.println("����ȡ��");
		System.out.println(Math.ceil(11.2));
		System.out.println(Math.ceil(11.9));
		System.out.println(Math.ceil(-11.2));
		System.out.println(Math.ceil(-11.9));
		
		System.out.println("����ȡ��");
		System.out.println(Math.floor(11.9));
		System.out.println(Math.floor(11.2));
		System.out.println(Math.floor(-11.9));
		System.out.println(Math.floor(-11.2));
		
		System.out.println("��������");   //�㷨ΪMath.floor(x+0.5)
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(11.4));
		System.out.println(Math.round(-11.5));//�������
		System.out.println(Math.round(-11.6));
	}
}
/*
***************JDK1.8���н��***************
G:\java\����>java Round
����ȡ��
12.0
12.0
-11.0
-11.0
����ȡ��
11.0
11.0
-12.0
-12.0
��������
12
11
-11
-12

G:\java\����>
*/