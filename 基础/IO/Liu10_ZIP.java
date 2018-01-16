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
 * date:2017年5月22日09:54:29
 * target:ZIP压缩多个文件。
 * @author ypy 
 */
public class Liu10_ZIP {
    public static void main(String[] args) {
    	try {
	    	FileOutputStream f = new FileOutputStream("test3.zip");
	    	CheckedOutputStream cops = new CheckedOutputStream(f, new Adler32());
	    	ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(cops));
	    	
	    	//进行压缩
	    	//文件名数组
	    	String[] s = {"test3_1.txt","test3_2.txt","test3_3.txt"};
	    	for (int i=0; i<s.length; i++) {
	    		System.out.println("写入文件" + s[i]);
	    		BufferedReader in = new BufferedReader(new FileReader(s[i]));
	    		out.putNextEntry(new ZipEntry(s[i]));//写入文件数据
	    		int c;
	    		//写入内容
	    		while ((c=in.read()) != -1) {
	    			out.write(c);
	    		}
	    		in.close();
	    	}
	    	out.close();
	    	
	    	System.out.println("checksum:" + cops.getChecksum().getValue());
	    	System.out.println("读取文件！");
	    	FileInputStream fi = new FileInputStream("test3.zip");
	    	CheckedInputStream cips = new CheckedInputStream(fi, new Adler32());
	    	ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(cips));
	    	ZipEntry ze;
	    	System.out.println("checksum:" + cips.getChecksum().getValue());
	    	while ((ze=in2.getNextEntry()) != null) {
	    		System.out.println("正在读取文件" + ze);
	    		int x;
	    		while ((x=in2.read()) != -1) {
	    			System.out.write(x);//输出字符流，println输出字节流
	    		}
	    		System.out.println();
	    	}
	    	in2.close();
	    	
	    	ZipFile zf = new ZipFile("test3.zip");
	    	Enumeration e = zf.entries();
	    	while (e.hasMoreElements()) {
	    		ZipEntry ze2 = (ZipEntry)e.nextElement();
	    		System.out.println("文件：" + ze2);
	    	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
/*
 *************** jdk1.8运行结果*************** 
写入文件test3_1.txt
写入文件test3_2.txt
写入文件test3_3.txt
checksum:826685909
读取文件！
checksum:1
正在读取文件test3_1.txt
test3_1
正在读取文件test3_2.txt
test3_2
正在读取文件test3_3.txt
test3_3
文件：test3_1.txt
文件：test3_2.txt
文件：test3_3.txt
 */
