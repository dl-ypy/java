/*
    ʱ�䣺2016��1��17��19:45:27
    Ŀ�ģ�toString��ʵ�ó��������
*/
class Dian
{
    public int x, y;

    public Dian(int x, int y)
    {
	this.x = x;
	this.y = y;
    }

    public String toString()//��д�����toString����
    {
	return "[" + x + "," + y + "]";
    }
}

public class ToString_2
{
    public static void main(String[] args)
    {
	Dian d = new Dian(1, 2);
	System.out.println(d);// ����͵�����toString����,ע���õ���println
    }
}
/*
***************���***************
[1,2]
*/
