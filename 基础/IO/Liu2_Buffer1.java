/*
	时间：2016年10月8日08:45:18
	目的：带缓冲区的字节流处理文件的速度快
*/
import java.io.*;

public class Liu2_Buffer1{
	public static void main(String[] args) throws Exception{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("G:\\java\\基础\\Liu2_Buffer1.java"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("G:\\java\\基础\\Buffer.txt"));
		byte[] buf = new byte[1024];//缓冲区
		int len;
		
		len = bis.read(buf);
		while (-1 != len){
			bos.write(buf);
			len = bis.read(buf);
		}
		
		bos.flush();
		bos.close();
		bis.close();
	}
}