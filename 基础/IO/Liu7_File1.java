import java.io.File;
import java.io.IOException;

/**
 * date:2017年5月14日11:12:09
 * target:File创建。
 * @author ypy 
 * conclusion:
 *     (1)不论是文件还是目录都使用File类操作;
 *     (2)File类只提供操作文件及目录的方法，并不能访问文件的内容，所以他描述的是文件本身的属性;
 *     (3)如果要访问文件本身，用到了我们以后要学习的IO流.  
 */
public class Liu7_File1 {
	//文件数据
	private static void fileData(File f) {
		System.out.println("------------------" + 
		"\n 绝对路径: " + f.getAbsolutePath() +
		"\n 可读？: " + f.canRead() +
		"\n 可写？: " + f.canWrite() +
		"\n 可执行？: " + f.canExecute() +
		"\n 文件/目录名: " + f.getName() +
		"\n 父目录: " + f.getParent() +
		"\n 相对路径: " + f.getPath() +
		"\n length: " + f.length() +
		"\n 最后被修改的时间: " + f.lastModified() + //用与时间点（1970 年 1 月 1 日，00:00:00 GMT）之间的毫秒数表示
		"\n------------------");
		//判断是目录还是文件
		if(f.isFile())
			System.out.println("it's a file");
		else if(f.isDirectory())
			System.out.println("it's a directory");
		}
	
	public static void main(String[] args) {
		File directory = new File("java\\ypy");//目录   这里只是创建了目录对象，并没有真正创建文件或目录
		File file = new File("java\\ypy\\A.java");// 文件
		fileData(directory);
		fileData(file);
		//判断目录是否存在
		if (directory.exists()) {
			System.out.println(directory + " 已经存在！");
			//判断文件是否存在
			if (file.exists()) {
				System.out.println(file + " 已经存在！");
				//System.out.println("正在删除..." + file);
				//file.delete();
			} else {
				try {
					file.createNewFile();  //创建文件
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			//创建
			System.out.println("创建... " + directory);
			directory.mkdirs();   //创建目录
			System.out.println("创建... " + file);
			try {
				file.createNewFile();  //创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileData(directory);
			fileData(file);
			//System.out.println("更名...");
			//old.renameTo(new File("update"));
		}
	}
}
/*
 *************** jdk1.8运行结果*************** 
------------------
 绝对路径: G:\java\基础\IO\java\ypy
 可读？: false
 可写？: false
 可执行？: false
 文件/目录名: ypy
 父目录: java
 相对路径: java\ypy
 length: 0
 最后被修改的时间: 0
------------------
------------------
 绝对路径: G:\java\基础\IO\java\ypy\A.ja
 可读？: false
 可写？: false
 可执行？: false
 文件/目录名: A.java
 父目录: java\ypy
 相对路径: java\ypy\A.java
 length: 0
 最后被修改的时间: 0
------------------
创建... java\ypy
创建... java\ypy\A.java
------------------
 绝对路径: G:\java\基础\IO\java\ypy
 可读？: true
 可写？: true
 可执行？: true
 文件/目录名: ypy
 父目录: java
 相对路径: java\ypy
 length: 0
 最后被修改的时间: 1495097810000
------------------
it's a directory
------------------
 绝对路径: G:\java\基础\IO\java\ypy\A.java
 可读？: true
 可写？: true
 可执行？: true
 文件/目录名: A.java
 父目录: java\ypy
 相对路径: java\ypy\A.java
 length: 0
 最后被修改的时间: 1495097810000
------------------
it's a file
 */
