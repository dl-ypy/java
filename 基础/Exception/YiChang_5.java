/*
    ʱ�䣺2016��1��11��20:00:29
    Ŀ�ģ���Щ�쳣���봦����Щ�쳣�ɲ�����
          �˽��쳣�ĵڶ��ִ���ʽ
*/
import java.io.*;//throw���׳�����Ҫ����io��

class A
{
    public void f() throws IOException//throw������쳣���󣨼�new�����쳣��(����new)(�������ͨ�࣬������ͨ��ʱ���͵�д�� ��������extends Exception)  
	                              // ��throws��ʾ�����������ߣ�main����������
	                              // ��Ȼmain����Ҳû��������Ҳû���ã����Բ�����
				      // ���main���������� f()����������ͻ������ʱ����Ҫ  try catch �����д���
				      // throws A��A����Ϊ�ɴ����ɲ�������쳣�� Ҳ����Ϊ���봦����쳣�������Խ������ʱ������throws�׳����쳣���д���
				      // throws A����ʾf����һ�����׳�A�쳣�����ԣ��������ڲ��Ѿ���A�쳣�����˴�������Ҫthrows A
    {
    	throw new IOException();//  ����쳣���봦��������ͱ��벻��
    }

    public void g()
    {
	throw new ArithmeticException();  //���쳣�Ͳ��ش���Ҳ�ܱ���ɹ�
    }
}

public class YiChang_5
{
    public static void main(String[] args)
    {
	A aa = new A();
    }
}
/*
���ۣ�RuntimeException��ϵͳ�쳣��������Ϳɴ���ɲ�����
*/
