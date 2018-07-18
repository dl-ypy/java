/*
时间：2016年11月1日08:39:49
目的：拿到外国时间
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
***************JDK1.8运行结果****************
9
*/