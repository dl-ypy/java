/*
ʱ�䣺2016��9��29��16:45:50
Ŀ�ģ��ֽ������ַ����������
���ۣ��ֽ������ַ������ܽ��и��ƣ���������д����һ���ļ���
			���ַ���ֻ�ܸ����ı��ļ����ֽ����ܸ������и�ʽ�ļ�����Ϊ���ֽڲ����ڱ���������⣩
*/
import java.io.*;

public class Liu1_zijie_zifu2{
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("G:\\java\\����\\Liu1_zijie_zifu2.java");
		FileWriter fw = new FileWriter("G:/java/����/zijie_zifu.txt");
		int ch;
		
		ch = fr.read();
		while (-1 != ch){
			fw.write(ch);//д���ļ���
			ch = fr.read();
		}
		
		fw.flush();//��ˢ���ٹرգ���ֹ����
		fr.close();
		fw.close();
	}
}