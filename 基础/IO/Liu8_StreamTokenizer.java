import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * date:2017年5月20日09:27:46
 * target:通过StreamTokenizer读取文件中单词个数。
 * @author ypy 
 */
class Counter {
	private int i = 1;
	int read() {
		return i;
	}
	void increment() {
		i++;
	}
}
public class Liu8_StreamTokenizer {
	private FileReader file;
	private StreamTokenizer st;
	private Hashtable counts = new Hashtable<>();
	
	Liu8_StreamTokenizer(String filename) {
		try {
			file = new FileReader(filename);
			st = new StreamTokenizer(file);
			//分割单词的方式
			st.ordinaryChar('.');
			st.ordinaryChar('-');
			st.ordinaryChar(' ');
		} catch (FileNotFoundException e) {
			System.out.println("打开文件:" + file + "失败！");
		}
	}
	
	//关闭文件
	void cleanup() {
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("关闭文件失败！");
		}
	}
	
	void countWords() {
		try {
			//读取文件中的记号，直到读取到文件流末尾
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				String s;
				//判断当前记号是文件末尾、数字、文字、其他
				switch (st.ttype) {
				case StreamTokenizer.TT_EOL:
					s = new String("EOL");
					break;
				case StreamTokenizer.TT_NUMBER:
					s = Double.toString(st.nval);
					break;
				case StreamTokenizer.TT_WORD:
					s = st.sval;
					break;
				default:
					s = String.valueOf((char)st.ttype);
				}
				//判断此记号是否为此哈希表中的键
				if (counts.containsKey(s)) {
					//如果是，将此记号的i++
					((Counter)counts.get(s)).increment();
				} else {
					//否则将此记号放入哈希表中，此时i的值为1
					counts.put(s, new Counter());
				}
			}
		} catch (IOException e) {
			System.out.println("st.nextToken()失败！");
		}
	}
	
	//得到哈希表中key的枚举
	Enumeration Keys() {
		return counts.keys();
	}
	
	//返回指定键返回的值
	Counter getCounter(String s) {
		return (Counter)counts.get(s);
	}
	
    public static void main(String[] args) throws Exception {
    	Liu8_StreamTokenizer t = new Liu8_StreamTokenizer("test1.txt");
    	t.countWords();
    	Enumeration keys = t.Keys();
    	while (keys.hasMoreElements()) {
    		String key = (String)keys.nextElement();
    		System.out.println(key + "  的个数:" + t.getCounter(key).read());
    	}
    	t.cleanup();
    }
}
/*
 *************** jdk1.8运行结果*************** 
-  的个数:2
+  的个数:3
4.0  的个数:3
www  的个数:1
海阔天空  的个数:2
呃呃呃  的个数:1
是否  的个数:1
   的个数:3
.  的个数:3
 */
