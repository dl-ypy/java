/**
 * date:2017年7月5日16:24:15
 * target:将阿拉伯数字转换为汉字数字。
 * @author ypy
 */
public class DigitTransitionRMB {
	public static final char[] data = new char[]{
			'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
	};
	
	public static final char[] units = new char[]{
			'元','拾','佰','仟','万','拾','佰','仟','亿'	
	};
	
	public static void main(String[] args) {
		System.out.println(transition(87772109));
	}
	
	/**
	 * 将阿拉伯数字转换为汉字数字
	 * @param money
	 * @return
	 */
	public static String transition(int money) {
		StringBuffer sb = new StringBuffer();
		int unit = 0;
		while (money != 0) {
			//添加时从小到大添，先添单位，再添数字
			sb.insert(0, units[unit++]);
			int number = money%10;
			sb.insert(0, data[number]);
			money /= 10;
		}
		//删除0后面的单位
		for (int i=0; i<sb.length(); i++) {
			if (sb.charAt(i) == '零') {
				sb.deleteCharAt(i+1);
			}
		}
		return sb.toString();
	}
}

/*
***************JDK1.8运行结果****************
捌仟柒佰柒拾柒万贰仟壹佰零玖元
*/
