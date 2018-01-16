/*
时间：2016年10月31日10:37:26
目的：得到月份
*/
import java.util.*;
import java.text.*;

public class Date_02{
	public static void main(String[] args){
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);//可以得到一个非系统时间的date类型中的月份
		System.out.println(c.get(Calendar.MONTH)+1);//得到的月份是从0开始的，所以要加一
	}
}
/*
***************JDK1.8运行结果***************
10
*/