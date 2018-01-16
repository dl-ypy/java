import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * date:2017��5��20��09:27:46
 * target:ͨ��StreamTokenizer��ȡ�ļ��е��ʸ�����
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
			//�ָ�ʵķ�ʽ
			st.ordinaryChar('.');
			st.ordinaryChar('-');
			st.ordinaryChar(' ');
		} catch (FileNotFoundException e) {
			System.out.println("���ļ�:" + file + "ʧ�ܣ�");
		}
	}
	
	//�ر��ļ�
	void cleanup() {
		try {
			file.close();
		} catch (IOException e) {
			System.out.println("�ر��ļ�ʧ�ܣ�");
		}
	}
	
	void countWords() {
		try {
			//��ȡ�ļ��еļǺţ�ֱ����ȡ���ļ���ĩβ
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				String s;
				//�жϵ�ǰ�Ǻ����ļ�ĩβ�����֡����֡�����
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
				//�жϴ˼Ǻ��Ƿ�Ϊ�˹�ϣ���еļ�
				if (counts.containsKey(s)) {
					//����ǣ����˼Ǻŵ�i++
					((Counter)counts.get(s)).increment();
				} else {
					//���򽫴˼Ǻŷ����ϣ���У���ʱi��ֵΪ1
					counts.put(s, new Counter());
				}
			}
		} catch (IOException e) {
			System.out.println("st.nextToken()ʧ�ܣ�");
		}
	}
	
	//�õ���ϣ����key��ö��
	Enumeration Keys() {
		return counts.keys();
	}
	
	//����ָ�������ص�ֵ
	Counter getCounter(String s) {
		return (Counter)counts.get(s);
	}
	
    public static void main(String[] args) throws Exception {
    	Liu8_StreamTokenizer t = new Liu8_StreamTokenizer("test1.txt");
    	t.countWords();
    	Enumeration keys = t.Keys();
    	while (keys.hasMoreElements()) {
    		String key = (String)keys.nextElement();
    		System.out.println(key + "  �ĸ���:" + t.getCounter(key).read());
    	}
    	t.cleanup();
    }
}
/*
 *************** jdk1.8���н��*************** 
-  �ĸ���:2
+  �ĸ���:3
4.0  �ĸ���:3
www  �ĸ���:1
�������  �ĸ���:2
������  �ĸ���:1
�Ƿ�  �ĸ���:1
   �ĸ���:3
.  �ĸ���:3
 */
