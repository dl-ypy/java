//java��̬���ػ���
//���з������Ҽ�->Run as->Run config...->Arguments->�ڶ����ı��������-verbose:class->run
public class TestDynamicLoading {
	public static void main(String[] args){
		new A();//��̬����
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
	static {//ֻ����һ��
		System.out.println("cccccccccccccccccccccc");
	}
}

class D{//��̬���飬ÿnewһ������͵���һ��
	{
		System.out.println("ddddddddddddddddddddddddddd");
	}
}
/*
***************JDK1.8���н��***************
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




















