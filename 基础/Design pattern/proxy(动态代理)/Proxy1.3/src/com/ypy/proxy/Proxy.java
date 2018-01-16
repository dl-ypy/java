package com.ypy.proxy;
//������
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
	
	//����һ���µĴ���
	public static Object newProxyInstance(Class intf, InvocationHandler h) throws Exception{
		String rt = "\r\t";    //�س�
		String methodStr = "";    //�����Ĵ���
		
		Method[] methods = intf.getMethods();    //�õ��ýӿڵķ���
		for (Method m : methods) {
			methodStr += "		@Override" + rt +
						"		public void " + m.getName() + "() {" + rt +
						"			try {" + rt +   
						"			    Method md = " + intf.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						"			    h.invoke(this, md);" + rt +     
						"			} catch (Exception e) {e.printStackTrace();}" + rt +
						"		}";
		}
		
		String src =           //Ҫ��̬�����Ĵ���
		"	package com.ypy.proxy;" + rt +
		"   import java.lang.reflect.Method;" + rt +
		"	public class Proxy1 implements "+ intf.getName() +"{" + rt +   //���Խ���ʵ�ֵĽӿ���Ϊ����
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
		
		//�Զ�̬���ɵĴ�����б���,����class�ļ�
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();   //�õ�ϵͳĬ�ϵ�Java������
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName2);   //fileMgr��������ļ�
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load���ڴ�
		//��Ϊ�������class�ļ�������binĿ¼�£����Ա���ͨ������ķ�������load
		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.ypy.proxy.Proxy1");
			
		//����һ���¶���
		Constructor ctr = c.getConstructor(InvocationHandler.class);   //�ҵ��������ΪInvocationHandler�Ĺ��췽��
		Object m = ctr.newInstance(h);
		
		return m;
	}
}
