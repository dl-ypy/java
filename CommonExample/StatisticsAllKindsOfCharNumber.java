/**
 * date:2017年6月25日10:11:22
 * target:有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数（无其他字符）。
 * @author ypy
 */
public class StatisticsAllKindsOfCharNumber {
	public static void main(String[] args) {
		String str = "我abc哈哈ddsa5632131da看";
		int englishCount = 0;   //英文字符
		int chineseCount = 0;   //中文字符
		int digitCount = 0;   //数字
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);//返回char指定索引处的值。 指数范围为0至length()-1
			if (ch>='0' && ch<='9') {
				digitCount++;
			} else if ((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')){
				englishCount++;
			} else {
				chineseCount++;
			}
		}
		System.out.println("英文字符：" + englishCount + ",中文字符：" + chineseCount + ",数字：" + digitCount);
	}
}
/*
***************JDK1.8运行结果****************
*英文字符：9,中文字符：4,数字：7
*/
