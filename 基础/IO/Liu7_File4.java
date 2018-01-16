import java.io.File;
import java.io.IOException;

/**
 * date:2017年7月7日09:28:19
 * target:创建，删除文件、目录。
 * @author ypy
 */
public class Liu7_File4 {
	public static void main(String[] args) {
		createDir("G:\\a\\");
		createFiles(new String[]{"G:\\a\\1.txt","G:\\a\\2.txt","G:\\a\\3.txt"});
		deleteFileByName("G:\\a\\1.txt");
		deleteFilesByName("G:\\a\\");
		deleteDir("G:\\a\\");
	}
	
	//创建文件夹
	public static void createDir(String path) {
		File f = new File(path);
		if (f.exists()) {
			f.delete();
		}
		//注：不能用isDirectory()判断不存在的目录是否是目录！！！
		f.mkdirs(); //创建文件夹只用这个
	}
	
	//批量创建多个文件
	public static void createFiles(String[] filesName) {
		for (String name : filesName) {
			File file = new File(name);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//根据文件名删除文件
	public static void deleteFileByName(String name) {
		File f = new File(name);
		if (f.exists() && f.isFile()) {
			f.delete();
		}
	}
	
	//批量删除一个目录下的多个文件
	public static void deleteFilesByName(String path) {
		File f = new File(path);
		if (f.exists() && f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				file.delete();
			}
		}
	}
	
	
	//删除一个文件夹及其子文件    只能用递归删除,因为delete方法只能删除空文件夹（无文件与子目录）
	public static void deleteDir(String pathName) {
		File file = new File(pathName);
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					deleteDir(f.getAbsolutePath());
				}
				file.delete();
			} else {
				file.delete();
			}
		}
	}
}

/*
***************JDK1.8运行结果****************
*/
