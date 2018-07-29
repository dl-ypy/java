package com.ypy.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/**
 * date:2017年7月7日15:36:58
 * target：字节流与字符流的书写格式。
 * @author ypy
 */
public class Liu1_zijie_zifu3 {
	public static void main(String[] args) {
		try {
			characterWriter("G:\\a\\1.txt", "字符流");
			characterReader("G:\\a\\1.txt");
			byteOuput("G:\\a\\2.txt", "字节流");
			byteInput("G:\\a\\2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	//字节流写入程序
	public static void byteInput(String filename) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			InputStream ips = new FileInputStream(f);
			
			//读出来就是从文件中读出数据，喝水需要杯子
			//杯子叫缓冲区
			byte[] buf = new byte[1024];
			int len = -1;//记录我每次读取的字节的变量的长度
			StringBuffer sb = new StringBuffer();
			while((len=ips.read(buf)) != -1) {
				sb.append(new String(buf, 0, len, "GBK"));//String这个构造方法将b中的读取出来的内容还原成字符串，
				                                          //因为中国版windows操作系统的默认编码是GBK的
				                                          //为了读取到正确的字符，需要进行转码
			}
			ips.close();
			System.out.println(sb.toString());
		}
	}
	
	//字节流从程序写出
	public static void byteOuput(String filename, String str) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			OutputStream ops = new FileOutputStream(f);
			ops.write(str.getBytes());
			ops.flush();//防止出错
			ops.close();
		}
	}
	
	//字符流写入程序
	public static void characterReader(String filename) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			Reader r = new InputStreamReader(new FileInputStream(f),"GBK"); //转换编码
			char[] cbuf = new char[1024];
			int len = -1;
			StringBuffer sb = new StringBuffer();
			while((len=r.read(cbuf)) != -1) {
				sb.append(cbuf, 0, len);
			}
			r.close();
			System.out.println(sb.toString());
		}
	}
	
	//字符流从程序写出
	public static void characterWriter(String filename, String str) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			Writer w = new FileWriter(f);
			w.write(str);
			w.flush();//防止出错
			w.close();
		}
	}
}
/*
***************JDK1.8运行结果****************
字符流
字节流
*/
