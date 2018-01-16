package com.ypy.www.download;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * data:2017年7月8日19:28:11
 * target:网络编程--文件下载    服务器端
 * @author ypy
 */
public class Server {

	public static void main(String[] args) {
		System.out.println("启动服务器！");
		try {
			ServerSocket server = new ServerSocket(4567);
			//循环启动多线程
			while(true) {
				new Thread(new ServerThread(server.accept())).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
