/*
    ʱ�䣺2016��1��25��19:36:20
    Ŀ�ģ�printf��println������
*/
class Dian
{
    public int x, y;

    public Dian(int x, int y)
    {
	this.x = x;
	this.y = y;
    }

    public String toString()
    {
	return "[" + x + ", " + y + "]";
    }
}

public class println
{
    public static void main(String[] args)
    {
	Dian d = new Dian(3, 2);
	System.out.printf("%s\n", d);
	System.out.println(d);

	int i, j, k;
	i = 1;
	j = 2;
	k = 3;
	System.out.printf("%d��ֵ + %d��ֵ�� %d\n", i, j, k);
	System.out.println(i + "��ֵ + " + j + "��ֵ�� " + k);

	int m = 47;
	System.out.printf("ʮ��������%d��ʮ�����Ʊ�ʾ�ǣ�%#X\n", m, m);
	System.out.println("ʮ��������" + m + "��ʮ�����Ʊ�ʾ�ǣ�OX" + Integer.toHexString(m).toUpperCase());
	//   Integer.toHexString(m) ��ʾm��ʮ������   toUpperCase() ��ʾ�ô�д��ĸ
    }
}
/*
***************���***************
[3, 2]
[3, 2]
1��ֵ + 2��ֵ�� 3
1��ֵ + 2��ֵ�� 3
ʮ��������47��ʮ�����Ʊ�ʾ�ǣ�0X2F
ʮ��������47��ʮ�����Ʊ�ʾ�ǣ�OX2F
*/
