//java动态加载机制
//运行方法：右键->Run as->Run config...->Arguments->第二个文本框里面加-verbose:class->run
public class TestDynamicLoading {
	public static void main(String[] args){
		new A();//动态加载
		System.out.println("--------------------------");
		new B();
		
		new C();
		new C();
		
		new D();
		new D();
		
	}
}

class A{
	
}

class B{
	
}

class C{
	static {//只调用一次
		System.out.println("cccccccccccccccccccccc");
	}
}

class D{//动态语句块，每new一个对象就调用一次
	{
		System.out.println("ddddddddddddddddddddddddddd");
	}
}
/*
***************JDK1.8运行结果***************
......
[Loaded A from file:/F:/study/EclipseWorkspace/Reflection/bin/]
--------------------------
[Loaded B from file:/F:/study/EclipseWorkspace/Reflection/bin/]
[Loaded C from file:/F:/study/EclipseWorkspace/Reflection/bin/]
cccccccccccccccccccccc
[Loaded D from file:/F:/study/EclipseWorkspace/Reflection/bin/]
ddddddddddddddddddddddddddd
ddddddddddddddddddddddddddd
[Loaded java.lang.Shutdown from C:\Program Files\Java\jdk1.8.0_102\jre\lib\rt.jar]
[Loaded java.lang.Shutdown$Lock from C:\Program Files\Java\jdk1.8.0_102\jre\lib\rt.jar]
*/




















