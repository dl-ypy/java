import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * date:2017年6月12日10:15:01
 * target:将 a.txt  文件中的单词与 b.txt  文件中的单词交替合并到 c.txt文件中， 
 *        a.txt文件中的单词用回车符分隔， b.txt。
 * @author ypy
 */
class FileManager {
	private String[] words = null;
	private int pos = 0;
	
	/**
	 * 得到文件中的单词并将其按一定格式分割
	 * @param filename 文件名
	 * @param seperators 分割方式
	 * @throws IOException
	 */
	public void splitWords(String filename, char[] seperators) throws IOException {
		File f = new File(filename);
		FileReader reader = new FileReader(f);
		char[] buf = new char[(int) f.length()]; //f.length()读取文件字符数，返回为long类型
		int len = reader.read(buf); //将字符读入buf缓冲区，得到字符数（一个回车表示两个字符）
		//得到文件的所有字符
		String results = new String(buf, 0, len);//参数：buf表示要解码为字符的字节，0表示要解码的第一个字节的索引，len表示要解码的字节数
		String regex = null;
		//判断分割方式
		if (seperators.length > 1) {
			regex = ""+seperators[0]+"|"+seperators[1];
		} else {
			regex = ""+seperators[0];
		}
		//得到分割后的单词数组
		words = results.split(regex);
	}
	
	/**
	 * 得到下一个单词
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
			
			while ((bWord=b.nextWord()) != null) {//保证b.txt文件中的所有单词都写入c.txt
				c.write(bWord+"\n");
			}
			System.out.println("写入成功！");
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
/*
 *************** jdk1.8运行结果***************
写入成功！
 */
