/**
 * date:2017��6��22��15:48:34
 * targer:�ɱ��
 * @author ypy
 */
public class ChangeParameter {
	public static void main(String[] args){
		System.out.println(add(1,2,3,4,5,6,7,8,9,10));
	}
	
	//�൱��һ��n������
	//�ɱ�α���λ�ڲ���������
	public static int add(int...n)	{
		int sum = 0;
		for (int i=0; i<n.length; i++) {
			sum += n[i];
		}
		return sum;
	}
}
/*
****************JDK1.8���н��***************
*55
 */
