/*
    ʱ�䣺2016��1��22��08:23:25
    Ŀ�ģ�equals������ʹ�á�
*/
class A
{
    public int i;

    public A(int i)
    {
	this.i = i;
    }
}

public class Equals_1
{
    public static void main(String[] args)
    {
	A aa1 = new A(2);
	A aa2 = new A(2);
	//new ����������ռ䣬��4��ռ�
	
	System.out.println(aa1.equals(aa2));//equals��������boolean����
	                                     //==�Ƚϵ������������ǲ���ָ��ͬһ���ڴ��ַ,
	                                     //equals�Ƚϵ������������ʵ�������ǲ�����ͬ��equals()��Ĭ����Ϊ�ǱȽ����ã���java�ڲ����Ѿ�����������޸ģ���Ϊ�Ƚϵ������������ʵ�����ݣ�
	                                     //����java�ڲ�����  ��String  new String().equals(new String()) ����true
	                                     //�Լ��������Ҫ��new������ֵequalsΪtrue��������дhashCode()
    }
}
/*
***************���**************
false
*/
