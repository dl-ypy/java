/**
 * date:2017��6��25��10:11:22
 * target:��һ���ַ��������а��������ַ���Ӣ���ַ��������ַ�����ͳ�ƺʹ�ӡ�������ַ��ĸ������������ַ�����
 * @author ypy
 */
public class StatisticsAllKindsOfCharNumber {
	public static void main(String[] args) {
		String str = "��abc����ddsa5632131da��";
		int englishCount = 0;   //Ӣ���ַ�
		int chineseCount = 0;   //�����ַ�
		int digitCount = 0;   //����
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);//����charָ����������ֵ�� ָ����ΧΪ0��length()-1
			if (ch>='0' && ch<='9') {
				digitCount++;
			} else if ((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')){
				englishCount++;
			} else {
				chineseCount++;
			}
		}
		System.out.println("Ӣ���ַ���" + englishCount + ",�����ַ���" + chineseCount + ",���֣�" + digitCount);
	}
}
/*
***************JDK1.8���н��****************
*Ӣ���ַ���9,�����ַ���4,���֣�7
*/
