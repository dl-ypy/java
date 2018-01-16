package com.ypy.www.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable{
	private Socket socket;
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public ServerThread() {
		super();
	}

	@Override
	public void run() {
		try {
			InputStream ips = socket.getInputStream();
			byte[] b = new byte[1024];
			String str = new String(b, 0, ips.read(b));
			String fileName = ("G:\\a\\" + str);
			File f = new File(fileName);
			OutputStream o = socket.getOutputStream();
			if(!f.exists()) {
				o.write("和谐了".getBytes());
				socket.close();
				return;
			}
			
			//将文件长度返回给客户端
			o.write((""+f.length()).getBytes());
			
			String clientInfo = new String(b, 0, ips.read(b));
			//判断客户端是否要开始下载
			if(!"begin".equals(clientInfo)) {
				socket.close();
				return;
			}
			//开始读取要下载的文件
			FileInputStream file = new FileInputStream(fileName);
			int len = -1;
			while((len=file.read(b)) != -1) {
				o.write(b, 0, len);
			}
			file.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
