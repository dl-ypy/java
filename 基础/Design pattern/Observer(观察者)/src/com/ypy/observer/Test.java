package com.ypy.observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/* 时间：2016年12月21日09:59:05
 * 目的：观察者模式
 * 解决的问题：由于某些对象的状态发生了改变，所以一组对象都需要更新，那么该如何解决？
 * 过程：模拟小孩醒来，其他人的响应
 */
public class Test {

	public static void main(String[] args) {
		Child child = new Child();
		
		String[] observers = PropertyMgr.getProperty("observers").split(",");    //将文档中的资源按","隔开
		
		for (String s : observers) {
			try {
				child.addWakenUpListener((WakenUpListener)(Class.forName(s).newInstance()));//Class.forName(s).newInstance()表示返回资源中这个类的一个对象，并将其实例化
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		new Thread(child).start();
	}

}

//事件类
class WakenUpEvent {
	private long time;   //醒来的时间
	private String loc;  //醒来的地点
	private Child source;//醒来的事件源
	
	public WakenUpEvent(long time, String loc, Child source) {
		super();
		this.time = time;
		this.loc = loc;
		this.source = source;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Child getSource() {
		return source;
	}
	public void setSource(Child source) {
		this.source = source;
	}
}

//监听事件的接口
interface WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent w);
}

class Child implements Runnable{   //给孩子起一个线程，等他醒来就调用监听者的方法
								   //这种设计模式比给监听者起线程，来一直监听孩子是否醒来的设计模式更好
	private List<WakenUpListener> wakenUpListeners = new ArrayList<WakenUpListener>();

	//添加监听者
	public void addWakenUpListener(WakenUpListener l) {
		wakenUpListeners.add(l);
	}
	
	//孩子醒来，调用各个监听者的监听事件
	void wakeUp() {
		for (int i=0; i<wakenUpListeners.size(); i++) {
			WakenUpListener l = wakenUpListeners.get(i);
			l.ActionToWakenUp(new WakenUpEvent(System.currentTimeMillis(), "bed", this));
		}
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);   //孩子在睡5秒后醒来
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.wakeUp();
	}
	
}

//爸爸的监听事件
class Dad implements WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent wakenUpEvent) {
		System.out.println("醒来时间：" + wakenUpEvent.getTime() + " 醒来的地点：" + wakenUpEvent.getLoc() + " 事件：feed child");
	}	
}

//爷爷的监听事件
class GrandFather  implements WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent wakenUpEvent) {
		System.out.println("醒来时间：" + wakenUpEvent.getTime() + " 醒来的地点：" + wakenUpEvent.getLoc() + " 事件：hug child");
	}	
}

//狗的监听事件
class Dog implements WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent wakenUpEvent) {
		System.out.println("醒来时间：" + wakenUpEvent.getTime() + " 醒来的地点：" + wakenUpEvent.getLoc() + " 事件：wang wang ...");
	}
}

//从文档中得到资源
class PropertyMgr {
	//这里用了单例模式
	/*将new Properties()写到要调用的方法外面，是为了调用方法时只new一次
	计算机中最耗内存的是读写操作（从硬盘读到内存中）
	当第一次将这个类load到内存之后，props这个对象就已经存在了
	而且因为下面的静态初始化只执行一次，所以props这个对象就初始化了，属性值就全部读取到内存中
	当调用getProperty方法时，直接从内存中调用，速度大大提高
	而且每次调用时，就只有第一次调用时的一个props对象，所以叫单例模式*/
	private static Properties props = new Properties();
	
	static {
		try {
			props.load(Test.class.getClassLoader().getResourceAsStream("com/ypy/observer/observer.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
}
/*
**************JDK1.8运行结果***************
醒来时间：1497054934846 醒来的地点：bed 事件：feed child
醒来时间：1497054934847 醒来的地点：bed 事件：hug child
醒来时间：1497054934847 醒来的地点：bed 事件：wang wang ...
*/
