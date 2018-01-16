/**
 * date:2017��4��15��17:37:02
 * target:finalize��������������ʱ�����á�
 * @author Administrator
 *
 */
 public class Finalize{
	public static void main(String[] args) {
		while (!Char.f) {
			new Char();
		}
		
		System.gc();//�����������������л��գ�����һ��ִ�У�����ȡ����JVM
		System.runFinalization();//ǿ�Ƶ����Ѿ�ʧȥ���õĶ����finalize����
								 //���ø÷���˵�� Java ���������һЩŬ�������ѱ���������� finalize ������
								 //������Щ����� finalize ����������δ���С�������Ȩ�ӷ��������з���ʱ��
								 //Java ������Ѿ������Ŭ��ȥ�������δִ�е���ֹ������
		System.out.println("һ�������Ķ��� " + Char.created + 
				",һ�����յĶ���" + Char.finalized);
		System.out.println("bye");
	}
}

class Char {
	static boolean gcrun = false;//ָ�������ռ����Ƿ��Ѿ���ʼ����
	static boolean f = false;//����ֹͣ���������
	static int created = 0;//�����Ķ�������
	static int finalized = 0;//�����ռ����ѽ�������β�����Ķ�������
	int i;
	Char() {
		i = ++created;
		if (created == 50) {
			System.out.println("������50������");
		}
	}
	
	//�����ռ���ɾ������֮ǰ���ã�һ��ִ�д˷������ͱ�ʾ�ö���������,ֻ�е������������ͷŸö�����ڴ�ʱ�ŵ���
	//��������˷���Ҳ��һ��������
	//���ж�����󣨼����������ռ������յĶ��󣩵���
	//��������õĴ˷�����˳��Ҳ��ȷ��
	@Override
	protected void finalize() {
		if (!gcrun) {
			System.out.println("��ʼ����finalize�������ڴ����˵�" + i + "�������������������ʼ���У�");
			gcrun = true;
		}
		
		if (i == 50) {
			System.out.println("���ڶԵ�50�����������β����������ֹͣ��ǩ��ֹͣ����Ĵ�����");
			f = true;
		}
		
		finalized++;
		if (finalized >= created)
			System.out.println("����" + finalized + "�������ѱ����գ�");
	}
}
/*
 ***************jdk1.8���н��*************** 
 ������50������
 ��ʼ����finalize�������ڴ����˵�229117�������������������ʼ���У�
 ���ڶԵ�50�����������β����������ֹͣ��ǩ��ֹͣ����Ĵ�����
 һ�������Ķ��� 2469966,һ�����յĶ���2468775
 bye 
 */
