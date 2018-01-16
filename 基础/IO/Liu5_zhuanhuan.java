/*
时间：2016年10月12日10:48:10
目的：转换流的使用
*/
import java.io.*;

public class Liu5_zhuanhuan{
	public static void main(String[] args) throws Exception{
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//System.in为从键盘输入，因为System.in属于InputStream,而这里需要Reader类型的，所以要用InputStreamReader转换
		str = br.readLine();
		System.out.println("str = " + str);
		br.close();
	}
}
/*
***************程序运行***************
G:\java\基础>javac Liu5_zhuanhuan.java

G:\java\基础>java Liu5_zhuanhuan
1566
str = 1566

G:\java\基础>
*/