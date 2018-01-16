/*
    时间：2016年3月4日19:06:50
    目的：生产消费
*/
class SynStack//需要用同步栈
{
    private char[] data = new char[6];
    private int cnt = 0;//表示数组有效元素个数

    public synchronized void push(char ch)//压栈
    {
    		while (cnt == data.length)//生产满就应该暂停
    		{
    				try
    				{
    						this.wait();//暂停，使当前线程进入阻塞状态，并释放对this的锁定
    				}
    				catch(Exception e)
    				{
    				}
    		}
    		this.notify();//叫醒另一个（消费）,如果另一个没有暂停，此语句不起就作用，并不会出错
    									 //当执行this.nottify();语句时，cpu并不会直接执行（消费）线程，而是使阻塞状态的（生产）线程进入就绪状态
    									 //当此线程的代码执行完才会释放对this对象的锁定，此时两个线程再同时争夺对this对象的锁定（系统调度器决定）
				data[cnt] = ch;
				cnt++;
				System.out.printf("生产线程正在生产第%d个产品，该产品是：%c\n", cnt, ch);
    }

    public synchronized char pop()//出栈  加synchronized保证执行pop的时候不执行push
    {
    		char ch;
    		while (cnt == 0)//消费空就应该暂停
    		{
    				try
    				{
    						this.wait();//暂停
    				}
    				catch(Exception e)
    				{
    				}
    		}
    		this.notify();//叫醒另一个（生产）
				
				ch = data[cnt-1];
				System.out.printf("消费线程正在消费第%d个产品，该产品是：%c\n", cnt, ch);
				cnt--;
				return ch;
    }
}

class Producer implements Runnable//单独用一个类实现生产
{
    private SynStack ss = null;

    public Producer(SynStack ss)
    {
				this.ss = ss;
    }

    public void run()
    {
    		char ch;
        //try{                     
	//    Thread.sleep(2000);  通过暂停可以实现先消费，后生产
	//}
	//catch(Exception e){
	//}
				for (int i=0; i<10; i++)
				{
						ch = (char)('a'+i);
						ss.push(ch);
				}
    }
}

class Consumer implements Runnable//单独用一个类实现消费
{
    private SynStack ss = null;

    public Consumer(SynStack ss)
    {
				this.ss = ss;
    }

    public void run()
    {
				for (int i=0; i<20; i++)
				{
						try
						{
								Thread.sleep(100);//使消费睡眠（生产比消费快）
						}
						catch(Exception e)
						{
						}
						
						ss.pop();
				}
    }
}

public class ShengchanXiaofei
{
    public static void main(String[] args)
    {
				SynStack ss = new SynStack();
				Producer p = new Producer(ss);
				Consumer c = new Consumer(ss);

				Thread t1 = new Thread(p);
				t1.start();//执行的p的run方法
				Thread t2 = new Thread(c);
				t2.start();

    }
}
/*
***************结果***************
生产线程正在生产第1个产品，该产品是：a
生产线程正在生产第2个产品，该产品是：b
生产线程正在生产第3个产品，该产品是：c
生产线程正在生产第4个产品，该产品是：d
生产线程正在生产第5个产品，该产品是：e
生产线程正在生产第6个产品，该产品是：f
消费线程正在消费第6个产品，该产品是：f
生产线程正在生产第6个产品，该产品是：g
消费线程正在消费第6个产品，该产品是：g
生产线程正在生产第6个产品，该产品是：h
消费线程正在消费第6个产品，该产品是：h
生产线程正在生产第6个产品，该产品是：i
消费线程正在消费第6个产品，该产品是：i
生产线程正在生产第6个产品，该产品是：j
消费线程正在消费第6个产品，该产品是：j
消费线程正在消费第5个产品，该产品是：e
消费线程正在消费第4个产品，该产品是：d
消费线程正在消费第3个产品，该产品是：c
消费线程正在消费第2个产品，该产品是：b
消费线程正在消费第1个产品，该产品是：a
*/
