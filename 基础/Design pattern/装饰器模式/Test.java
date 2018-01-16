package javaTest;


/**
 * data:2018年1月15日11点11分
 * @author joker
 * 装饰模式
 * 装饰器模式又称为包装（Wrapper）模式。装饰器模式以多客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。
 * 1、抽象构件角色
 * 给出一个抽象接口，以规范准备接受附加责任的对象
 * 2、具体构件角色
 * 定义一个将要接受附加责任的类
 * 3、装饰角色
 * 持有一个构建对象的实例，并定义一个与抽象构件接口一致的接口
 * 4、具体装饰角色
 * 负责给构建对象贴上附加的责任
 */

//客户端
public class Test{
	public static void main(String[] args) {
		Cook cook0 = new WashHandsCook(new ChineseCook());
	    Cook cook1 = new WashHearCook(new ChineseCook());
	        
	    cook0.cookDinner();
	    cook1.cookDinner();
	}
}

//抽象构件角色
interface Cook {
	void cookDinner();
}

//具体构件角色
class ChineseCook implements Cook {
	@Override
	public void cookDinner() {
		System.out.println("中国人做晚饭");
	}
}

//装饰角色
abstract class FilterCook implements Cook {
    protected Cook cook;
}

//具体装饰角色
class WashHandsCook extends FilterCook {
    public WashHandsCook(Cook cook) {
        this.cook = cook;
    }
    
    @Override
    public void cookDinner() {
        System.out.println("先洗手");
        cook.cookDinner();
    }
}

//具体装饰角色
class WashHearCook extends FilterCook {
    public WashHearCook(Cook cook) {
        this.cook = cook;
    }
    
    @Override
    public void cookDinner() {
        System.out.println("先洗头");
        cook.cookDinner();
    }
}
/**
 * 先洗手
 * 中国人做晚饭
 * 先洗头
 * 中国人做晚饭
*/