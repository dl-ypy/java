/*
ʱ�䣺2016��10��12��10:06:58
Ŀ�ģ���׼����������ض���
			ͨ��print��������ļ������ҰѴ�����Ϣ������ļ�
*/
import java.util.*;
import java.io.*;

public class Liu4_print2{
	public static void main(String[] args){
		PrintStream psOut = null;
		PrintStream psError = null;
		Scanner sc = null;
		
		try{
			psOut = new PrintStream("Out.txt");
			psError = new PrintStream("Error.txt");
			sc = new Scanner(System.in);
			int num;
			System.setOut(psOut);//��System.out������豸����ΪpsOut���������ļ�
			System.setErr(psError);//��System.err������豸����ΪpsError���������ļ�
			
			while (true){
				num = sc.nextInt();
				System.out.println(num);//��ʱ�ͻ�������ļ���
			}
		}catch(Exception e){
			System.err.println("�������Ϣ�ǣ�");
			e.printStackTrace();//Ĭ�����ΪSystem.err���������豸
		}
	}
}
/*
***************��������***************
G:\java\����>javac Liu4_print.java

G:\java\����>java Liu4_print
1
5
6
8
9
446515
615
615
sad

G:\java\����>
*/