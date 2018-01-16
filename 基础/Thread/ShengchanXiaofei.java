/*
    ʱ�䣺2016��3��4��19:06:50
    Ŀ�ģ���������
*/
class SynStack//��Ҫ��ͬ��ջ
{
    private char[] data = new char[6];
    private int cnt = 0;//��ʾ������ЧԪ�ظ���

    public synchronized void push(char ch)//ѹջ
    {
    		while (cnt == data.length)//��������Ӧ����ͣ
    		{
    				try
    				{
    						this.wait();//��ͣ��ʹ��ǰ�߳̽�������״̬�����ͷŶ�this������
    				}
    				catch(Exception e)
    				{
    				}
    		}
    		this.notify();//������һ�������ѣ�,�����һ��û����ͣ������䲻������ã����������
    									 //��ִ��this.nottify();���ʱ��cpu������ֱ��ִ�У����ѣ��̣߳�����ʹ����״̬�ģ��������߳̽������״̬
    									 //�����̵߳Ĵ���ִ����Ż��ͷŶ�this�������������ʱ�����߳���ͬʱ�����this�����������ϵͳ������������
				data[cnt] = ch;
				cnt++;
				System.out.printf("�����߳�����������%d����Ʒ���ò�Ʒ�ǣ�%c\n", cnt, ch);
    }

    public synchronized char pop()//��ջ  ��synchronized��ִ֤��pop��ʱ��ִ��push
    {
    		char ch;
    		while (cnt == 0)//���ѿվ�Ӧ����ͣ
    		{
    				try
    				{
    						this.wait();//��ͣ
    				}
    				catch(Exception e)
    				{
    				}
    		}
    		this.notify();//������һ����������
				
				ch = data[cnt-1];
				System.out.printf("�����߳��������ѵ�%d����Ʒ���ò�Ʒ�ǣ�%c\n", cnt, ch);
				cnt--;
				return ch;
    }
}

class Producer implements Runnable//������һ����ʵ������
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
	//    Thread.sleep(2000);  ͨ����ͣ����ʵ�������ѣ�������
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

class Consumer implements Runnable//������һ����ʵ������
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
								Thread.sleep(100);//ʹ����˯�ߣ����������ѿ죩
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
				t1.start();//ִ�е�p��run����
				Thread t2 = new Thread(c);
				t2.start();

    }
}
/*
***************���***************
�����߳�����������1����Ʒ���ò�Ʒ�ǣ�a
�����߳�����������2����Ʒ���ò�Ʒ�ǣ�b
�����߳�����������3����Ʒ���ò�Ʒ�ǣ�c
�����߳�����������4����Ʒ���ò�Ʒ�ǣ�d
�����߳�����������5����Ʒ���ò�Ʒ�ǣ�e
�����߳�����������6����Ʒ���ò�Ʒ�ǣ�f
�����߳��������ѵ�6����Ʒ���ò�Ʒ�ǣ�f
�����߳�����������6����Ʒ���ò�Ʒ�ǣ�g
�����߳��������ѵ�6����Ʒ���ò�Ʒ�ǣ�g
�����߳�����������6����Ʒ���ò�Ʒ�ǣ�h
�����߳��������ѵ�6����Ʒ���ò�Ʒ�ǣ�h
�����߳�����������6����Ʒ���ò�Ʒ�ǣ�i
�����߳��������ѵ�6����Ʒ���ò�Ʒ�ǣ�i
�����߳�����������6����Ʒ���ò�Ʒ�ǣ�j
�����߳��������ѵ�6����Ʒ���ò�Ʒ�ǣ�j
�����߳��������ѵ�5����Ʒ���ò�Ʒ�ǣ�e
�����߳��������ѵ�4����Ʒ���ò�Ʒ�ǣ�d
�����߳��������ѵ�3����Ʒ���ò�Ʒ�ǣ�c
�����߳��������ѵ�2����Ʒ���ò�Ʒ�ǣ�b
�����߳��������ѵ�1����Ʒ���ò�Ʒ�ǣ�a
*/
