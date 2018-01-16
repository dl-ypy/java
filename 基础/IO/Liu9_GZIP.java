import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * date:2017��5��22��08:27:06
 * target:GZIP��ѹ����
 * @author ypy 
 */
public class Liu9_GZIP {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new FileReader("test2.txt"));
    	BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test2.gz")));
    	System.out.println("д���ļ���");
    	int c;
    	while ((c=in.read()) != -1) {
    		out.write(c);
    	}
    	in.close();
    	out.close();
    	
    	System.out.println("��ȡ�ļ���");
    	BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test2.gz"))));
    	String s;
    	while ((s=in2.readLine()) != null) {
    		System.out.println(s);
    	}
    }
}
/*
 *************** jdk1.8���н��*************** 
д���ļ���
��ȡ�ļ���
w)z 4+./&-www.CCC w)z-4+.4+ 
 */
