/*
  ʱ�䣺2016��9��29��16:23:01
  Ŀ�ģ��ֽ������ַ���������һ
  ���ۣ�������ֽ�������ʾ�ĺ��־Ϳ���Ϊ���룬�����ַ������ٶȿ�
*/

import java.io.*;

public class Liu1_zijie_zifu1{
	public static void main(String[] args) throws Exception{//�����׳��쳣
		FileReader fr = new FileReader("G:\\java\\����\\Liu1_zijie_zifu1.java");//�������ַ�����FileInputStreamΪ�ֽ���
		int ch;//��ȡ����Ϊ����
		int cnt = 0;
		
		ch = fr.read();
		while (-1 != ch){
			++cnt;
			System.out.printf("%c", (char)ch);
			ch = fr.read();
		}
		System.out.printf("���ļ��ַ��ĸ���Ϊ��%d", cnt);
		fr.close();
	}
}
/*
****************���**************
/*ʱ�䣺2016��9��29��16:23:01
Ŀ�ģ��ֽ������ַ���������*/

//import java.io.*;
//
//public class Liu1_zijie_zifu{
//        public static void main(String[] args) throws Exception{//�����׳��쳣
//                FileReader fr = new FileReader("G:\\java\\����\\Liu1_zijie_zifu.
//java");//�������ַ�����FileInputStreamΪ�ֽ���
//                int ch;//��ȡ����Ϊ����
//                int cnt = 0;
//
//                ch = fr.read();
//                while (-1 != ch){
//                        ++cnt;
//                        System.out.printf("%c", (char)ch);
//                        ch = fr.read();
//                }
//                System.out.printf("���ļ��ַ��ĸ���Ϊ��%d", cnt);
//                fr.close();
//        }
//}
///*
//****************���**************
//*/���ļ��ַ��ĸ���Ϊ��524
*/