/*
    ʱ�䣺2015��12��29��14:34:52
    Ŀ�ģ��ӿڵļ̳����⡣
*/
interface It1
{
    int i = 10;
    public void f();
}

interface It2
{
    
}

interface It3 extends It1,It2// �ӿڿ��Լ̳нӿڣ����ҿ�ʵ�ֶ�̳У����ӿڲ���ʵ�ֽӿڡ�
{
}

class A
{
    
}

abstract class B extends A implements It1,It2// ͬʱʵ�ּ̳����ʵ�ֽӿڣ�˳�������extends��ǰ��implements�ں�
{
}

public class Jiekou_2
{
    public static void main(String[] args)
    {
	
    }
}
