/*
ʱ�䣺2016��12��9��10:46:13
Ŀ�ģ�������-�����ߣ������������ͷ�����ͷ��
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

//��Ʒ�࣬��������ָ��ͷ
class WoTou{
	int id;
	
	WoTou(int id){
		this.id = id;
	}
	
	public String toString(){
		return "��ͷ" + (id+1);
	}
}

//������
class SyncStack{
	int index = 0;
	WoTou[] arrWT = new WoTou[6];//����������6�����������������ɳ���6������������
	
	//�������
	public synchronized void push(WoTou wt){
		//��synchronizedʹ��һ���߳�ִ���������ʱ���ܱ����
		while (index == arrWT.length){//����������ˣ�ֹͣ����
			                            //������while������if����Ϊif���׳��쳣���ֱ�Ӻ����this.notify();
			                            //��while���׳��쳣�󻹻����ж�index == arrWT.length
			try {
				this.wait();//ʹ�õ�ǰ�߳�ֹͣ��ֻ����synchronized�����ģ����ܵ���wait��������Ҳ������߳�������
										//wait��sleep������   wait��object���  sleep��thread���
										//waitʱ������߳̿��Է��ʱ���������sleepʱ������
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.notify();//���������̣߳�nottifyAll����������ȫ��
		arrWT[index] = wt;
		index++;
	}
	
	//������ȡ
	public synchronized WoTou pop(){
		while (index == 0){//���ӿ��ˣ�ֹͣ����
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

//����
class Producer implements Runnable{
	SyncStack ss = null;
	Producer(SyncStack ss){
		this.ss = ss;
	}
	
	public void run(){
		for (int i=0; i<20; i++){//����ÿ����������20��	
			WoTou wt = new WoTou(i);
			ss.push(wt);
			System.out.println("���ɣ�" + wt);
			try {
				Thread.sleep((int)(Math.random() * 1000));//��1��ı��������˯�ߣ���Ϊ��double�ͣ�����Ҫǿ��ת��Ϊint
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

//����
class Consumer implements Runnable{
	SyncStack ss = null;
	Consumer(SyncStack ss){
		this.ss = ss;
	}
	
	public void run(){
		for (int i=0; i<20; i++){//����ÿ�����ܳ�20��	
			WoTou wt = ss.pop();
			System.out.println("���ѣ�" + wt);
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

/*
***************JDK1.8���н��***************
���ɣ���ͷ1
���ѣ���ͷ1
���ɣ���ͷ2
���ɣ���ͷ3
���ѣ���ͷ3
���ɣ���ͷ4
���ѣ���ͷ4
���ѣ���ͷ2
���ɣ���ͷ5
���ѣ���ͷ5
���ɣ���ͷ6
���ѣ���ͷ6
���ɣ���ͷ7
���ѣ���ͷ7
���ɣ���ͷ8
���ѣ���ͷ8
���ɣ���ͷ9
���ѣ���ͷ9
���ѣ���ͷ10
���ɣ���ͷ10
���ɣ���ͷ11
���ɣ���ͷ12
���ѣ���ͷ12
���ɣ���ͷ13
���ѣ���ͷ13
���ѣ���ͷ11
���ɣ���ͷ14
���ѣ���ͷ14
���ѣ���ͷ15
���ɣ���ͷ15
���ɣ���ͷ16
���ѣ���ͷ16
���ɣ���ͷ17
���ѣ���ͷ17
���ɣ���ͷ18
���ѣ���ͷ18
���ѣ���ͷ19
���ɣ���ͷ19
���ɣ���ͷ20
���ѣ���ͷ20
*/