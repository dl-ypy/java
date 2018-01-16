import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * date:2017��6��12��10:15:01
 * target:�� a.txt  �ļ��еĵ����� b.txt  �ļ��еĵ��ʽ���ϲ��� c.txt�ļ��У� 
 *        a.txt�ļ��еĵ����ûس����ָ��� b.txt��
 * @author ypy
 */
class FileManager {
	private String[] words = null;
	private int pos = 0;
	
	/**
	 * �õ��ļ��еĵ��ʲ����䰴һ����ʽ�ָ�
	 * @param filename �ļ���
	 * @param seperators �ָʽ
	 * @throws IOException
	 */
	public void splitWords(String filename, char[] seperators) throws IOException {
		File f = new File(filename);
		FileReader reader = new FileReader(f);
		char[] buf = new char[(int) f.length()]; //f.length()��ȡ�ļ��ַ���������Ϊlong����
		int len = reader.read(buf); //���ַ�����buf���������õ��ַ�����һ���س���ʾ�����ַ���
		//�õ��ļ��������ַ�
		String results = new String(buf, 0, len);//������buf��ʾҪ����Ϊ�ַ����ֽڣ�0��ʾҪ����ĵ�һ���ֽڵ�������len��ʾҪ������ֽ���
		String regex = null;
		//�жϷָʽ
		if (seperators.length > 1) {
			regex = ""+seperators[0]+"|"+seperators[1];
		} else {
			regex = ""+seperators[0];
		}
		//�õ��ָ��ĵ�������
		words = results.split(regex);
	}
	
	/**
	 * �õ���һ������
	 * @return
	 */
	public String nextWord() {
		if (pos == words.length) {
			return null;
		}
		return words[pos++];
	}
}

public class TwoFilesCombineOneFiles {
	public static void main(String[] args) {
		try {
			FileManager a = new FileManager();
			FileManager b = new FileManager();
			a.splitWords("a.txt", new char[]{'\n'});
			b.splitWords("b.txt", new char[]{'\n',' '});
			FileWriter c = new FileWriter("c.txt");
			String aWord = null;
			String bWord = null;
			
			while ((aWord=a.nextWord()) != null) {
				c.write(aWord+"\n");
				bWord = b.nextWord();
				if (bWord != null)
					c.write(bWord+"\n");
			}
			
			while ((bWord=b.nextWord()) != null) {//��֤b.txt�ļ��е����е��ʶ�д��c.txt
				c.write(bWord+"\n");
			}
			System.out.println("д��ɹ���");
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
/*
 *************** jdk1.8���н��***************
д��ɹ���
 */
