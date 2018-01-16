/*
	时间：2016年10月11日08:45:23
	目的：通过数据流读取长整数
*/
import java.io.*;

public class Liu3_Data{
	public static void main(String[] args) throws Exception{
		long m = 1234567;//想要读取一个长整型,就需要writeLong(),readLong()方法，所以，就想到DataInputStream,DataOutputStream。
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//无参数，它会自动创建一个byte数组
		DataOutputStream dos = new DataOutputStream(baos);//查文档，文档中构造方法的参数为OutputStream类型，但这里需要一个byte数组存放数据，就想到ByteArrayOutputStream
		//执行完上述代码，程序就通过管道指向一个byte数组，该管道是包裹流DataOutputStream包裹的原始流ByteArrayOutputStream
		dos.writeLong(m);//把m写入byte数组
		dos.flush();
		
		byte[] buf = baos.toByteArray();//创建一个新分配的byte数组，并将原数组中的数据传进去
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		DataInputStream dis = new DataInputStream(bais);
		System.out.println("长整型数为：" + dis.readLong());
	}
}
/*
***************结果***************
长整型数为：1234567
*/