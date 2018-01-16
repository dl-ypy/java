import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * date:2017��5��22��09:54:29
 * target:ZIPѹ������ļ���
 * @author ypy 
 */
public class Liu10_ZIP {
    public static void main(String[] args) {
    	try {
	    	FileOutputStream f = new FileOutputStream("test3.zip");
	    	CheckedOutputStream cops = new CheckedOutputStream(f, new Adler32());
	    	ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(cops));
	    	
	    	//����ѹ��
	    	//�ļ�������
	    	String[] s = {"test3_1.txt","test3_2.txt","test3_3.txt"};
	    	for (int i=0; i<s.length; i++) {
	    		System.out.println("д���ļ�" + s[i]);
	    		BufferedReader in = new BufferedReader(new FileReader(s[i]));
	    		out.putNextEntry(new ZipEntry(s[i]));//д���ļ�����
	    		int c;
	    		//д������
	    		while ((c=in.read()) != -1) {
	    			out.write(c);
	    		}
	    		in.close();
	    	}
	    	out.close();
	    	
	    	System.out.println("checksum:" + cops.getChecksum().getValue());
	    	System.out.println("��ȡ�ļ���");
	    	FileInputStream fi = new FileInputStream("test3.zip");
	    	CheckedInputStream cips = new CheckedInputStream(fi, new Adler32());
	    	ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(cips));
	    	ZipEntry ze;
	    	System.out.println("checksum:" + cips.getChecksum().getValue());
	    	while ((ze=in2.getNextEntry()) != null) {
	    		System.out.println("���ڶ�ȡ�ļ�" + ze);
	    		int x;
	    		while ((x=in2.read()) != -1) {
	    			System.out.write(x);//����ַ�����println����ֽ���
	    		}
	    		System.out.println();
	    	}
	    	in2.close();
	    	
	    	ZipFile zf = new ZipFile("test3.zip");
	    	Enumeration e = zf.entries();
	    	while (e.hasMoreElements()) {
	    		ZipEntry ze2 = (ZipEntry)e.nextElement();
	    		System.out.println("�ļ���" + ze2);
	    	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
/*
 *************** jdk1.8���н��*************** 
д���ļ�test3_1.txt
д���ļ�test3_2.txt
д���ļ�test3_3.txt
checksum:826685909
��ȡ�ļ���
checksum:1
���ڶ�ȡ�ļ�test3_1.txt
test3_1
���ڶ�ȡ�ļ�test3_2.txt
test3_2
���ڶ�ȡ�ļ�test3_3.txt
test3_3
�ļ���test3_1.txt
�ļ���test3_2.txt
�ļ���test3_3.txt
 */
