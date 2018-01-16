package com.ypy.observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/* ʱ�䣺2016��12��21��09:59:05
 * Ŀ�ģ��۲���ģʽ
 * ��������⣺����ĳЩ�����״̬�����˸ı䣬����һ�������Ҫ���£���ô����ν����
 * ���̣�ģ��С�������������˵���Ӧ
 */
public class Test {

	public static void main(String[] args) {
		Child child = new Child();
		
		String[] observers = PropertyMgr.getProperty("observers").split(",");    //���ĵ��е���Դ��","����
		
		for (String s : observers) {
			try {
				child.addWakenUpListener((WakenUpListener)(Class.forName(s).newInstance()));//Class.forName(s).newInstance()��ʾ������Դ��������һ�����󣬲�����ʵ����
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

//�¼���
class WakenUpEvent {
	private long time;   //������ʱ��
	private String loc;  //�����ĵص�
	private Child source;//�������¼�Դ
	
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

//�����¼��Ľӿ�
interface WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent w);
}

class Child implements Runnable{   //��������һ���̣߳����������͵��ü����ߵķ���
								   //�������ģʽ�ȸ����������̣߳���һֱ���������Ƿ����������ģʽ����
	private List<WakenUpListener> wakenUpListeners = new ArrayList<WakenUpListener>();

	//��Ӽ�����
	public void addWakenUpListener(WakenUpListener l) {
		wakenUpListeners.add(l);
	}
	
	//�������������ø��������ߵļ����¼�
	void wakeUp() {
		for (int i=0; i<wakenUpListeners.size(); i++) {
			WakenUpListener l = wakenUpListeners.get(i);
			l.ActionToWakenUp(new WakenUpEvent(System.currentTimeMillis(), "bed", this));
		}
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);   //������˯5�������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.wakeUp();
	}
	
}

//�ְֵļ����¼�
class Dad implements WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent wakenUpEvent) {
		System.out.println("����ʱ�䣺" + wakenUpEvent.getTime() + " �����ĵص㣺" + wakenUpEvent.getLoc() + " �¼���feed child");
	}	
}

//үү�ļ����¼�
class GrandFather  implements WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent wakenUpEvent) {
		System.out.println("����ʱ�䣺" + wakenUpEvent.getTime() + " �����ĵص㣺" + wakenUpEvent.getLoc() + " �¼���hug child");
	}	
}

//���ļ����¼�
class Dog implements WakenUpListener {
	public void ActionToWakenUp(WakenUpEvent wakenUpEvent) {
		System.out.println("����ʱ�䣺" + wakenUpEvent.getTime() + " �����ĵص㣺" + wakenUpEvent.getLoc() + " �¼���wang wang ...");
	}
}

//���ĵ��еõ���Դ
class PropertyMgr {
	//�������˵���ģʽ
	/*��new Properties()д��Ҫ���õķ������棬��Ϊ�˵��÷���ʱֻnewһ��
	�����������ڴ���Ƕ�д��������Ӳ�̶����ڴ��У�
	����һ�ν������load���ڴ�֮��props���������Ѿ�������
	������Ϊ����ľ�̬��ʼ��ִֻ��һ�Σ�����props�������ͳ�ʼ���ˣ�����ֵ��ȫ����ȡ���ڴ���
	������getProperty����ʱ��ֱ�Ӵ��ڴ��е��ã��ٶȴ�����
	����ÿ�ε���ʱ����ֻ�е�һ�ε���ʱ��һ��props�������Խе���ģʽ*/
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
**************JDK1.8���н��***************
����ʱ�䣺1497054934846 �����ĵص㣺bed �¼���feed child
����ʱ�䣺1497054934847 �����ĵص㣺bed �¼���hug child
����ʱ�䣺1497054934847 �����ĵص㣺bed �¼���wang wang ...
*/
