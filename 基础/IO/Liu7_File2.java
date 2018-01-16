import java.io.File;
import java.io.FilenameFilter;

/**
 * date:2017年5月14日09:58:51
 * target:通过File查找当前目录下的文件，实现目录列表。
 * @author ypy         
 */
public class Liu7_File2 {
	public static void main(String[] args) {
		File path = new File(".");//表示当前路径
		String[] list, list2;
		list = path.list();//list方法返回的是一个数组
		System.out.println("本目录下所有目录及文件：");
		for (int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
		
		System.out.println("-------------------");
		
		System.out.println("本目录下指定目录或文件名：");
		list2 = path.list(new DirFilter(".txt"));
		for (int i=0; i<list2.length; i++) {
			System.out.println(list2[i]);
		}
	}
}

class DirFilter implements FilenameFilter {
	String afn;
	public DirFilter(String afn) {
		this.afn = afn;
	}
	@Override
	public boolean accept(File dir, String name) {//list集合会为目录下每个文件调用此方法
		String f = new File(name).getName();//确保得到的是文件名
		return f.indexOf(afn) != -1;//判断是否存在文件afn,若存在则返回该文件的起点索引，若没有，则返回-1
	}




/*使用匿名内部类实现
public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		
		list = path.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String f = new File(name).getName();
				return f.indexOf(".txt") != -1;
			}
		});
		
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
*/
	
}
/*
 * *************** jdk1.8运行结果*************** 
 * 本目录下所有目录及文件：
 * Liu1_zijie_zifu1.java
 * Liu1_zijie_zifu2.java
 * Liu2_Buffer1.java
 * Liu2_Buffer2.java
 * Liu3_Data.java
 * Liu4_print1.java
 * Liu4_print2.java
 * Liu5_zhuanhuan.java
 * Liu6_Object.java
 * Buffer.txt
 * Buffer2.txt
 * data.txt
 * Error.txt
 * object_output.txt
 * Out.txt
 * print.txt
 * zijie_zifu.txt
 * Liu7_File1.java
 * Liu7_File1.class
 * DirFilter.class
 * -------------------
 * 本目录下指定目录或文件名：
 * Buffer.txt
 * Buffer2.txt
 * data.txt
 * Error.txt
 * object_output.txt
 * Out.txt
 * print.txt
 * zijie_zifu.txt
 */
