/*
ʱ�䣺2016��11��1��08:39:49
Ŀ�ģ��õ����ʱ��
*/
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

public class Date_03{
	public static void main(String[] args){
		Calendar cJapan = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
		System.out.println(cJapan.get(Calendar.HOUR_OF_DAY));
	}
}
/*
***************JDK1.8���н��****************
9
*/