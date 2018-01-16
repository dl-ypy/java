package com.ypy.www.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * �ͻ���
 * @author ypy
 */
public class Client {

	public static void main(String[] args) {
		try {
			download("3.txt");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void download(String fileName) throws UnknownHostException, IOException {
		Socket s = new Socket("169.254.132.209", 4567);
		try {
			OutputStream o = s.getOutputStream();
			o.write(fileName.getBytes());
			
			InputStream ips = s.getInputStream();
			byte[] b = new byte[1024];
			String serverInfo = new String(b,0,ips.read(b));
			if("��г��".equals(serverInfo)) {
				System.out.println(serverInfo);
				s.close();
				return;
			}
			
			//�õ��ļ�����
			int fileLength = Integer.parseInt(serverInfo);
			//��ʼ����
			o.write("begin".getBytes());
			
			//�����ļ�
			File f = new File("G:\\a\\b\\"+fileName);
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();
			
			//�������ص��ļ���д��
			FileOutputStream file = new FileOutputStream(f);
			int len = -1;
			int count = 0;
			while((len=ips.read(b)) != -1) {
				file.write(b,0,len);
				count += len;
				//������жϣ��ͻ�ͣ��
				if (count >= fileLength) {
					System.out.println("���سɹ���");
					break;
				}
			}
			file.close();
			s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
