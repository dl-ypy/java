/*
时间：2016年10月12日10:35:12
目的：DataOutputStream和PrintStream的区别
*/
import java.io.*;

public class Liu4_print1{
	public static void main(String[] args)throws Exception{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeLong(123456);//在文件中显示的是二进制数
		dos.close();
		
		PrintStream ps = new PrintStream(new FileOutputStream("print.txt"));
		ps.println(123456);//在文件中输出的是字符串
		ps.close();
	}
}