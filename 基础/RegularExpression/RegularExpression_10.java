/*
ʱ�䣺2016��11��9��11:24:05
Ŀ�ģ�ͨ��������ʽͳ�ƴ��������
*/
import java.io.*;

public class RegularExpression_10{
	static long normalLines = 0;//��������
	static long commentLines = 0;//ע�͵�����
	static long whiteLines = 0;//�հ�����
	
	public static void main(String[] args){
		File f = new File("I:\\java\\����");//���������Ŀ¼
		File[] codeFiles = f.listFiles();//����һ������·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ�
		for (File child : codeFiles){
			if (child.getName().matches(".*\\.java$")){//�ж��Ƿ���Java�ļ�
				parse(child);
			}
		}
		
		System.out.println("normalLines:" + normalLines);
		System.out.println("commentLines:" + commentLines);
		System.out.println("whiteLines:" + whiteLines);
	}
	
	private static void parse(File f){
		BufferedReader br = null;
		boolean comment = false;
		
		try{
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line=br.readLine()) != null){
				line = line.trim();//���ַ����Ƴ���ǰ����β���հ׵ĸ��������û��ǰ����β���հף��򷵻ش��ַ�����
				if (line.matches("[\\s&&[^\\n]]*$")){//�жϿհ���
					whiteLines++;
				}else if (line.startsWith("/*") && !line.endsWith("*/")){//��/**/ע�͵ķǵ��е�
					commentLines++;
					comment = true;//���ʾ��/**/ע�͵Ķ��е������Ѿ���ʼ
				}else if (line.startsWith("/*") && line.endsWith("*/")){//��/**/ע�͵ĵ��е�
					commentLines++;
				}else if (true == comment){//������/**/ע�͵Ķ��е�����
					commentLines++;
					if (line.endsWith("*/")){
						comment = false;
					}
				}else if (line.startsWith("//")){//��//ע�͵���
					commentLines++;
				}else{
					normalLines++;
				}
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		finally{
			if (br != null){
				try{
					br.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
/*
***************JDK1.8���н��***************
normalLines:2292
commentLines:1486
whiteLines:410
*/