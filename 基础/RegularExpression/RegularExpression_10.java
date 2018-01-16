/*
时间：2016年11月9日11:24:05
目的：通过正则表达式统计代码的行数
*/
import java.io.*;

public class RegularExpression_10{
	static long normalLines = 0;//正常行数
	static long commentLines = 0;//注释的行数
	static long whiteLines = 0;//空白行数
	
	public static void main(String[] args){
		File f = new File("I:\\java\\基础");//这里必须是目录
		File[] codeFiles = f.listFiles();//返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件
		for (File child : codeFiles){
			if (child.getName().matches(".*\\.java$")){//判断是否是Java文件
				parse(child);
			}
		}
		
		System.out.println("normalLines:" + normalLines);
		System.out.println("commentLines:" + commentLines);
		System.out.println("whiteLines:" + whiteLines);
	}
	
	private static void parse(File f){
		BufferedReader br = null;
		boolean comment = false;
		
		try{
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line=br.readLine()) != null){
				line = line.trim();//此字符串移除了前导和尾部空白的副本；如果没有前导和尾部空白，则返回此字符串。
				if (line.matches("[\\s&&[^\\n]]*$")){//判断空白行
					whiteLines++;
				}else if (line.startsWith("/*") && !line.endsWith("*/")){//用/**/注释的非单行的
					commentLines++;
					comment = true;//这表示用/**/注释的多行的行数已经开始
				}else if (line.startsWith("/*") && line.endsWith("*/")){//用/**/注释的单行的
					commentLines++;
				}else if (true == comment){//计算用/**/注释的多行的行数
					commentLines++;
					if (line.endsWith("*/")){
						comment = false;
					}
				}else if (line.startsWith("//")){//用//注释的行
					commentLines++;
				}else{
					normalLines++;
				}
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		finally{
			if (br != null){
				try{
					br.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
/*
***************JDK1.8运行结果***************
normalLines:2292
commentLines:1486
whiteLines:410
*/