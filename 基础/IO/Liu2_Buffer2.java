/*
	ʱ�䣺2016��10��8��12:34:42
	Ŀ�ģ������������ַ��������ı��ļ�
*/
import java.io.*;

public class Liu2_Buffer2{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("G:\\java\\����\\Liu2_Buffer2.java"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\java\\����\\Buffer2.txt"));
		
		String str = null;
		
		//��ȡһ��
		while (null != (str = br.readLine())){
			bw.write(str);
			bw.newLine();//д��һ�����з�������ʡ��
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}