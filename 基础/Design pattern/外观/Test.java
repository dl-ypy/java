/**
 * data:2018年1月15日10点27分
 * @author joker
 * 外观模式
 * 外观模式是对象的结构模式，外部与一个子系统的通信必须通过一个统一的外观对象进行。外观模式是一个高层次的接口，使得子系统更易于使用。
 * 1、外观角色
 * 客户端调用这个角色的方法。此角色知晓相关的子系统的功能和责任，正常情况下，本角色会将所有从客户端发来的请求委派到响应的子系统中
 * 2、子系统角色
 * 可以同时有一个或多个子系统，每个子系统都不是一个单独的类，而是一个类的集合。每个子系统都可以被客户端直接调用，或者被外观角色直接调用。子系统并不知道外观角色的存在，对于子系统而言，外观仅仅是另外一个客户端而已
 */

//客户端
public class Test{
	public static void main(String[] args) {
		Facade f = new Facade();
		f.fun();
	}
}

//外观角色
class Facade {
	public void fun() {
		ModelA a = new ModelA();
		a.funA();
		ModelB b = new ModelB();
		b.funB();
	}
}

//子系统角色
class ModelA {
	public void funA() {
		System.out.println("模块A的方法");
	}
}

//子系统角色
class ModelB {
	public void funB() {
		System.out.println("模块B的方法");
	}
}
/**
 * JDK1.8运行结果
 * 模块A的方法
 * 模块B的方法
*/