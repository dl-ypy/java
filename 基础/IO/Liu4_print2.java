/*
时间：2016年10月12日10:06:58
目的：标准输入输出的重定向
			通过print流输出到文件，并且把错误信息输出到文件
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
			System.setOut(psOut);//将System.out输出的设备更改为psOut所关联的文件
			System.setErr(psError);//将System.err输出的设备更改为psError所关联的文件
			
			while (true){
				num = sc.nextInt();
				System.out.println(num);//此时就会输出到文件中
			}
		}catch(Exception e){
			System.err.println("出错的信息是：");
			e.printStackTrace();//默认输出为System.err所关联的设备
		}
	}
}
/*
***************程序运行***************
G:\java\基础>javac Liu4_print.java

G:\java\基础>java Liu4_print
1
5
6
8
9
446515
615
615
sad

G:\java\基础>
*/