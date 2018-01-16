/**
 * data:2018年1月11日14点53分
 * @author joker
 * 策略模式
 * 策略模式的用意是针对一组算法，将每一个算法封装到具有共同接口的独立类中，
 * 从而使得它们可以相互替换。策略模式使得算法可以在不影响到客户端的情况下发生变化。
 * 
 * 策略模式是对算法的包装，是把使用算法的责任和算法本身分开。策略模式通常是把一系列的算法包装到一系列的策略类里面，作为一个抽象策略类的子类。
 * 策略模式涉及到三个角色：
 * 1、环境角色
 * 持有一个策略Strategy的引用
 * 2、抽象策略角色
 * 这是一个抽象角色，通常由一个接口或抽象类实现，此角色给出所有具体策略类所需的接口
 * 3、具体策略角色
 * 包装了相关算法或行为
 */
public class Test{
	public static void main(String[] args) {
		Strategy strategyA = new StrategyA();
		Strategy strategyB = new StrategyB();
		
		User userA = new User(strategyA);
		userA.strategyMethod();
		User userB = new User(strategyB);
		userB.strategyMethod();
	}
}

/*环境角色*/
class User {
	private Strategy strategy;
	
	public User(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void strategyMethod(){
        strategy.useStrategy();
    }
}

/*抽象策略角色*/
interface Strategy {
	void useStrategy();
}

/*具体策略角色*/
class StrategyA implements Strategy {
	@Override
	public void useStrategy() {
		System.out.println("策略A");
	}
}

class StrategyB implements Strategy {
	@Override
	public void useStrategy() {
		System.out.println("策略B");
	}
}
/**
 * JDK1.8运行结果
 * 策略A
 * 策略B 
*/