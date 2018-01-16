/*
时间：2016年9月29日16:45:50
目的：字节流和字符流的区别二
结论：字节流和字符流都能进行复制（读出并且写到另一个文件）
			但字符流只能复制文本文件，字节流能复制所有格式文件（因为单字节不存在编码解码问题）
*/
import java.io.*;

public class Liu1_zijie_zifu2{
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("G:\\java\\基础\\Liu1_zijie_zifu2.java");
		FileWriter fw = new FileWriter("G:/java/基础/zijie_zifu.txt");
		int ch;
		
		ch = fr.read();
		while (-1 != ch){
			fw.write(ch);//写到文件中
			ch = fr.read();
		}
		
		fw.flush();//先刷新再关闭，防止出错
		fr.close();
		fw.close();
	}
}