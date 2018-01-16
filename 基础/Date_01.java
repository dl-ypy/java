/*
时间：2016年10月30日20:15:21
目的：date的格式化
*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

public class Date_01{
	public static void main(String[] args){
		Date date = new Date();//拿到当前系统时间
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");//设置格式
		System.out.println(sdf.format(date));
		
		//将字符串转换为Date类型
		String d = "1970-12-12 11:11:11.0";//必须是此格式，.0是纳秒的意思
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
***************JDK1.8运行结果****************
Fri Sep 22 15:48:49 CST 2017
2017年09月22日15时48分49秒
1970-12-12 11:11:11.0
2017-09-22
2017-09-22 15:48:49.75
Fri Sep 22 15:48:49 CST 2017
*/