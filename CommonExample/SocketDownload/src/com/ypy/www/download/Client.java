package com.ypy.www.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 客户端
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
			if("和谐了".equals(serverInfo)) {
				System.out.println(serverInfo);
				s.close();
				return;
			}
			
			//得到文件长度
			int fileLength = Integer.parseInt(serverInfo);
			//开始下载
			o.write("begin".getBytes());
			
			//创建文件
			File f = new File("G:\\a\\b\\"+fileName);
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();
			
			//接受下载的文件并写入
			FileOutputStream file = new FileOutputStream(f);
			int len = -1;
			int count = 0;
			while((len=ips.read(b)) != -1) {
				file.write(b,0,len);
				count += len;
				//如果不判断，就会停滞
				if (count >= fileLength) {
					System.out.println("下载成功！");
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
