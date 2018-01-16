package com.ypy.proxy.test;

import com.ypy.proxy.InvocationHandler;
import com.ypy.proxy.Moveable;
import com.ypy.proxy.Proxy;
import com.ypy.proxy.Tank;



public class Client {
	public static void main(String[] args) throws Exception {
		//Moveable t = new Tank();
		UserMgr mgr = new UserMgrImpl();
		
		//InvocationHandler h = new TimeHandler(t);
		InvocationHandler h = new TransactionHandler(mgr);
		
		//Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
		UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class, h);
		
		//m.move();
		u.addUser();
	}
}
