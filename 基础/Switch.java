/**
 * date:2017��6��1��10:03:08
 * target:switch�����жϵ��������͡�
 * @author ypy
 * conclusion:
 *     ���ݸ�switch��case��Ӧ���Ǹ��������ʽ����int������byte,short,char�Լ����װ����ԡ�
 *     �°汾֧��Stringԭ���ڱ�������λὫ�ַ�������ת��Ϊ���������ͼ��ݵĸ�ʽ��
 *     case�־��ֵ�ǲ����ظ��ģ����ַ��������С��͡�\u7537��Ҳ�����ԣ��Ҵ�ֵ�����ǳ���������Ǳ���Ҫ��final��
 *     Ҳ֧��enumö�����͡�
 */
public class Switch {
	public static void main(String[] args) {
		float f = 1.3f; //no
		double d = 2.0;  //no
		int i = 5;   //yes
		boolean b = false;   //no
		byte by = 3;    //yes
		short s = 2;    //yes
		long l = 5;     //no
		char c = 'u';   //yes
		String str = "yy";   //java7���Ժ�汾yes
		
		switch (str) {
		case "yy":
			System.out.println("yes!");
			break;
		default:
			System.out.println("no!");
		}
	}
}
/*
 *************** jdk1.8���н��***************
yes!
 */
