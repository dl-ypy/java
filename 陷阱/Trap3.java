package javaTest;

/**
 * data:2018��3��22��20��48��
 * @author joker
 * Java��������֮��new StringBuffer() ��������''
 */
public class Trap3{
	public static void main(String[] args){
		StringBuffer s = new StringBuffer('a');
		s.append("b");
		System.out.println(s);  //ֻ���b,��Ϊnew��ʱ���õ�ʱ�����ţ�char���Զ�ת��Ϊint���ͣ���ʾΪStringBuffer������
	}
	
}

/**
 * JDK1.8���н��
 * b
*/