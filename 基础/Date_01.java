/*
ʱ�䣺2016��10��30��20:15:21
Ŀ�ģ�date�ĸ�ʽ��
*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

public class Date_01{
	public static void main(String[] args){
		Date date = new Date();//�õ���ǰϵͳʱ��
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");//���ø�ʽ
		System.out.println(sdf.format(date));
		
		//���ַ���ת��ΪDate����
		String d = "1970-12-12 11:11:11.0";//�����Ǵ˸�ʽ��.0���������˼
		Timestamp ts = Timestamp.valueOf(d);
		System.out.println(ts);
		
		//util->sql
		java.sql.Date d3 = new java.sql.Date(date.getTime());
		System.out.println(d3);
		//util->Timestamp
		java.sql.Timestamp d4 = new java.sql.Timestamp(date.getTime());
		System.out.println(d4);
		//sql->util
		Date d5 = new Date(d3.getTime());
		System.out.println(d5);
	}
}
/*
***************JDK1.8���н��****************
Fri Sep 22 15:48:49 CST 2017
2017��09��22��15ʱ48��49��
1970-12-12 11:11:11.0
2017-09-22
2017-09-22 15:48:49.75
Fri Sep 22 15:48:49 CST 2017
*/