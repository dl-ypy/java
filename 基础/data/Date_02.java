/*
ʱ�䣺2016��10��31��10:37:26
Ŀ�ģ��õ��·�
*/
import java.util.*;
import java.text.*;

public class Date_02{
	public static void main(String[] args){
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);//���Եõ�һ����ϵͳʱ���date�����е��·�
		System.out.println(c.get(Calendar.MONTH)+1);//�õ����·��Ǵ�0��ʼ�ģ�����Ҫ��һ
	}
}
/*
***************JDK1.8���н��***************
10
*/