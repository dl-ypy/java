package javaTest;

/**
 * data:2018��3��26��20��10��
 * @author joker
 * Java��������֮��j=j++����
 */
public class Trap4{
	public static void main(String[] args){
		int j = 0;
		for (int i=0; i<100; i++) {
			j = j++;//���Ƚ�j����j,�����ջ����ʱ��ջ�е�jΪ0��,�ٽ���++,����++������ʱ�򣬻��ڱ��������·���һ���ռ䣬
					//ִ��++�������Ǳ������е�j���������е�jΪ1�������������е�j�ḳ����ջ�е�j������jΪ0��
					//�������j=++j�Ϳ���
		}
		System.out.println(j);  
	}
}

/**
 * JDK1.8���н��
 * 0
*/