/*
  时间：2016年9月29日16:23:01
  目的：字节流与字符流的区别一
  结论：如果用字节流，显示的汉字就可能为乱码，而且字符流的速度快
*/

import java.io.*;

public class Liu1_zijie_zifu1{
	public static void main(String[] args) throws Exception{//必须抛出异常
		FileReader fr = new FileReader("G:\\java\\基础\\Liu1_zijie_zifu1.java");//这里是字符流，FileInputStream为字节流
		int ch;//读取到的为整型
		int cnt = 0;
		
		ch = fr.read();
		while (-1 != ch){
			++cnt;
			System.out.printf("%c", (char)ch);
			ch = fr.read();
		}
		System.out.printf("该文件字符的个数为：%d", cnt);
		fr.close();
	}
}
/*
****************结果**************
/*时间：2016年9月29日16:23:01
目的：字节流与字符流的区别*/

//import java.io.*;
//
//public class Liu1_zijie_zifu{
//        public static void main(String[] args) throws Exception{//必须抛出异常
//                FileReader fr = new FileReader("G:\\java\\基础\\Liu1_zijie_zifu.
//java");//这里是字符流，FileInputStream为字节流
//                int ch;//读取到的为整型
//                int cnt = 0;
//
//                ch = fr.read();
//                while (-1 != ch){
//                        ++cnt;
//                        System.out.printf("%c", (char)ch);
//                        ch = fr.read();
//                }
//                System.out.printf("该文件字符的个数为：%d", cnt);
//                fr.close();
//        }
//}
///*
//****************结果**************
//*/该文件字符的个数为：524
*/