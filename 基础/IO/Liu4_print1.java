/*
ʱ�䣺2016��10��12��10:35:12
Ŀ�ģ�DataOutputStream��PrintStream������
*/
import java.io.*;

public class Liu4_print1{
	public static void main(String[] args)throws Exception{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeLong(123456);//���ļ�����ʾ���Ƕ�������
		dos.close();
		
		PrintStream ps = new PrintStream(new FileOutputStream("print.txt"));
		ps.println(123456);//���ļ�����������ַ���
		ps.close();
	}
}