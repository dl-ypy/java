package com.ypy.proxy.test;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.ypy.proxy.Moveable;
import com.ypy.proxy.Tank;

public class test {

	public static void main(String[] args) throws Exception{
		String rt = "\r\t";    //�س�
		String src =           //Ҫ��̬�����Ĵ���
		"	package com.ypy.proxy;" + rt +
		"	public class TankTimeProxy implements Moveable{" + rt +
		"		Moveable t;" + rt +
		"		public TankTimeProxy(Moveable t) {" + rt +
		"			this.t = t;" + rt +
		"		}" + rt +
		"		@Override" + rt +
		"		public void move() {" + rt +
		"			long start = System.currentTimeMillis();" + rt +   
		"			t.move();" + rt +
		"			long end = System.currentTimeMillis();" + rt +     
		"			System.out.println(\"time\" + (end-start));" + rt +
		"		}" + rt +
		"	}";
		
		String fileName = System.getProperty("user.dir")   //�ҵ���Ŀ¼
				+ "/src/com/ypy/proxy/TankTimeProxy.java";     //����Java�ļ�
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//�Զ�̬���ɵĴ�����б���,����class�ļ�
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();   //�õ�ϵͳĬ�ϵ�Java������
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);   //fileMgr��������ļ�
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load���ڴ�
		//��Ϊ�������class�ļ�������binĿ¼�£����Ա���ͨ������ķ�������load
		URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") + "/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.ypy.proxy.TankTimeProxy");
			
		//����һ���¶���
		Constructor ctr = c.getConstructor(Moveable.class);   //�ҵ��������ΪMoveable�Ĺ��췽��
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		
		//����
		m.move();
	}

}
