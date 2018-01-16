import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * date:2017年6月17日21:31:04
 * target:编写一个程序，将 d:\java目录下的所有.java文件复制到 d:\jad 目录下，并将原来文件的扩展名从 将原来文件的扩展名从.java  改为.jad 。
 * @author ypy
 */
public class CopyAndRenameFiles {
	public static void main(String[] args) throws Exception {
		File srcDir = new File("java");    //事先创建一个java目录，里面放几个java文件
		if (!(srcDir.exists() && srcDir.isDirectory())) {   //判断是否存在且是否是目录
			throw new Exception("目录不存在！");
		}
		
		//返回一个抽象路径名数组，表示由此抽象路径名表示的满足指定过滤器的目录中的文件和目录。
		//得到一个文件数组，里面存放以".java"结尾的文件。
		File[] files = srcDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		
		System.out.println("操作" + files.length + "个java文件。");
		
		//新建存放.jad文件的目录
		File destDir = new File("jad");
		if (!destDir.exists())
			destDir.mkdirs();
		
		for (File f : files) {
			FileInputStream fis = new FileInputStream(f);
			String destFileName = f.getName().replaceAll("\\.java$", ".jad");//得到每个文件名，并将.java替换为.jad
			FileOutputStream fos = new FileOutputStream(new File(destDir, destFileName));
			copy(fis, fos);
			fis.close();
			fos.close();
		}
	}
	
	//把ips中的内容写入到ops中
	public static void copy(InputStream ips, OutputStream ops) throws IOException {
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len=ips.read(buf)) != -1) {
			//从buf中的0开始，写len个字节到此输出流
			ops.write(buf, 0, len);
		}
	}
}
/*
 *************** jdk1.8运行结果***************
 操作2个java文件。
 */
