package com.ypy.www.download;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * data:2017��7��8��19:28:11
 * target:������--�ļ�����    ��������
 * @author ypy
 */
public class Server {

	public static void main(String[] args) {
		System.out.println("������������");
		try {
			ServerSocket server = new ServerSocket(4567);
			//ѭ���������߳�
			while(true) {
				new Thread(new ServerThread(server.accept())).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
