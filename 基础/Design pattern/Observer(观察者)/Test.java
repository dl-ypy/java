import java.util.ArrayList;
import java.util.List;

/**
 * data:2018年1月12日16点15分
 * @author joker
 * 观察者模式
 * 观察者模式也叫作发布-订阅模式，也就是事件监听机制。观察者模式定义了一种一对多的依赖关系，
 * 让多个观察者对象同时监听某一个主题对象，这个主题对象在状态上发生变化时，会通知所有观察者对象，使他们能够自动更新自己。
 * 观察者模式所涉及的角色有：
 * 1、抽象主题角色
 * 抽象主题角色把所有对观察者对象的引用保存在一个集合中，每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象。
 * 2、具体主题角色
 * 将有关状态存入具体观察者对象，在具体主题的内部状态改变时，给所有登记过的观察者发出通知。
 * 3、抽象观察者角色
 * 为所有的具体观察者提供一个接口，在得到主题通知时更新自己
 * 4、具体观察者角色
 * 存储与主题的状态相关的状态。具体观察者角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态协调
 */
public class Test{
	public static void main(String[] args) {
		//创建主题角色
		ConcreteSubject s = new ConcreteSubject();
		//创建观察者对象
		Observer o = new ConcreteObserver();
		//注册观察者对象
		s.attch(o);
		//改变主题状态
		s.change("新的状态");
	}
}

/*观察者接口*/
interface Observer {
	void update(String state);
}

/*具体观察者*/
class ConcreteObserver implements Observer {
	//观察者状态
	private String observerState;
	@Override
	public void update(String state) {
		this.observerState = state;
		System.out.println("观察者状态改变为："+observerState);
	}
}

/*抽象主题类*/
abstract class Subject {
	//保存注册的观察者对象
	private List<Observer> observerList = new ArrayList<>();
	
	//注册观察者对象
	public void attch(Observer observer) {
		observerList.add(observer);
		System.out.println("注册一个观察者对象");
	}
	
	//删除观察者对象
	public void remove(Observer observer) {
		observerList.remove(observer);
		System.out.println("删除一个观察者对象");
	}
	
	//通知所有注册的观察者对象
	public void notifyObservers(String newState) {
		for (int i=0; i<observerList.size(); i++) {
			observerList.get(i).update(newState);
		}
	}
}

/*具体主题类*/
class ConcreteSubject extends Subject {
	private String state;
	
	public String getState() {
		return state;
	}
	
	public void change(String newState) {
		state = newState;
		System.out.println("主题状态为:"+newState);
		//状态改变时，通知所有观察者
		this.notifyObservers(newState);
	}
}

/**
 * JDK1.8运行结果
 * 注册一个观察者对象
 * 主题状态为:新的状态
 * 观察者状态改变为：新的状态
*/