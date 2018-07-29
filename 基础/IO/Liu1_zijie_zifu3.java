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
 * date:2017��7��7��15:36:58
 * target���ֽ������ַ�������д��ʽ��
 * @author ypy
 */
public class Liu1_zijie_zifu3 {
	public static void main(String[] args) {
		try {
			characterWriter("G:\\a\\1.txt", "�ַ���");
			characterReader("G:\\a\\1.txt");
			byteOuput("G:\\a\\2.txt", "�ֽ���");
			byteInput("G:\\a\\2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	//�ֽ���д�����
	public static void byteInput(String filename) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			InputStream ips = new FileInputStream(f);
			
			//���������Ǵ��ļ��ж������ݣ���ˮ��Ҫ����
			//���ӽл�����
			byte[] buf = new byte[1024];
			int len = -1;//��¼��ÿ�ζ�ȡ���ֽڵı����ĳ���
			StringBuffer sb = new StringBuffer();
			while((len=ips.read(buf)) != -1) {
				sb.append(new String(buf, 0, len, "GBK"));//String������췽����b�еĶ�ȡ���������ݻ�ԭ���ַ�����
				                                          //��Ϊ�й���windows����ϵͳ��Ĭ�ϱ�����GBK��
				                                          //Ϊ�˶�ȡ����ȷ���ַ�����Ҫ����ת��
			}
			ips.close();
			System.out.println(sb.toString());
		}
	}
	
	//�ֽ����ӳ���д��
	public static void byteOuput(String filename, String str) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			OutputStream ops = new FileOutputStream(f);
			ops.write(str.getBytes());
			ops.flush();//��ֹ����
			ops.close();
		}
	}
	
	//�ַ���д�����
	public static void characterReader(String filename) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			Reader r = new InputStreamReader(new FileInputStream(f),"GBK"); //ת������
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
	
	//�ַ����ӳ���д��
	public static void characterWriter(String filename, String str) throws IOException {
		File f = new File(filename);
		if (f.exists()) {
			Writer w = new FileWriter(f);
			w.write(str);
			w.flush();//��ֹ����
			w.close();
		}
	}
}
/*
***************JDK1.8���н��****************
�ַ���
�ֽ���
*/
