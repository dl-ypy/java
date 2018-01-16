/**
 * date:2017年5月23日10:26:53
 * target:forName加载类。
 * @author ypy
 * conclusion:
 *     每个Class 只有在它需要的时候才会载入，而static初始化工作是在类载入时执行的。
 */
class Candy {
	static {
		System.out.println("加载Candy类！");
	}
}

class Gum {
	static {
		System.out.println("加载Gum类！");
	}
}

class Cookie {
	static {
		System.out.println("加载Cookie类！");
	}
}

public class ForName {
	public static void main(String[] args) {
		System.out.println("main");
		new Candy();
		System.out.println("创建Candy后...");
		try {
			Class.forName("Gum");//如果有包名要加上包名
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Class.forName(\"Gum\")后...");
		new Cookie();
		System.out.println("创建Cookie后...");
	}
}
/*
 *************** jdk1.8运行结果*************** 
main
加载Candy类！
创建Candy后...
加载Gum类！
Class.forName("Gum")后...
加载Cookie类！
创建Cookie后...
 */
