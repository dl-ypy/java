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
		String rt = "\r\t";    //回车
		String src =           //要动态产生的代码
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
		
		String fileName = System.getProperty("user.dir")   //找到根目录
				+ "/src/com/ypy/proxy/TankTimeProxy.java";     //产生Java文件
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//对动态生成的代理进行编译,生成class文件
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();   //拿到系统默认的Java编译器
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);   //fileMgr管理这个文件
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load到内存
		//因为编译完的class文件并不在bin目录下，所以必须通过下面的方法进行load
		URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") + "/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.ypy.proxy.TankTimeProxy");
			
		//生成一个新对象
		Constructor ctr = c.getConstructor(Moveable.class);   //找到里面参数为Moveable的构造方法
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		
		//运行
		m.move();
	}

}
