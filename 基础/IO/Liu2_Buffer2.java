/*
	时间：2016年10月8日12:34:42
	目的：带缓冲区的字符流复制文本文件
*/
import java.io.*;

public class Liu2_Buffer2{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("G:\\java\\基础\\Liu2_Buffer2.java"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\java\\基础\\Buffer2.txt"));
		
		String str = null;
		
		//读取一行
		while (null != (str = br.readLine())){
			bw.write(str);
			bw.newLine();//写入一个换行符，不能省略
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}