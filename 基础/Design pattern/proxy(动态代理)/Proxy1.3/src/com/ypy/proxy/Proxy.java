package com.ypy.proxy;
//代理类
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	
	//产生一个新的代理
	public static Object newProxyInstance(Class intf, InvocationHandler h) throws Exception{
		String rt = "\r\t";    //回车
		String methodStr = "";    //方法的代码
		
		Method[] methods = intf.getMethods();    //得到该接口的方法
		for (Method m : methods) {
			methodStr += "		@Override" + rt +
						"		public void " + m.getName() + "() {" + rt +
						"			try {" + rt +   
						"			    Method md = " + intf.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						"			    h.invoke(this, md);" + rt +     
						"			} catch (Exception e) {e.printStackTrace();}" + rt +
						"		}";
		}
		
		String src =           //要动态产生的代码
		"	package com.ypy.proxy;" + rt +
		"   import java.lang.reflect.Method;" + rt +
		"	public class Proxy1 implements "+ intf.getName() +"{" + rt +   //可以将它实现的接口作为参数
		"       com.ypy.proxy.InvocationHandler h;" + rt +
		"		public Proxy1(InvocationHandler h) {" + rt +
		"			this.h = h;" + rt +
		"		}" + rt +
		        methodStr + rt +
		"	}";
		
		String fileName1 = "d:/src/com/ypy/proxy";     
		String fileName2 = "d:/src/com/ypy/proxy/Proxy1.java";
		File f1 = new File(fileName1);
		f1.mkdirs();
		File f2 = new File(fileName2);
		
		f2.createNewFile(); 

	    FileWriter fw = new FileWriter(fileName2);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//对动态生成的代理进行编译,生成class文件
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();   //拿到系统默认的Java编译器
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName2);   //fileMgr管理这个文件
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load到内存
		//因为编译完的class文件并不在bin目录下，所以必须通过下面的方法进行load
		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.ypy.proxy.Proxy1");
			
		//生成一个新对象
		Constructor ctr = c.getConstructor(InvocationHandler.class);   //找到里面参数为InvocationHandler的构造方法
		Object m = ctr.newInstance(h);
		
		return m;
	}
}
