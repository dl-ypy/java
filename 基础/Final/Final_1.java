/**
 * date:2017��4��17��16:45:04
 * target:final�������ݡ�
 * @author ypy
 */
public class Final_1{
	public static void main(String[] args) {
		FinalData f1 = new FinalData();
		FinalData f2 = new FinalData();
		//f1.i1++;   ����final���ε����Ա�ʾ���ɸı��
		System.out.println("f1:i3=" + f1.i3 + ",i4=" + f1.i4);//f1��f2��i4ֵ��ͬ��������static������
		System.out.println("f2:i3=" + f2.i3 + ",i4=" + f2.i4);
		
		f1.v1.i++;
		f1.v2.i++;
		f1.v1 = new Value();
		//f1.v2 = new Value();  final����������ʾ�����ò��ܸı䣬���������ǿ��Ըı��
		
		for (int i=0; i<f1.a.length; i++) {
			f1.a[i]++;
			System.out.println(f1.a[i]);
		}
		int[] b = {1,2,3};
		//f1.a = b;       final���������������������ͬ����ʾ�����ò��ܸı䣬���������ǿ��Ըı��
	}
}

class Value {
	int i = 1;
}

class FinalData {
	//��������������Ϊ�����ڵĳ���
	final int i1 = 2;
	static final int I2 = 5;   //ע����ں��й̶���ʼ��ֵ���������ڳ������� fianl static�����������ͣ����ǵ����ָ��ݹ���Ҫȫ�����ô�д��
	
	//��������������Ϊ�����ڵĳ���,���Բ���final���ε����Ծ�һ�����ڱ����ڸ�ֵ
	final int i3 = (int) (Math.random()*20);
	static final int i4 = (int) (Math.random()*20);
	
	//�ǻ�����������
	Value v1 = new Value();
	final Value v2 = new Value();
	
	//final int i5;  final���ε����Ա��븳ֵ    �����ڹ��췽���и�ֵ����Ϊ���췽��һ���ᱻ���ã�����һ���ḳֵ
	//				  ��������ͨ�����и�ֵ����Ϊ��ͨ������һ���ᱻ���ã����Բ�һ���ᱻ��ֵ
	//final Value v3;
	
	//����
	final int[] a = {1,2,3,4,5};
}
/*
 ***************jdk1.8���н��*************** 
f1:i3=10,i4=7
f2:i3=15,i4=7
2
3
4
5
6
 */
