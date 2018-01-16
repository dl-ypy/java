/**
 * date:2017年6月7日11:10:21
 * target:字符串的反转与替换。
 * @author ypy
 */
public class String_6 {
	public static String str = "abc";
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();//将原有字符串反转
		System.out.println("反转后：" + sb);
		System.out.println(str.replace("b", "mm"));//替换字符
	}
}
/*
 *************** jdk1.8运行结果***************
反转后：cba
ammc
 */
