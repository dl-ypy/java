/*
	ʱ�䣺2016��10��8��08:45:18
	Ŀ�ģ������������ֽ��������ļ����ٶȿ�
*/
import java.io.*;

public class Liu2_Buffer1{
	public static void main(String[] args) throws Exception{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("G:\\java\\����\\Liu2_Buffer1.java"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("G:\\java\\����\\Buffer.txt"));
		byte[] buf = new byte[1024];//������
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