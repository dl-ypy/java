/*
	ʱ�䣺2016��10��11��08:45:23
	Ŀ�ģ�ͨ����������ȡ������
*/
import java.io.*;

public class Liu3_Data{
	public static void main(String[] args) throws Exception{
		long m = 1234567;//��Ҫ��ȡһ��������,����ҪwriteLong(),readLong()���������ԣ����뵽DataInputStream,DataOutputStream��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//�޲����������Զ�����һ��byte����
		DataOutputStream dos = new DataOutputStream(baos);//���ĵ����ĵ��й��췽���Ĳ���ΪOutputStream���ͣ���������Ҫһ��byte���������ݣ����뵽ByteArrayOutputStream
		//ִ�����������룬�����ͨ���ܵ�ָ��һ��byte���飬�ùܵ��ǰ�����DataOutputStream������ԭʼ��ByteArrayOutputStream
		dos.writeLong(m);//��mд��byte����
		dos.flush();
		
		byte[] buf = baos.toByteArray();//����һ���·����byte���飬����ԭ�����е����ݴ���ȥ
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bais);
		System.out.println("��������Ϊ��" + dis.readLong());
	}
}
/*
***************���***************
��������Ϊ��1234567
*/