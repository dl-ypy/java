/**
 * date:2017��7��28��10:45:39
 * target:�������ıȽϡ�
 * conclusion���Ƚϸ���������������"=="��"!="������">="...�ȴ��档
 * @author ypy
 */
public class Float_3 {
	public static void main(String[] args) {
		float a = 10.2222219f;
		float b = 10.2222222f;
		float c = 0.000f;
		
		System.out.println(Math.abs(c)<=0.000001);//�Ƚϸ�������0��0.000001��ʾ���ȣ���ʾ����ڸþ��ȷ�Χ�����
		System.out.println();
		
		//�Ƚ������������Ƿ����
		System.out.println(a==b);//��Ϊa��b���������ȣ��������ȵĻ���ȥ����ʣ�µĲ��ֽ��д���
								 //�������ʣ�µĲ�����ȣ������ж���ȣ�����ʵ�����������Ǯ�� ��Ҫ��ȷ����
		System.out.println(4.9f==4.9);//
		System.out.println(Math.abs(4.9f-4.9)<=1e-6);
	}

}
/*
***************JDK1.8���н��****************
true

true
false
true
*/
