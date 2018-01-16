import java.util.Arrays;

/**
 * ��дһ����ȡ�ַ����ĺ���������Ϊһ���ַ������� ����дһ����ȡ�ַ����ĺ�����
 * ����Ϊһ���ַ������� ���������Ϊ���ֽڽ�ȡ���ַ�������Ҫ��֤���ֲ�����ȡ�����
 * �硰�� �� ABC�� ��4 ��Ӧ�ý�ȡ���� AB�������롰�� ABC�� DEF�� ��6 ��Ӧ��������� ABC�� �������ǡ��� ABC+���İ�� ���� 
 * @author ypy
 */
public class CutoffStrByBytes {
	public static void main(String[] args) {
		String str = "��abc����";
		int num = trimGBK(str.getBytes(), 6);
		System.out.println(str.substring(0, num));//��������Ϊ0-num����������num���������ַ���
	}
	
	/**
	 * ���ֽ�����ȡ�ַ���
	 * @param buf Ҫ��ȡ�ַ�����byte����
	 * @param n Ҫ��ȡ���ֽ���
	 * @return Ҫ��ȡ���ڼ����ַ�
	 */
	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		for(int i=0; i<n; i++) {
			//GBK���뺺�ֵ������ֽڶ�Ϊ����
			//�ж��Ƿ�Ϊ���ֵĵ�һ���ֽ�
			//�ж����������ֽ�Ϊ������ǰһ���жϽ�"�Ƿ�Ϊ�������ֽ�"��Ϊ��˵����һ�β������ֽڣ�����ο϶������ֽ�
			if (buf[i]<0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;//�ж�Ϊ�������ֽں󣬽�"�Ƿ�Ϊ�������ֽ�"�ı�־��Ϊ��
			} else {//�����Ǻ���β�ֽڻ��߲��Ǻ��֣�����������++������ʾһ���ַ�
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
	
}
/*
***************JDK1.8���н��****************
*��abc
*/