import java.io.UnsupportedEncodingException;

/**
 * date:2017年6月1日10:55:31
 * target:以某种编码格式输出。
 * @author ypy
 */
public class String_5 {
	public static void main(String[] args) {
		String str = "海阔天空";
		try {
			String str2 = new String(str.getBytes("ISO-8859-1"));//输出ISO-8859-1编码格式
			//String str2 = new String(str.getBytes("ISO-8859-1"),"UTF-8");//将ISO-8859-1替换为UTF-8编码
			//str2 = str2.trim();  //复制一个副本，并去除开头，结尾的空白
			System.out.println(str2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
/*
 *************** jdk1.8运行结果***************
????
 */
