/*
时间：2016年12月9日10:46:13
目的：生产者-消费者（往篮子里放馒头与吃馒头）
*/
public class XianCheng_14ProducerConsumer{
	public static void main(String[] args){
		SyncStack ss = new SyncStack();
		Producer producer = new Producer(ss);
		Consumer consumer = new Consumer(ss);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

//物品类，本程序中指馒头
class WoTou{
	int id;
	
	WoTou(int id){
		this.id = id;
	}
	
	public String toString(){
		return "馒头" + (id+1);
	}
}

//篮子类
class SyncStack{
	int index = 0;
	WoTou[] arrWT = new WoTou[6];//篮子里最多放6个，即不能连续生成超过6个，而不消费
	
	//往里面放
	public synchronized void push(WoTou wt){
		//加synchronized使得一个线程执行下面语句时不能被打断
		while (index == arrWT.length){//如果篮子满了，停止生产
			                            //这里用while而不用if，因为if在抛出异常后会直接后面的this.notify();
			                            //而while在抛出异常后还会再判断index == arrWT.length
			try {
				this.wait();//使得当前线程停止，只有用synchronized锁定的，才能调用wait，而且锁也不归此线程所有了
										//wait与sleep的区别   wait是object类的  sleep是thread类的
										//wait时，别的线程可以访问被锁定对象，sleep时不可以
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.notify();//叫醒其他线程（nottifyAll）叫醒其他全部
		arrWT[index] = wt;
		index++;
	}
	
	//从里面取
	public synchronized WoTou pop(){
		while (index == 0){//篮子空了，停止消费
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return arrWT[index];
	}
}

//生产
class Producer implements Runnable{
	SyncStack ss = null;
	Producer(SyncStack ss){
		this.ss = ss;
	}
	
	public void run(){
		for (int i=0; i<20; i++){//假设每个人能生产20个	
			WoTou wt = new WoTou(i);
			ss.push(wt);
			System.out.println("生成：" + wt);
			try {
				Thread.sleep((int)(Math.random() * 1000));//在1秒的倍数里随机睡眠，因为是double型，所以要强制转换为int
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

//消费
class Consumer implements Runnable{
	SyncStack ss = null;
	Consumer(SyncStack ss){
		this.ss = ss;
	}
	
	public void run(){
		for (int i=0; i<20; i++){//假设每个人能吃20个	
			WoTou wt = ss.pop();
			System.out.println("消费：" + wt);
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

/*
***************JDK1.8运行结果***************
生成：馒头1
消费：馒头1
生成：馒头2
生成：馒头3
消费：馒头3
生成：馒头4
消费：馒头4
消费：馒头2
生成：馒头5
消费：馒头5
生成：馒头6
消费：馒头6
生成：馒头7
消费：馒头7
生成：馒头8
消费：馒头8
生成：馒头9
消费：馒头9
消费：馒头10
生成：馒头10
生成：馒头11
生成：馒头12
消费：馒头12
生成：馒头13
消费：馒头13
消费：馒头11
生成：馒头14
消费：馒头14
消费：馒头15
生成：馒头15
生成：馒头16
消费：馒头16
生成：馒头17
消费：馒头17
生成：馒头18
消费：馒头18
消费：馒头19
生成：馒头19
生成：馒头20
消费：馒头20
*/